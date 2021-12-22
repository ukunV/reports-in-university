package refactoringSample;

import java.util.ArrayList;

public class Project {
	private String name;
	private ArrayList<Enrollment> enrollments = new ArrayList<Enrollment>();
	
	Project(String name) {
		this.name = name;
	}
	
	public void addEnrollment(Enrollment enrollment) {
		this.enrollments.add(enrollment);
	}
	
	public String budgetReport() {
		String report = "Budget Report for Project <" + this.name + ">\n\n";
		
		for(Enrollment enrollment: this.enrollments) {
			Engineer myEngineer = enrollment.getEngineer();					
			report += "\t" + myEngineer.getName() + "\t pay: " + enrollment.getAmount(myEngineer) + "\n";
		}
		report += "\nTotal Payment: " + calcTotalAmount() + "\nTotal Expense: " + calcTotalExpense() + "\n";
		report += "\n*Estimated budget: " + (calcTotalAmount() + calcTotalExpense()) + "\n";
		return report;
	}

	private int calcTotalExpense() {
		int totalExpense = 0;
		for(Enrollment enrollment: this.enrollments) {
			Engineer myEngineer = enrollment.getEngineer();
			totalExpense += enrollment.getExpense(myEngineer);
		}
		return totalExpense;
	}

	private int calcTotalAmount() {
		int totalAmount = 0;
		for(Enrollment enrollment: this.enrollments) {
			Engineer myEngineer = enrollment.getEngineer();
			totalAmount += enrollment.getAmount(myEngineer);
		}
		return totalAmount;
	}
}