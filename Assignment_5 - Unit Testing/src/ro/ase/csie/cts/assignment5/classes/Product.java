package ro.ase.csie.cts.assignment5.classes;

import java.util.ArrayList;
import java.util.regex.Pattern;

import ro.ase.csie.cts.assignment5.exceptions.InexistentWeeklySoldItemsException;
import ro.ase.csie.cts.assignment5.exceptions.SoldItemsLimitsNotRespectedException;
import ro.ase.csie.cts.assignment5.exceptions.WrongNameException;
import ro.ase.csie.cts.assignment5.exceptions.WrongPriceException;
import ro.ase.csie.cts.assignment5.exceptions.WrongSoldItemsException;

/*
 * 
 * DISCLAIMER
 * Most of the given methods are implemented with bugs
 * 
 * 
 * SPECS
 * 
 * name - between 5 and 200 alpha-numeric chars (no special chars)
 * price - between [0.01, 100000)
 * soldItems - between [0, 1000]
 * 
 * 
 */

public class Product {

	private String name;
	private float price;
	private ArrayList<Integer> weeklySoldItems;		//number of items sold each week

	public static final int MIN_NAME_SIZE = 5;
	public static final int MAX_NAME_SIZE = 200;
	public static final float MIN_PRICE = (float) 0.01;
	public static final float MAX_PRICE = (float) 99999.99;
	public static final int MIN_SOLD_ITEMS = 0;
	public static final int MAX_SOLD_ITEMS = 1000;
	
	public Product(String name, float price) throws WrongNameException, WrongPriceException {
		if(name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE || !Pattern.matches("[a-zA-Z0-9]+", name)) {
			throw new WrongNameException();
		}
		this.name = name;
		if(price < MIN_PRICE || price > MAX_PRICE) {
			throw new WrongPriceException();
		}
		this.price = price;
		this.weeklySoldItems = new ArrayList<Integer>();
	}

	public Product(String name, float price, ArrayList<Integer> soldItems) throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		if(name.length() < MIN_NAME_SIZE || name.length() > MAX_NAME_SIZE || !Pattern.matches("[a-zA-Z0-9]+", name)) {
			throw new WrongNameException();
		}
		this.name = name;

		if(price < MIN_PRICE || price > MAX_PRICE) {
			throw new WrongPriceException();
		}
		this.price = price;

		this.weeklySoldItems = new ArrayList<Integer>();
		if(soldItems != null && soldItems.size() > 0) {
			for(int soldItem : soldItems) {	
				if(soldItem < MIN_SOLD_ITEMS || soldItem > MAX_SOLD_ITEMS) {
					throw new WrongSoldItemsException();
				}
				this.weeklySoldItems.add(soldItem);
			}
		}
	}
	
	public void setSales(ArrayList<Integer> soldItems) throws WrongSoldItemsException {
		if(soldItems == null || soldItems.size() == 0) {
			this.weeklySoldItems = null;
		} 
		else {
			if(soldItems.size() > 0) {
				for(int soldItem : soldItems) {
					if(soldItem < MIN_SOLD_ITEMS || soldItem > MAX_SOLD_ITEMS) {
						throw new WrongSoldItemsException();
					}
				}
				this.weeklySoldItems = (ArrayList<Integer>) soldItems.clone();
			}
		}
	}

	public String getName() {
		return this.name;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void addWeek(int soldItems) throws WrongSoldItemsException {
		if(soldItems < MIN_SOLD_ITEMS || soldItems > MAX_SOLD_ITEMS) {
			throw new WrongSoldItemsException();
		}
		this.weeklySoldItems.add(soldItems);
	}
	
	public int getSoldItems(int i) throws InexistentWeeklySoldItemsException {
		if(this.weeklySoldItems == null) {
			return 0;
		}
		if(this.weeklySoldItems.size() <= i) {
			throw new InexistentWeeklySoldItemsException();
		}

		return this.weeklySoldItems.get(i);
	}
	
	/*
	 * 
	 * determines the number of weeks with sales above the given limit
	 * 
	 */
	public int getNoWeeksAboveLimit(int minLimit) throws SoldItemsLimitsNotRespectedException {
		int noWeeks = 0;

		if(minLimit < MIN_SOLD_ITEMS || minLimit > this.MAX_SOLD_ITEMS) {
			throw new SoldItemsLimitsNotRespectedException();
		}
		if(this.weeklySoldItems == null || this.weeklySoldItems.size() == 0) {
			return 0;
		}
		for(int weeklySoldItem : this.weeklySoldItems) {
			if(weeklySoldItem > minLimit) {
				noWeeks ++;
			}
		}			

		return noWeeks;
	}
	
	/*
	 * 
	 * determines the percentage (%) of weeks with sales under the given limit from total number of weeks
	 * 
	 */
	public int getPercentOfBadWeeks(int minLimit) {
		float noWeeks = 0;
		
		if(this.weeklySoldItems == null || this.weeklySoldItems.size() == 0) {
			return 0;
		}

		for(int weeklySoldItem : this.weeklySoldItems) {
			if(weeklySoldItem < minLimit) {
				noWeeks ++;
			}			
		}
		
		return (int) (100 * noWeeks / this.weeklySoldItems.size());
	}
	
	/*
	 * 
	 * 
	 * determines the index of the weeks with maximum sales (multiple weeks can have maximum sales)
	 * 
	 * 
	 */
	
	public ArrayList<Integer> getWeeksIndexWithMaxSales() {
		ArrayList<Integer> maxWeeks = new ArrayList<>();

		if(this.weeklySoldItems == null || this.weeklySoldItems.size() == 0) {
			return maxWeeks;
		}

		int max = this.getMaxSales();

		for(int i = 0; i < this.weeklySoldItems.size(); i++) {
			if(this.weeklySoldItems.get(i) == max) {
				maxWeeks.add(i);
			}
		}

		return maxWeeks;
	}
	
	// method added in order to respect SRP in getWeeksIndexWithMaxSales()
	public int getMaxSales() {
		int max = this.weeklySoldItems.get(0);
		for(int weeklySoldItem : this.weeklySoldItems) {
			if(weeklySoldItem > max) {
				max = weeklySoldItem;
			}
		}

		return max;
	}
	
	@Override
	public String toString() {
		String output = this.name + " weekly sales: ";
		for(Integer weeklySoldItem : this.weeklySoldItems)
			output += weeklySoldItem + " ";

		return output;
	}
}