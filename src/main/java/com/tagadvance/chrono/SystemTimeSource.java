package com.tagadvance.chrono;

public class SystemTimeSource implements TimeSource {

	@Override
	public long currentTimeMillis() {
		return System.currentTimeMillis();
	}

}
