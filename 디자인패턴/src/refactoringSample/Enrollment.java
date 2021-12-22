package refactoringSample;

public class Enrollment {
	private Engineer engineer;
	private int daysEnrollment;

	Enrollment(Engineer engineer, int days) {
		this.engineer = engineer;
		daysEnrollment = days;
	}
	
	public Engineer getEngineer() {
		return engineer;
	}

	public int getExpense(Engineer myEngineer) {
		return myEngineer.getExpense(daysEnrollment);
	}

	public int getAmount(Engineer myEngineer) {
		return engineer.getAmount(daysEnrollment);
	}

}