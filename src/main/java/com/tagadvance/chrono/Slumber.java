package com.tagadvance.chrono;

import java.util.concurrent.TimeUnit;

public interface Slumber {

	public void sleep(long milliseconds) throws InterruptedException;

	public void sleep(long milliseconds, int nanoseconds) throws InterruptedException;

	public void sleep(TimeUnit unit, long timeout) throws InterruptedException;

}