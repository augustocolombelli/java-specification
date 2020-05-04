package common.specification;

public class DomainEntityTwoFake {

	private boolean started;
	private boolean green;
	private boolean circle;

	public DomainEntityTwoFake(boolean started, boolean green, boolean circle) {
		this.started = started;
		this.green = green;
		this.circle = circle;
	}

	public boolean isCircle() {
		return circle;
	}

	public boolean isStarted() {
		return started;
	}

	public boolean isGreen() {
		return green;
	}

}
