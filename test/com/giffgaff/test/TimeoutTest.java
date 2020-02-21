package com.giffgaff.test;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class TimeoutTest {

	@BeforeAll
	static void beforeAll() {
		System.out.println("Initialize connection to database");
	}

	@AfterAll
	static void afterAll() {
		System.out.println("Close connection to database");
	}

	@BeforeEach // @Before in JUNIT4
	void beforeEach(TestInfo info) {
		System.out.println("Initialize Test Data for  " + info.getDisplayName());
	}

	@AfterEach // @After in JUNIT4
	void afterEach(TestInfo info) {
		System.out.println("Clean up Test Data for  " + info.getDisplayName());
	}

	@Test
	// @Disabled
	void performanceTest() {

		assertTimeout(Duration.ofSeconds(1), () -> {
			// for (double i = 0; i <= 1000000; i++) {
			for (double i = 0; i <= 10; i++) {
				double j = i;
				System.out.println(j);
			}
		}

		);
	}

}
