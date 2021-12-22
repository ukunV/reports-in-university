package refactoringSample;

public abstract class Engineer {

	protected String name;

	public Engineer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract int getExpense(int days);
	public abstract int getAmount(int days);
}