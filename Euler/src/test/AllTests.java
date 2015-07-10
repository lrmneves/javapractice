package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ArrayAndStringTest.class, LinkedListTest.class,
		OtherTest.class, RecursionAndTreeTest.class, SortingTest.class })
public class AllTests {

}
