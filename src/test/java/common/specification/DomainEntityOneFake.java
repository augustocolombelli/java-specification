package common.specification;

public class DomainEntityOneFake {

	private boolean finished;
	private boolean consistent;

	public DomainEntityOneFake(boolean finished, boolean consistent) {
		this.finished = finished;
		this.consistent = consistent;
	}

	public boolean isFinished() {
		return finished;
	}

	public boolean isConsistent() {
		return consistent;
	}

}
