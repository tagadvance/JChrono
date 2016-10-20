package com.tagadvance.chrono;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public class TestSlumberImplementations {

	private TimeSource timeSource;
	private Slumber slumber;

	@Parameters
	public static Iterable<Object[]> createParameters() {
		MutableTimeSource mutableTimeSource = new MockTimeSource();
		LightSlumber lightSlumber = new LightSlumber(mutableTimeSource);

		SystemTimeSource systemTimeSource = new SystemTimeSource();
		DeepSlumber deepSlumber = new DeepSlumber();

		Object[][] array = { { mutableTimeSource, lightSlumber }, { systemTimeSource, deepSlumber } };
		return Arrays.asList(array);
	}

	public TestSlumberImplementations(TimeSource timeSource, Slumber slumber) {
		this.timeSource = timeSource;
		this.slumber = slumber;
	}

	@Test
	public void assertSleepDurationIsAccurate() throws InterruptedException {
		long now = timeSource.currentTimeMillis();
		long milliseconds = 10;
		slumber.sleep(milliseconds);
		long expectedElapsedTimeMilliseconds = now + milliseconds;
		now = timeSource.currentTimeMillis();
		Assert.assertTrue("sleep returned too soon", now >= expectedElapsedTimeMilliseconds);
	}

	@Test
	public void assertSleepWithNanosecondDurationIsAccurate() throws InterruptedException {
		long now = timeSource.currentTimeMillis();
		long milliseconds = 10;
		int nanoseconds = 1000;
		slumber.sleep(milliseconds, nanoseconds);
		long expectedElapsedTimeMilliseconds = now + milliseconds;
		now = timeSource.currentTimeMillis();
		Assert.assertTrue("sleep returned too soon", now >= expectedElapsedTimeMilliseconds);
	}

	@Test
	public void assertSleepWithTimeUnitDurationIsAccurate() throws InterruptedException {
		long now = timeSource.currentTimeMillis();
		TimeUnit unit = TimeUnit.MILLISECONDS;
		long timeout = 10;
		slumber.sleep(unit, timeout);
		long expectedElapsedTimeMilliseconds = now + unit.toMillis(timeout);
		now = timeSource.currentTimeMillis();
		Assert.assertTrue("sleep returned too soon", now >= expectedElapsedTimeMilliseconds);
	}

}