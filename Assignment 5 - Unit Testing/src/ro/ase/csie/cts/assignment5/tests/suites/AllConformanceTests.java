package ro.ase.csie.cts.assignment5.tests.suites;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.assignment5.tests.TestProduct1;
import ro.ase.csie.cts.assignment5.tests.TestProduct2;
import ro.ase.csie.cts.assignment5.tests.TestProduct3;
import ro.ase.csie.cts.assignment5.tests.categories.ConformanceTests;

@RunWith(Categories.class)
@IncludeCategory(ConformanceTests.class)
@SuiteClasses({ TestProduct1.class, TestProduct2.class, TestProduct3.class })
public class AllConformanceTests {

}
