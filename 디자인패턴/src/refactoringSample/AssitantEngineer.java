package refactoringSample;

public class AssitantEngineer extends Engineer {

	public AssitantEngineer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getExpense(int days) {
		return 1000000;
	}

	@Override
	public int getAmount(int days) {
		return (250000 * days);
	}
}