package com.tagadvance.chrono;

import java.util.concurrent.atomic.AtomicLong;

public class MockTimeSource implements MutableTimeSource {

	private AtomicLong milliseconds;

	public MockTimeSource() {
		super();
		this.milliseconds = new AtomicLong();
	}

	public MockTimeSource(long initialTimeMilliseconds) {
		super();
		this.milliseconds = new AtomicLong(initialTimeMilliseconds);
	}

	@Override
	public long currentTimeMillis() {
		return milliseconds.get();
	}

	@Override
	public void setCurrentTimeMillis(long milliseconds) {
		this.milliseconds.set(milliseconds);
	}

	@Override
	public void incrementCurrentTimeMillis(long milliseconds) {
		this.milliseconds.addAndGet(milliseconds);
	}

}