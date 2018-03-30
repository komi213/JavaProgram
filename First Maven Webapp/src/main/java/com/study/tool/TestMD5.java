package com.study.tool;
import java.security.MessageDigest;

public class TestMD5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String originData="amount=1&check_name=NO_CHECK&desc=佣金&mch_appid=wx065baca1ee237306&mchid=1361437802&nonce_str=V3UXDNTFCLX6X4SFPQMCM5TGUFZGCCVL&openid=oN0ACwAwldE3pZxDJmtSpI2f1I4M&partner_trade_no=123456&spbill_create_ip=120.76.226.38&key=seehow123456789abcdefghijkseehow";
		String originData = " ";
		String a = MD5(originData);
		System.out.println(originData+"\r\n转MD5后:"+a);

	}
	
	public static String MD5(String src) {
		try {
			if (src == null) {
				return "";
			}
			byte[] result = null;
			MessageDigest alg = MessageDigest.getInstance("MD5");//生成信息摘要。
			byte[] bs = src.getBytes("utf-8");
			System.out.println(bs);
			result = alg.digest(src.getBytes("utf-8"));//将要输入的数据转换成字节数组,并且计算摘要
			
			//return byte2String(result);//将字节数组转换成字符串。
			if (result == null) {
				return "";
			}
			StringBuffer hs = new StringBuffer();
			String stmp = null;
			for (int n = 0; n < result.length; n++) {
				stmp = Integer.toHexString(result[n] & 0XFF);
				if (stmp.length() == 1) {
					hs.append("0");
				}
				hs.append(stmp);
			}
			return hs.toString();
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
}
