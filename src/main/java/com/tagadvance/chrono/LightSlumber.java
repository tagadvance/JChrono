package com.tagadvance.chrono;

import java.util.concurrent.TimeUnit;

public class LightSlumber implements Slumber {

	private MutableTimeSource timeSource;

	public LightSlumber(MutableTimeSource timeSource) {
		super();
		this.timeSource = timeSource;
	}

	@Override
	public void sleep(long milliseconds) throws InterruptedException {
		timeSource.incrementCurrentTimeMillis(milliseconds);
	}

	@Override
	public void sleep(long milliseconds, int nanoseconds) throws InterruptedException {
		timeSource.incrementCurrentTimeMillis(milliseconds);
	}

	@Override
	public void sleep(TimeUnit unit, long timeout) throws InterruptedException {
		long milliseconds = unit.toMillis(timeout);
		timeSource.incrementCurrentTimeMillis(milliseconds);
	}

}
