package com.study.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alipay.config.AlipayConfig;
import com.alipay.util.AlipayNotify;
import com.alipay.util.AlipaySubmit;


@Controller
public class AliPayController {
	//写在开头
	/*支付流程：
	先访问​ /deposit 映射下面的方法 ---> 跳转到支付宝的支付界面 ---> 核对支付信息进行支付 (测试一般用1分钱)--->支付成功 --->支付宝同时调用同步和异步方法；

      但是异步方法一般要快于同步方法，因为中间还有一个跳转流程。所以这里特别注意的是：如果你要讲支付宝返回来的信息存入数据库，逻辑一般是写在异步方法里面，同步方法作为页面跳转（跳你自己的网站页面）。如果把逻辑写在同步方法里面，客户在支付成功直接关闭窗口，没返回你的网站的话，它是访问不到你的控制器的。

       而且对于异步方法访问的方法是要在浏览器上直接访问到的！但是一般我们网站都做了权限过滤的，直接方法方法，要先去判断是否登录，没登录一般跳转登录界面。但是不论你是用的过滤器还是 shiro，还是其它的，总之你要暴露出这个方法要让支付宝能访问（不能够跳登录界面）！

        并且这个异步方法返回的jsp不能有其它代码：

        我就只写了：*/
	@RequestMapping("/ali/toPay")
	public String toPay(){
		return "alipay";
	}
	
	@RequestMapping(value = "/ali/pay", method = RequestMethod.POST)
	@ResponseBody  
	public ResponseEntity deposit(HttpServletRequest request,HttpServletResponse response){
	   //防钓鱼时间戳     防钓鱼时间戳这里没写，貌似要先去支付宝申请，要审核一个星期左右，通过了才能用
     
       // 支付类型  
       // 必填，不能修改  
       String payment_type = "1"; 
       // 服务器异步通知页面路径  
       // 需http://格式的完整路径，不能加?id=123这类自定义参数
       String notify_url = "http://127.0.0.1:8080/First/alipay/async";

       // 页面跳转同步通知页面路径  
       // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/  
       String return_url = "http://127.0.0.1:8080/First/alipay/return_url";
       
	   //从支付页面获取值
       //商品名称
       String subject = request.getParameter("WIDsubject");    
       //订单号
       String trade_no = request.getParameter("WIDout_trade_no");    
       // 防钓鱼时间戳  
       // 若要使用请调用类文件submit中的query_timestamp函数  
       //String anti_phishing_key = "";  
       // 客户端的IP地址  
       // 非局域网的外网IP地址，如：  
       String exter_invoke_ip = "";  //可不填
       //支付金额
       String total_fee = request.getParameter("WIDtotal_fee");
       //描述
       String body = request.getParameter("WIDbody");
       
	   //商品展示地址
	   String show_url = "http://www.baidu.com";//可不填

	   Map<String,String> sParaTemp = new HashMap<String,String>();
	   sParaTemp.put("service", "create_direct_pay_by_user");//接口服务----即时到账
	   sParaTemp.put("partner", AlipayConfig.partner);//支付宝PID
	   sParaTemp.put("seller_id", AlipayConfig.seller_id);
	   sParaTemp.put("_input_charset", AlipayConfig.input_charset);//统一编码
	   sParaTemp.put("payment_type", payment_type);//支付类型
	   sParaTemp.put("notify_url", notify_url);//异步通知页面
	   sParaTemp.put("return_url", return_url);//页面跳转同步通知页面
	   //sParaTemp.put("seller_email", "pkessay@126.com");//卖家支付宝账号
	   sParaTemp.put("out_trade_no",trade_no);//商品订单编号
	   sParaTemp.put("subject", subject);//商品名称
	   sParaTemp.put("total_fee", total_fee);//价格
	   sParaTemp.put("body", body);
	   sParaTemp.put("show_url", show_url);
	   sParaTemp.put("exter_invoke_ip", exter_invoke_ip);

	   String sHtmlText = AlipaySubmit.buildRequest(sParaTemp,"get","确认");
	   try {
		   response.setHeader("Pragma", "No-cache");
		   response.setHeader("Cache-Control", "no-cache");
		   response.setContentType("text/html; charset=utf-8");
		   response.getWriter().write(sHtmlText);
		   response.getWriter().close();
	   } catch (IOException e) {
		   e.printStackTrace();
	   }
       return null;
	}
	
