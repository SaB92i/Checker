package chronometer;

public class TestChronometer {

	public static void main(String[] args) {
		Chromometer chromometer = new Chromometer();
		System.out.println(chromometer.toString());

		for (int i = 1; i <= 40; i++) {
			chromometer.increment();
		}
		System.out.println(chromometer.toString());
		
		for (int i = 1; i <= 30; i++) {
			chromometer.decrement();
		}
		System.out.println(chromometer.toString());

	}

}
