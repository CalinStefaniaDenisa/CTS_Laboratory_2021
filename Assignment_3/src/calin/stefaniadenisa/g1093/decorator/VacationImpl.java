package calin.stefaniadenisa.g1093.decorator;

public class VacationImpl implements FreeVacation {

	private String city;
	
	public VacationImpl(String city) {
		super();
		this.city = city;
	}

	@Override
	public String makeFree() {
		System.out.println("You've won a free vacation!");
		return "Free vacation";
	}
	

}
