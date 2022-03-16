
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
		myCar1.color = "빨강";
		myCar1.speed = 0;

		Car myCar2 = new Car();
		myCar2.color = "파랑";
		myCar2.speed = 0;

		Car myCar3 = new Car();
		myCar3.color = "초록";
		myCar3.speed = 0;

		myCar1.upSpeed(50);
		System.out.println("자동차1의 색상은 " + myCar1.getColor() + "이며, 속도는 "
				+ myCar1.getSpeed() + "km 입니다.");

		myCar2.downSpeed(20);
		System.out.println("자동차2의 색상은 " + myCar2.getColor() + "이며, 속도는 "
				+ myCar2.getSpeed() + "km 입니다.");

		myCar3.upSpeed(250);
		System.out.println("자동차3의 색상은 " + myCar3.getColor() + "이며, 속도는 "
				+ myCar3.getSpeed() + "km 입니다.");
	}
}