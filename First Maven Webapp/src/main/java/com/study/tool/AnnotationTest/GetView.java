package com.study.tool.AnnotationTest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface GetView {
	String Method();
	String Value();
}
