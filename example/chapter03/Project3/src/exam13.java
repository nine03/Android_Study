interface  clickListener {
	public void print();
}

public class exam13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clickListener listener = (new clickListener() {
				public void print() {
					System.out.println("Ŭ�� �������Դϴ�.");
				}
			});
		listener.print();
	}
}