package com.study.tags;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

public class TimeTag extends TagSupport {
	private static final long serialVersionUID = 1L;
	private String format = "yyyy-MM-dd hh:mm:ss";
	private String foreColor = "red";
	private String backColor = "green";
	public int doStartTag(){
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		JspWriter writer = pageContext.getOut();
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("<span style='color:%s;background-color:%s'>%s</span>", 
				foreColor,backColor,sdf.format(new Date())));
		try {
			writer.print(sb.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public void setFormat(String format) {
        this.format = format;
    }

    public void setForeColor(String foreColor) {
        this.foreColor = foreColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }
}
