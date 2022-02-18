package chronometer;

public class CyclicCounter extends BoundedCounter {

	public CyclicCounter(int value, int max) {
		super(value, max);
	}

	public void increment() {
		if (getValue() < getMax()) {
			super.increment();
		} else {
			setValue(0);
		}
	}

	public void decrement() {
		if (getValue() > 0) {
			super.decrement();
		} else {
			setValue(getMax());
		}
	}

	public String toString() {
		return "CyclicCounter [value=" + getValue() + "]";
	}
	
	

}
