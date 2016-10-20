package com.tagadvance.chrono;

import org.junit.Assert;
import org.junit.Test;

public class TestSystemTimeSource {

	@Test
	public void assertCurrentTimeMillisIsPositive() {
		SystemTimeSource source = new SystemTimeSource();
		long millis = source.currentTimeMillis();
		Assert.assertTrue(millis > 0);
	}

}