package chronometer;

public class Chromometer {
	private CyclicCounter minute;
	private CyclicCounter second;

	public Chromometer() {
		minute = new CyclicCounter(0, 59);
		second = new CyclicCounter(0, 59);
	}

	public void increment() {
		second.increment();
		if (second.getValue() == 0) {
			minute.increment();
		}
	}

	public void decrement() {
		second.decrement();
		if (second.getValue() == 59) {
			minute.decrement();
		}
	}

	public String toString() {
		String minuteString = "";
		String secondString = "";

		if (minute.getValue() < 10) {
			minuteString = "0" + minute.getValue();
		} else {
			minuteString = String.valueOf(minute.getValue());
		}

		if (second.getValue() < 10) {
			secondString = "0" + second.getValue();
		} else {
			secondString = String.valueOf(second.getValue());
		}

		return minuteString + ":" + secondString;
	}

}
