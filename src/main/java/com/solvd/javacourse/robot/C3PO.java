package com.solvd.javacourse.robot;

public class C3PO extends Robot implements IRobot {
	private final static String PHRASE = "Hello. I don�t believe we have been introduced. R2-D2? A pleasure to meet you. I am C-3PO, Human-Cyborg Relations.";

	public C3PO() {
		super();
		this.name = "C3PO";
	}

	@Override
	public void talk() {
		// TODO Auto-generated method stub
		if (battery > 15) {
			System.out.println(PHRASE);
			this.battery -= 15;
		} else {
			System.out.println("You need to charge the battery.");
		}

	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "C3PO [name=" + name + ", battery=" + battery + ", fuel=" + fuel + "]";
	}

}
