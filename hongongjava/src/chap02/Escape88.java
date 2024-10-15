package chap02;

public class Escape88 {

	public static void main(String[] args) {
		 System.out.println("번호\t이름\t직업");
		 System.out.print("행 단위 출력 \n");
		 System.out.print("행 단위 출력\n");
		 System.out.println("우리는 \"개발자 \" 입니다.");
		 System.out.print("봄\\여름\\가을\\겨울\n");
//		 그줄 복사 ctrl + alt + 아래 화살표
		 
		 
//		 p91
		 boolean stop = true;
		 if(!stop) {
			 System.out.println("중지합니다.");
		 }else {
			 System.out.println("시작합니다.");
		 }
		 
//		 p103
//		 타입변환
		 byte byteValue1 = 10;
		 byte byteValue2 = 20;
		 int intValue1 = byteValue1 + byteValue2;
		 System.out.println(intValue1);
		 
		 char charValue1 = 'A';
		 char charValue2 = 1;
		 int  intValue2 = charValue1 + charValue2;
		 System.out.println("유니코드 : " + intValue2);
		 System.out.println("출력문자 : " + (char) intValue2);
		 
		 int intValue3 = 10;
		 int intValue4 = intValue3/4;
		 System.out.println(intValue4);
		 
		 int intValue5 = 10;
		 double doubleValue1 = intValue5 / 4.0;
		 System.out.println(doubleValue1);
		 
		 int x = 1;
		 int y = 2;
		 double result = (double) x / y;
		 System.out.println(result);
		 
		 
//		 p106
		 int value1 = Integer.parseInt("10");
		 double value2 = Double.parseDouble("3.14");
		 boolean value3 = Boolean.parseBoolean("true");
		 
		 System.out.println("value1: " + (value1 + 100));
		 System.out.println("value2: " + (value2 + 100));
		 System.out.println("value3: " + value3);
		 
		 String str1 = String.valueOf(10);
		 String str2 = String.valueOf(3.14);
		 String str3 = String.valueOf(true);
		 
		 System.out.println("str1: " + (str1 + 100));
		 System.out.println("str2: " + (str2 + 100));
		 System.out.println("str3: " + str3);
		
		 
//		 p107~p110
		 
		 char c1 = 'a';
		 int c2 = c1 + 1;
		 System.out.println((char)c2);
		 System.out.println(c2);
		 
		 double var1 = 3.5;
		 double var2 = 2.7;
		 int result6 = (int)(var1 + var2);
		 System.out.println(result6);
		 
		 long su1 = 2L;
		 float su2 = 1.8f;
		 double su3 = 2.5;
		 String su4 = "3.9";
		 int result9  = (int) (su1 + (int)su2 + su3 + Double.parseDouble(su4));
		 System.out.println(result9);
		 
		 
		 
		 
		 
		 
	}//end main

}//end class
