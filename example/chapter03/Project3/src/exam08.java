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
		Car myCar1 = new Car("빨강", 0);
		Car myCar2 = new Car("파랑", 0);
		Car myCar3 = new Car("초록", 0);

		System.out.println("생산된 차의 대수(정적 필드) ==> " + Car.carCount);
		System.out.println("생산된 차의 대수(정적 메소드) ==> " + Car.currentCarCount());
		System.out.println("차의 최고 제한 속도 ==> " + Car.MAXSPEED);
		
		System.out.println("PI의 값 ==> " + Math.PI);
		System.out.println("3의 5제곱 ==> " + Math.pow(3, 5));
	}
}