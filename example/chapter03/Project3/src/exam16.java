
public class exam16 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = Integer.parseInt("100"); // ���ڿ��� ������ ��ȯ
		int b = Integer.parseInt("200"); // ���ڿ��� ������ ��ȯ
		System.out.println("1�� : " + (a + b));
		 //  ������ ���ڿ��� ��ȯ
		System.out.println("2�� : " + (Integer.toString(a) + Integer.toString(b))); 

		double c = Double.parseDouble("100.123"); // ���ڿ��� �Ǽ��� ��ȯ
		double d = Double.parseDouble("200.123"); // ���ڿ��� �Ǽ��� ��ȯ
		System.out.println("3�� : "+ (c +d));
		// �Ǽ��� ���ڿ��� ��ȯ
		System.out.println("4�� : " + (Double.toString(c) + Double.toString(d))); 
	}
}