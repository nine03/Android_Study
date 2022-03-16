
public class exam07 {
	public static class Car {
		String color;
		int speed=0;

		int getSpeed() {
			return speed;
		}

		void upSpeed(int value) {
			if (speed + value >= 200)
				speed = 200;
			else
				speed = speed + value;
		}

		void downSpeed(int value) {
			if (speed - value <= 0)
				speed = 0;
			else
				speed = speed - value;
		}

		String getColor() {
			return color;
		}
	}

	public static void main(String args[]) {
		Car myCar1 = new Car();
		myCar1.color = "����";
		myCar1.speed = 0;

		Car myCar2 = new Car();
		myCar2.color = "�Ķ�";
		myCar2.speed = 0;

		Car myCar3 = new Car();
		myCar3.color = "�ʷ�";
		myCar3.speed = 0;

		myCar1.upSpeed(50);
		System.out.println("�ڵ���1�� ������ " + myCar1.getColor() + "�̸�, �ӵ��� "
				+ myCar1.getSpeed() + "km �Դϴ�.");

		myCar2.downSpeed(20);
		System.out.println("�ڵ���2�� ������ " + myCar2.getColor() + "�̸�, �ӵ��� "
				+ myCar2.getSpeed() + "km �Դϴ�.");

		myCar3.upSpeed(250);
		System.out.println("�ڵ���3�� ������ " + myCar3.getColor() + "�̸�, �ӵ��� "
				+ myCar3.getSpeed() + "km �Դϴ�.");
	}
}