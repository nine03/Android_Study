
public class exam16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt("100"); // 문자열을 정수로 변환
		int b = Integer.parseInt("200"); // 문자열을 정수로 변환
		System.out.println("1번 : " + (a + b));
		 //  정수를 문자열로 변환
		System.out.println("2번 : " + (Integer.toString(a) + Integer.toString(b))); 

		double c = Double.parseDouble("100.123"); // 문자열을 실수로 변환
		double d = Double.parseDouble("200.123"); // 문자열을 실수로 변환
		System.out.println("3번 : "+ (c +d));
		// 실수를 문자열로 변환
		System.out.println("4번 : " + (Double.toString(c) + Double.toString(d))); 
	}
}