package de.cas.mse.exercise.diamond;

public class IntegerWrapper {
	Integer number;
	
	

	public IntegerWrapper(Integer number) {
		super();
		this.number = number;
	}

	public Integer getInteger() {
		return number;
	}

	public void setInteger(Integer number) {
		this.number = number;
	}
	
	public void increment() {
		number++;
	}
	
}
