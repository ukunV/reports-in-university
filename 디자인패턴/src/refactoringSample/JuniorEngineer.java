package refactoringSample;

public class JuniorEngineer extends Engineer {
	public JuniorEngineer(String name) {
		super(name);
	}

	@Override
	public int getExpense(int days) {
		return 1000000;
	}

	@Override
	public int getAmount(int days) {
		return (200000 * days);
	}
}