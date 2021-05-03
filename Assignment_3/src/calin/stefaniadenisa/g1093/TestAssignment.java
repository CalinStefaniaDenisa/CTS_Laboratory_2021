package calin.stefaniadenisa.g1093;

import java.util.ArrayList;
import java.util.List;

import calin.stefaniadenisa.g1093.adapter.ACMEVacation;
import calin.stefaniadenisa.g1093.adapter.Honeymoon2AcmeAdapter;
import calin.stefaniadenisa.g1093.adapter.Vacation;
import calin.stefaniadenisa.g1093.adapter.honeymoon.Honeymoon;
import calin.stefaniadenisa.g1093.adapter.honeymoon.HoneymoonActivities;
import calin.stefaniadenisa.g1093.builder.MeanOfTransport;
import calin.stefaniadenisa.g1093.builder.TravelDestination;
import calin.stefaniadenisa.g1093.decorator.VacationDecorator;
import calin.stefaniadenisa.g1093.decorator.VacationImpl;
import calin.stefaniadenisa.g1093.factory.AbstractVacation;
import calin.stefaniadenisa.g1093.factory.VacationFactory;
import calin.stefaniadenisa.g1093.factory.VacationType;
import calin.stefaniadenisa.g1093.flyweight.Model3DFactory;
import calin.stefaniadenisa.g1093.flyweight.Model3DFlyweightInterface;
import calin.stefaniadenisa.g1093.flyweight.ModelType;
import calin.stefaniadenisa.g1093.flyweight.NPCCoordinates;
import calin.stefaniadenisa.g1093.prototype.Destination3DModel;
import calin.stefaniadenisa.g1093.singleton.DbConnection;
import calin.stefaniadenisa.g1093.singleton.DbConnectionRegistry;

public class TestAssignment {

	public static void main(String[] args) throws CloneNotSupportedException {

		
		// Singleton ----------------------------------------------------------------------
		System.out.println("SINGLETON");
		DbConnectionRegistry con1 = DbConnectionRegistry.getDbConnection("10.10.10.11", "devDB");
		DbConnectionRegistry con2 = DbConnectionRegistry.getDbConnection("10.10.10.111", "devDB");
		
		if(con1 != con2) {
			System.out.println("They are different");
		} 
		else {
			System.out.println("They point to the same object");
		}
		System.out.println("\n");

		
		// Builder ------------------------------------------------------------------------
		System.out.println("BUILDER");
		TravelDestination honeymood = 
				new TravelDestination.TravelDestinationBuilder("Hawaii", 5)
				.isExotic()
				.needsVaccineProof()
				.setMeanOfTransport(new MeanOfTransport())
				.build();
		System.out.println("\n");


		// Prototype ----------------------------------------------------------------------
		System.out.println("PROTOTYPE");
		Destination3DModel destination1 = new Destination3DModel(true, 100);
		Destination3DModel destination2 = (Destination3DModel) destination1.clone();
		System.out.println("\n");

		
		// Simple Factory -----------------------------------------------------------------
		System.out.println("SIMPLE FACTORY");
		AbstractVacation vacation = VacationFactory.getVacation(VacationType.CRUISE, "Caribbean");
		vacation.travel();
		System.out.println("\n");

		
		// Adapter ----------------------------------------------------------------------
		System.out.println("ADAPTER");
		ACMEVacation getaway = new Vacation("Rome", 4);
		HoneymoonActivities honeymoon = new Honeymoon(5);
		ArrayList<ACMEVacation> vacations = new ArrayList<>();
		vacations.add(getaway);
		Honeymoon2AcmeAdapter honeymoonAdapter = new Honeymoon2AcmeAdapter(honeymoon);
		vacations.add(honeymoonAdapter);
		for(ACMEVacation v: vacations) {
			v.exploreDestination();
			v.isExotic();
			v.rankDestination(3);
		}
		System.out.println("\n");

		
		// FLYWEIGHT ----------------------------------------------------------------------
		System.out.println("FLYWEIGHT");
		List<NPCCoordinates> vacationIdeas = new ArrayList<>();
		vacationIdeas.add(new NPCCoordinates(10, 10, 10, "Red"));
		vacationIdeas.add(new NPCCoordinates(50, 10, 10, "Green"));
		vacationIdeas.add(new NPCCoordinates(100, 100, 10, "Yellow"));
		
		Model3DFlyweightInterface vacationModel = Model3DFactory.getModel(ModelType.BEACH);
		for(NPCCoordinates vacationCoord : vacationIdeas) {
			vacationModel.display(vacationCoord);
		}
		
	}

}
