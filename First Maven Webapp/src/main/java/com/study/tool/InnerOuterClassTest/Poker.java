package com.study.tool.InnerOuterClassTest;

/**
 * 扑克类(一副扑克)
 * @author komi
 */
public class Poker {
	public static void main(String[] args) {
		Poker p1 = new Poker();
		Card c1 = p1.new Card("红",1);//对于非静态内部类Card,只有通过其外部类Poker对象才能创建Card对象
		
	}
	//花色
	private static String[] suites = {"黑桃","红桃","草花","方块"};
	//点数
	private static int[] faces = {1,2,3,4,5,6,7,8,9,10,11,12,13};
	private Card[] cards;

	/*
	 * 构造器
	 */
	public Poker(){
		cards = new Card[52];
		for(int i=0;i<suites.length;i++){
			for(int j=0;j<faces.length;j++){
				cards[i*13+j] = new Card(suites[i],faces[j]);
			}
		}
	}
	/**
	 * 洗牌(随机乱序)
	 */
	public void shuffle(){
		for(int i=0,len=cards.length;i<len;i++){
			//产生0-51随机数
			int index = (int)(Math.random()*len);//Math.random()产生[0,1)随机数
			Card temp = cards[index];
			cards[index] = cards[i];
			cards[i] = temp;
		}
	}
	
	/**
	 * 发牌
	 * @param index 发牌的位置
	 * @return Card 返回一张牌
	 */
	public Card deal(int index){
		return cards[index];
	}
	
	/**
	 * 卡片类(一张扑克)
	 * [内部类]
	 * @author komi
	 *
	 */
	public class Card{
		private String suite;//花色
		private int face;//点数
		public Card(String suite,int face){
			this.suite = suite;
			this.face = face;
		}
		@Override
		public String toString(){
			String faceStr = "";
			switch(face){
			case 1:faceStr = "A";break;
			case 11:faceStr = "J";break;
			case 12:faceStr = "Q";break;
			case 13:faceStr = "K";break;
			default:faceStr = String.valueOf(face);
			}
			return suite+faceStr;
		}
	}

}
