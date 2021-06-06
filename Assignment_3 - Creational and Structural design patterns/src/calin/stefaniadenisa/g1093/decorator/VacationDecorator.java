package calin.stefaniadenisa.g1093.decorator;

public abstract class VacationDecorator implements FreeVacation {
	
	protected static FreeVacation vacation;
	
	public VacationDecorator(FreeVacation vacation) {
		super();
		this.vacation = vacation;
	}

	@Override
    public String makeFree() {
        return vacation.makeFree();
	 }
	

}