	//支付异步通知
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/alipay/async",method = RequestMethod.POST)
	public String async(HttpServletRequest request,HttpServletResponse response){
	   Map<String,String> params = new HashMap<String,String>();  
       Map requestParams = request.getParameterMap();  
       for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {  
           String name = (String) iter.next();  
           String[] values = (String[]) requestParams.get(name);  
           String valueStr = "";  
           for (int i = 0; i < values.length; i++) {  
               valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";  
           }
           params.put(name, valueStr);  
       }  

       //获取返回数据
       String orderTitle = request.getParameter("subject");//订单名称
       String payType = request.getParameter("payment_type");//支付类型
       String outTradeNo = request.getParameter("out_trade_no");//订单号
       String tradeNo = request.getParameter("trade_no");//支付宝交易号
       String notifyId = request.getParameter("notify_id");//支付校验id
       String amount = request.getParameter("total_fee");//交易金额
       String notifyTime = request.getParameter("notify_time");//通知时间       
       String tradeStatus = request.getParameter("trade_status");//交易状态
       String returnId = request.getParameter("extra_common_param");//项目id
       String payer = request.getParameter("buyer_email");//支付者账号              

       if(AlipayNotify.verify(params)){//验证成功  
           if(tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {  
	           //要写的逻辑。自己按自己的要求写
	
	           //封装交易信息实体，存入数据库之类的                                               
	           System.out.println(">>>>>支付成功,异步通知:" + tradeNo);  
           }  
           //return "success/alipay-success";
           return null;
       }else{//验证失败  
           //return "success/alipay-fail";  
    	   return null;
       }

	}
	
   //支付同步通知
   //get请求中文参数乱码问题：
	//1.tomcat server,先remove再clean，
	//2.去eclipse加URIEncoding="utf-8", C:\eclipse\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\conf\server.xml
	//<Connector URIEncoding="utf-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
	//3.tomcat清理干净，重新加入项目。
	//4.双击配置的tomcat server，modules页，编辑项目，去掉  reloading enabled 的勾.
   @RequestMapping(value="/alipay/return_url",method = RequestMethod.GET)
   public String Return_url(HttpServletRequest request,HttpServletResponse response){
	   Map<String,String> params = new HashMap<String,String>(); 
       Map requestParams = request.getParameterMap();  
       for (Iterator iter = requestParams.keySet().iterator(); iter.hasNext();) {  
           String name = (String) iter.next();  
           String[] values = (String[]) requestParams.get(name);  
           String valueStr = "";  
           for (int i = 0; i < values.length; i++) {  
               valueStr = (i == values.length - 1) ? valueStr + values[i]: valueStr + values[i] + ",";  
           }  
           params.put(name, valueStr);  
       }  
       String tradeNo = request.getParameter("trade_no");//支付宝交易号
       String tradeStatus = request.getParameter("trade_status");//交易状态
       if(AlipayNotify.verify(params)){//验证成功  

           if(tradeStatus.equals("TRADE_FINISHED") || tradeStatus.equals("TRADE_SUCCESS")) {  
        	   //要写的逻辑。自己按自己的要求写               

               System.out.println(">>>>>支付成功,同步通知" + tradeNo);  

           }else{
        	   System.out.println(">>>>>交易状态，失败" + tradeNo);  
           }
           //return "success/success";
           return null;
       }else{//验证失败  
           //return "success/fail";
    	   System.out.println(">>>>>return_url返回验证失败" + tradeNo);  
    	   return null;
       }  

     }
	
}
