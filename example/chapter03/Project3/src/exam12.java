interface iAnimal {
	abstract  void eat();
}

public class exam12 {
	abstract static class Animal {
		String name;
		abstract void move();
	}

	static class iCat implements iAnimal {
		public void eat() {
			System.out.println("������ ���� �Ѵ�.");
		}
	}

	static class iTiger extends Animal implements iAnimal {
		void move() {
			System.out.println("�� �߷� �̵��Ѵ�.");
		}

		public void eat() {
			System.out.println("������� ��� �Դ´�.");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		iCat cat = new iCat();
		cat.eat();

		iTiger tiger = new iTiger();
		tiger.move();
		tiger.eat();
	}
}