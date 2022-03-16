
public class exam0702 {
	public static class Car {
		String color;
		int speed;

		Car(String color, int speed) {
			this.color = color;
			this.speed = speed;
		}

		Car(int speed) {
			this.speed = speed;
		}

		Car() {
		}

		int getSpeed() {
			return speed;
		}

		void upSpeed(int value) {
			if (speed >= 200)
				speed = 200;
			else
				speed = speed + value;
		}

		void downSpeed(int value) {
			if (speed <= 0)
				speed = 0;
			else
				speed = speed - value;
		}

		String getColor() {
			return color;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Car myCar1 = new Car("����",0);
		Car myCar2 = new Car("�Ķ�",0);
		Car myCar3 = new Car("�ʷ�",0);
		Car myCar4 = new Car(0);

		myCar1.upSpeed(50);
		System.out.println("�ڵ���1�� ������ " + myCar1.getColor() + "�̸�, �ӵ��� "
				+ myCar1.getSpeed() + "km �Դϴ�.");

		myCar2.downSpeed(20);
		System.out.println("�ڵ���2�� ������ " + myCar2.getColor() + "�̸�, �ӵ��� "
				+ myCar2.getSpeed() + "km �Դϴ�.");

		myCar3.upSpeed(250);
		System.out.println("�ڵ���3�� ������ " + myCar3.getColor() + "�̸�, �ӵ��� "
				+ myCar3.getSpeed() + "km �Դϴ�.");

		myCar4.upSpeed(300);
		myCar4.color = "���";
		System.out.println("�ڵ���4�� ������ " + myCar4.getColor() + "�̸�, �ӵ��� "
				+ myCar4.getSpeed() + "km �Դϴ�.");
				
	}
}