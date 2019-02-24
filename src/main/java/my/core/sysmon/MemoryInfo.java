package my.core.sysmon;

import java.util.Date;

public class MemoryInfo {
	private final Date timestamp;
	private final long maxMemory;
	private final long allocatedMemory;
	private final long freeMemory;
	private final long usedMemory;

	public MemoryInfo(Date timestamp, long maxMemory, long allocatedMemory, long freeMemory, long usedMemory) {
		this.timestamp = timestamp;
		this.maxMemory = maxMemory;
		this.allocatedMemory = allocatedMemory;
		this.freeMemory = freeMemory;
		this.usedMemory = usedMemory;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public long getMaxMemory() {
		return maxMemory;
	}

	public long getAllocatedMemory() {
		return allocatedMemory;
	}

	public long getFreeMemory() {
		return freeMemory;
	}

	public long getUsedMemory() {
		return usedMemory;
	}

	public static MemoryInfo getMemoryInfo() {

		Runtime runtime = Runtime.getRuntime();
		long usedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		return new MemoryInfo(new Date(), runtime.maxMemory(), runtime.totalMemory(), runtime.freeMemory(), usedMemory);
	}

	@Override
	public String toString() {
		return "MemoryInfo [timestamp=" + timestamp + ", maxMemory=" + maxMemory + ", allocatedMemory="
				+ allocatedMemory + ", freeMemory=" + freeMemory + ", usedMemory=" + usedMemory + "]";
	}

}
