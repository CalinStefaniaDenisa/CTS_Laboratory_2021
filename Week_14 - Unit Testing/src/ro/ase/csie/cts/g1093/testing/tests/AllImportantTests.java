package ro.ase.csie.cts.g1093.testing.tests;

import org.junit.experimental.categories.Categories;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.categories.Categories.IncludeCategory;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import ro.ase.csie.cts.g1093.testing.tests.categories.ImportantTests;
import ro.ase.csie.cts.g1093.testing.tests.categories.PerformanceTests;

@RunWith(Categories.class)
@IncludeCategory({ImportantTests.class, PerformanceTests.class})
//@ExcludeCategory({ImportantTests.class, PerformanceTests.class})
@SuiteClasses({ TestStudent.class, TestStudentNewTests.class })
public class AllImportantTests {

}
