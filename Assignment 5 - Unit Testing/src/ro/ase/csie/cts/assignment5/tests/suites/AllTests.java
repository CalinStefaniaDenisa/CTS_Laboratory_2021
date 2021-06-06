package ro.ase.csie.cts.assignment5.tests.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.assignment5.tests.TestProduct1;
import ro.ase.csie.cts.assignment5.tests.TestProduct2;
import ro.ase.csie.cts.assignment5.tests.TestProduct3;

@RunWith(Suite.class)
@SuiteClasses({ TestProduct1.class, TestProduct2.class, TestProduct3.class })
public class AllTests {

}
