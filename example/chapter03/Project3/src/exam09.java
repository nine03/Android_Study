
public class exam09 {
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
	
	public static class Automobile extends Car {
		int seatNum;
		
		Automobile(){
		}

		int getSeatNum() {
			return seatNum;
		}

		void upSpeed(int value) {
			if (speed + value >= 300)
				speed = 300;
			else
				speed = speed + value;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Automobile auto = new Automobile();
		
		auto.upSpeed(250);
		System.out.println("�¿����� �ӵ��� " + auto.getSpeed() + "km �Դϴ�.");
	}
}