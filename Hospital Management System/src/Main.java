import java.util.Arrays;

public class Main {

	public static void main(String[] args) {

		System.out.println("Platinium Plan");
		HealthInsurancePlan insurancePlan = new PlatinumPlan();
		Patient patient = new Patient();
		patient.setInsurancePlan(insurancePlan);
		
		double[] payments = Billing.computePaymentAmount(patient, 1000.0);
		System.out.println(Arrays.toString(payments));

		System.out.println("Gold Plan");
		HealthInsurancePlan insurancePlan1 = new GoldPlan();
		Patient patient1 = new Patient();
		patient1.setInsurancePlan(insurancePlan1);
		double[] payments1 = Billing.computePaymentAmount(patient1, 1000.0);
		System.out.println(Arrays.toString(payments1));

		System.out.println("Silver Plan");
		HealthInsurancePlan insurancePlan2 = new SilverPlan();
		Patient patient2 = new Patient();
		patient2.setInsurancePlan(insurancePlan2);
		double[] payments2 = Billing.computePaymentAmount(patient2, 1000.0);
		System.out.println(Arrays.toString(payments2));

		System.out.println("Bronze Plan");
		HealthInsurancePlan insurancePlan3 = new BronzePlan();
		Patient patient3 = new Patient();
		patient3.setInsurancePlan(insurancePlan3);
		double[] payments3 = Billing.computePaymentAmount(patient3, 1000.0);
		System.out.println(Arrays.toString(payments3));

	}

}
