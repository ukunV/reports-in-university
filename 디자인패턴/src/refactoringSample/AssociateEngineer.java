package refactoringSample;

public class AssociateEngineer extends Engineer {
	public AssociateEngineer(String name) {
		super(name);
	}

	@Override
	public int getExpense(int days) {
		return (int)(days/7. + .9) * 500000;
	}

	@Override
	public int getAmount(int days) {
		return (300000 * days);
	}
}