
public class BlueCrossBlueShield implements InsuranceBrand {

	private long id;
	private String name;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double computeMonthlyPremium(HealthInsurancePlan insurancePlan, int age, boolean smoking) {
		double amount = 0;

		if (insurancePlan instanceof PlatinumPlan) {
			if (age > 55 && smoking == true) {
				amount = 200 + 100;
			} else if (age < 55 && smoking == true) {
				amount = 100;
			} else if (age > 55 && smoking == false){
				amount = 200;
			}

		} 
		else if (insurancePlan instanceof GoldPlan) {
			if (age > 55 && smoking == true) {
				amount = 150 + 90;
			} else if (age < 55 && smoking == true) {
				amount = 90;
			} else if (age > 55 && smoking == false){
				amount = 150;
			} 

		} 
		else if (insurancePlan instanceof SilverPlan) {
			if (age > 55 && smoking == true) {
				amount = 100 + 80;
			} else if (age < 55 && smoking == true) {
				amount = 80;
			} else if (age > 55 && smoking == false){
				amount = 100;
			}

		} 
		else if (insurancePlan instanceof BronzePlan) {
			if (age > 55 && smoking == true) {
				amount = 50 + 70;
			} else if (age < 55 && smoking == true) {
				amount = 70;
			} else if (age > 55 && smoking == false){
				amount = 50;
			}
		}

		return amount;
	}
}
