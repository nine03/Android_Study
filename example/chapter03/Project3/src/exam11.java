
public class exam11 {
	abstract static class Animal {
		String name;
		abstract void move();
	}
	
	static class Tiger extends Animal {
		int age;
		
		Tiger(){
		}
		
		void move() {
			System.out.println("�� �߷� �̵��Ѵ�.");
		}
	}
	
	static class Eagle extends Animal {
		String home;
		
		Eagle(){
		}

		void move() {
			System.out.println("������ �̵��Ѵ�.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal animal; 
		
		animal = new Tiger();
		animal.move();
		
		animal = new Eagle();
		animal.move();
	}
}