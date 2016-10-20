package com.tagadvance.chrono;

import java.util.concurrent.TimeUnit;

public class DeepSlumber implements Slumber {

	@Override
	public void sleep(long milliseconds) throws InterruptedException {
		Thread.sleep(milliseconds);
	}

	@Override
	public void sleep(long milliseconds, int nanoseconds) throws InterruptedException {
		Thread.sleep(milliseconds, nanoseconds);
	}

	@Override
	public void sleep(TimeUnit unit, long timeout) throws InterruptedException {
		unit.sleep(timeout);
	}

}
