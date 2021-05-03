package calin.stefaniadenisa.g1093.decorator;

public class FreeMeals extends VacationDecorator {

	public FreeMeals() {
		super(vacation);
	}
	
	public String makeFree() {
		return super.makeFree() + getFreeMeal();
		
	}

	private String getFreeMeal() {
		return "With all meals included!";
	}
	
	

}
