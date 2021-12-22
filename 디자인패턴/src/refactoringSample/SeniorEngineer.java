package refactoringSample;

public class SeniorEngineer extends Engineer {
	public SeniorEngineer(String name) {
		super(name);
	}

	@Override
	public int getExpense(int days) {
		return (days * 300000);
	}

	@Override
	public int getAmount(int days) {
		return (500000 * days);

	}
}