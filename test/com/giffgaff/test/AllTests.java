package com.giffgaff.test;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Parameterized.class)
@SuiteClasses({ AllTests.class, PerformanceTest.class })

public class AllTests {

}
