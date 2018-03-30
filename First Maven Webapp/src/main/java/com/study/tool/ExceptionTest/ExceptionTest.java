package com.study.tool.ExceptionTest;

public class ExceptionTest {
	 public static void main(String[] args){
        try {
            try {
                throw new Sneeze();
            } 
            catch (Annoyance a ) {
            	//根据里氏代换原则[能使用父类型的地方一定能使用子类型]
                System.out.println("Caught Annoyance");
                throw a;
            }
        } 
        catch (Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}
