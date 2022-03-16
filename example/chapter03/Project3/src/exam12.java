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
			System.out.println("생선을 좋아 한다.");
		}
	}

	static class iTiger extends Animal implements iAnimal {
		void move() {
			System.out.println("네 발로 이동한다.");
		}

		public void eat() {
			System.out.println("멧돼지를 잡아 먹는다.");
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