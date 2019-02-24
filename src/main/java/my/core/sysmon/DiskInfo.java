package my.core.sysmon;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DiskInfo {
	private final Date timestamp;
	private final List<FileRootInfo> fileRootInfo;
	private static final int MEM_SIZE_KB = 1024;
	private static final int MEM_SIZE_MB = 1024 * 1024;

	private DiskInfo(Date timestamp, List<FileRootInfo> fileRootList) {
		this.timestamp = timestamp;
		this.fileRootInfo = fileRootList;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public List<FileRootInfo> getFileRootInfo() {
		return fileRootInfo;
	}

	public static DiskInfo getDiskInfo() {
		final List<FileRootInfo> fileRootInfoList = new ArrayList<>();
		File[] roots = File.listRoots();
		Date snapshotTime = new Date();

		for (File root : roots) {
			String fileRootName = root.getAbsolutePath();
			long totalSpace = root.getTotalSpace()/ MEM_SIZE_MB;
			long freeSpace = root.getFreeSpace() / MEM_SIZE_MB;
			long usableSpace = root.getUsableSpace( ) / MEM_SIZE_MB;
			FileRootInfo fileRootInfo = new FileRootInfo(fileRootName, totalSpace, freeSpace, usableSpace);
			fileRootInfoList.add(fileRootInfo);
		}

		return new DiskInfo(snapshotTime, Collections.unmodifiableList(fileRootInfoList));
	}

	@Override
	public String toString() {
		return "DiskInfo [timestamp=" + timestamp + ", fileRootInfo=" + fileRootInfo + "]";
	}
	
	
}

class FileRootInfo {
	private final String rootName;
	private final long totalSpace;
	private final long freeSpace;
	private final long usableSpace;

	FileRootInfo(String rootName, long totalSpace, long freeSpace, long usableSpace) {
		this.rootName = rootName;
		this.totalSpace = totalSpace;
		this.freeSpace = freeSpace;
		this.usableSpace = usableSpace;
	}

	public String getRootName() {
		return rootName;
	}

	public long getTotalSpace() {
		return totalSpace;
	}

	public long getFreeSpace() {
		return freeSpace;
	}

	public long getUsableSpace() {
		return usableSpace;
	}

	@Override
	public String toString() {
		return "FileRootInfo [rootName=" + rootName + ", totalSpace=" + totalSpace + ", freeSpace=" + freeSpace
				+ ", usableSpace=" + usableSpace + "]";
	}

}
