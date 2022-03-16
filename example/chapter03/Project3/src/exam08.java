import java.lang.Math;

public class exam08 {
	public static class Car {
		String color;
		int speed;
		static int carCount = 0;
		final static int MAXSPEED = 200;
		final static int MINSPEED = 0;

		static int currentCarCount() {
			return carCount;
		}

		Car(String color, int speed) {
			this.color = color;
			this.speed = speed;
			carCount++;
		}

		Car(int speed) {
			this.speed = speed;
		}

		Car() {
		}

		void upSpeed(double value) {
			if (speed >= 200)
				speed = 200;
			else
				speed = speed + (int) value;
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
		Car myCar1 = new Car("����", 0);
		Car myCar2 = new Car("�Ķ�", 0);
		Car myCar3 = new Car("�ʷ�", 0);

		System.out.println("����� ���� ���(���� �ʵ�) ==> " + Car.carCount);
		System.out.println("����� ���� ���(���� �޼ҵ�) ==> " + Car.currentCarCount());
		System.out.println("���� �ְ� ���� �ӵ� ==> " + Car.MAXSPEED);
		
		System.out.println("PI�� �� ==> " + Math.PI);
		System.out.println("3�� 5���� ==> " + Math.pow(3, 5));
	}
}