package com.study.designpattern.decoratorpattern;

/**
 * 老爸看成绩单了
 * @author komi
 *
 */
public class Father {
	public static void main(String[] args){
		//第一种：通过一个类来美化成绩单
		//成绩单拿过来
		/*SchoolReport schoolReport = new SugarFouthGradeSchoolReport();
		//看成绩单
		schoolReport.report();
		//然后老爸，一看，很开心，就签名了
		schoolReport.sign("老三"); //我叫老三
		 */		
		//第二种：装饰模式来美化成绩单
		//成绩单拿过来
		SchoolReport sr;
		sr = new FouthGradeSchoolReport(); //原装的成绩单
		//加 了最高分说明的成绩单
		sr = new HighScoreDecorator(sr);
		//又加了成绩排名的说明
		sr = new SortDecorator(sr);
		
		//看成绩单
		sr.report();
		//然后老爸，一看，很开心，就签名了
		sr.sign("老三"); //我叫老三
	}
}
