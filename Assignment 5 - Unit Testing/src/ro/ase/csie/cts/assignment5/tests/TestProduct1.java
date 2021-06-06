package ro.ase.csie.cts.assignment5.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import ro.ase.csie.cts.assignment5.classes.Product;
import ro.ase.csie.cts.assignment5.exceptions.InexistentWeeklySoldItemsException;
import ro.ase.csie.cts.assignment5.exceptions.WrongNameException;
import ro.ase.csie.cts.assignment5.exceptions.WrongPriceException;
import ro.ase.csie.cts.assignment5.exceptions.WrongSoldItemsException;
import ro.ase.csie.cts.assignment5.tests.categories.ConformanceTests;

public class TestProduct1 {
	
	static Product product;
	static String initialName;
	static String shortName;
	static float initialPrice;
	static float highPrice;
	static ArrayList<Integer> weeklySoldItems;
	static ArrayList<Integer> tooManyWeeklySoldItems;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		initialName = "Laptops";
		initialPrice = Product.MIN_PRICE + 1;
		int initialNoWeeks = 5;
		weeklySoldItems = new ArrayList<>();
		Random random = new Random();
		for(int i = 0; i < initialNoWeeks; i++) {
			weeklySoldItems.add(random.nextInt(Product.MAX_SOLD_ITEMS) - 1);
		}
		
		// Error Conditions
		shortName = "USB";
		highPrice = product.MAX_PRICE + 1;
		tooManyWeeklySoldItems = new ArrayList<>();
		tooManyWeeklySoldItems.add(Product.MAX_SOLD_ITEMS + 1);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
		product = null;
	}

	@Category(ConformanceTests.class)
	@Test
	public void testConstructorWith2ParametersConformanceForRightName() throws WrongNameException, WrongPriceException {
		product = new Product(initialName, initialPrice);
		
		assertEquals("Testing with a proper name", initialName, product.getName());
	}
	
	@Category(ConformanceTests.class)
	@Test
	public void testConstructorWith2ParametersConformanceForRightPrice() throws WrongNameException, WrongPriceException {
		product = new Product(initialName, initialPrice);
		
		assertEquals("Testing with a proper price", initialPrice, product.getPrice(), 0);
	}
	
	@Category(ConformanceTests.class)
	@Test
	public void testConstructorWithAllParametersConformanceForRightName() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(initialName, initialPrice, weeklySoldItems);
		
		assertEquals("Testing with a proper name", initialName, product.getName());
	}
	
	@Category(ConformanceTests.class)
	@Test
	public void testConstructorWithAllParametersConformanceForRightPrice() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(initialName, initialPrice, weeklySoldItems);
		
		assertEquals("Testing with a proper price", initialPrice, product.getPrice(), 0);
	}
	
	@Category(ConformanceTests.class)
	@Test
	public void testConstructorWithAllParametersConformanceForRightSoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		product = new Product(initialName, initialPrice, weeklySoldItems);
		
		assertEquals("Testing with proper sold items", weeklySoldItems.get(0), product.getSoldItems(0), 0);
	}
	
	@Test(expected = WrongNameException.class)
	public void testConstructorWith2ParametersErrorConditionsShortName() throws WrongNameException, WrongPriceException {
		product = new Product(shortName, initialPrice);
	}
	
	@Test(expected = WrongPriceException.class)
	public void testConstructorWith2ParametersErrorConditionsHighPrice() throws WrongNameException, WrongPriceException {
		product = new Product(initialName, highPrice);
	}
	
	@Test(expected = WrongNameException.class)
	public void testConstructorWithAllParametersErrorConditionsShortName() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(shortName, initialPrice, weeklySoldItems);
	}
	
	@Test(expected = WrongPriceException.class)
	public void testConstructorWithAllParametersErrorConditionsHighPrice() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(initialName, highPrice, weeklySoldItems);
	}
	
	@Test(expected = WrongSoldItemsException.class)
	public void testConstructorWithAllParametersErrorConditionsTooManySoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(initialName, initialPrice, tooManyWeeklySoldItems);
	}
	
	@Test
	public void testConstructorWithAllParametersReferenceDeepCopyForSoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		int[] soldItems = new int[] {30, 30, 30};
		ArrayList<Integer> refSoldItems = new ArrayList<Integer>(Arrays.asList(30, 30, 30));
		
		product = new Product(initialName, initialPrice, refSoldItems);

		refSoldItems.set(0, 5);
		
		int[] productSoldItems = new int[product.getWeeksIndexWithMaxSales().size()];
		for(int i = 0; i < productSoldItems.length; i++) {
			productSoldItems[i] = product.getSoldItems(i);
		}
		
		assertArrayEquals("It's shallow-copy", soldItems, productSoldItems);
	}
	
	@Test
	public void testConstructorWithAllParametersExistenceNullReferenceForSoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException {
		product = new Product(initialName, initialPrice, null);
	}
	
	@Test
	public void testSetSalesReferenceDeepCopyForSoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		int[] soldItems = new int[] {30, 30, 30};
		ArrayList<Integer> refSoldItems = new ArrayList<Integer>(Arrays.asList(30, 30, 30));
		
		product = new Product(initialName, initialPrice, null);
		product.setSales(refSoldItems);

		refSoldItems.set(0, 5);
		
		int[] productSoldItems = new int[product.getWeeksIndexWithMaxSales().size()];
		for(int i = 0; i < productSoldItems.length; i++) {
			productSoldItems[i] = product.getSoldItems(i);
		}
		
		assertArrayEquals("It's shallow-copy", soldItems, productSoldItems);
	}
	
	@Test
	public void testSetSalesExistenceNullReferenceForSoldItems() throws WrongNameException, WrongPriceException, WrongSoldItemsException, InexistentWeeklySoldItemsException {
		product = new Product(initialName, initialPrice, weeklySoldItems);
		product.setSales(null);
		
		float expectedSoldItems = 0;
		float computedSoldItems = product.getSoldItems(5);
		
		assertEquals("Testing with no sold items", expectedSoldItems, computedSoldItems, 0);
	}
	
	

}
