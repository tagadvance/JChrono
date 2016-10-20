package com.tagadvance.chrono;

public interface MutableTimeSource extends TimeSource {

	public void setCurrentTimeMillis(long milliseconds);

	public void incrementCurrentTimeMillis(long milliseconds);

}