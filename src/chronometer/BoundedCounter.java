package chronometer;

public class BoundedCounter extends Counter {
	private int max;

	public BoundedCounter(int value, int max) {
		super(value);
		this.max = max;
	}
	
	public void increment() {
		if (getValue() < max) {
			super.increment();
		} 
	}

	public String toString() {
		return "BoundedCounter [value=" + getValue() +"]";
	}

	protected int getMax() {
		return max;
	}
}
