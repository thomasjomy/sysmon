package my.core.sysmon;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Instance {
	private static Logger logger = Logger.getLogger(Instance.class.getName());
	private String hostName;
	private OS platformOS;
	private String fileSeperator;
	private Date startTime;
	private Date lastHeartBeatTime;

	public void init() {
		this.hostName = this.resolveHostName();
		this.platformOS = this.resolveOS();
	}

	private String resolveHostName() {
		String hostName = null;
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (UnknownHostException exp) {
			logger.log(Level.INFO, "Exception getting Host name ", exp);
			hostName = "unknown";
		}

		return hostName;
	}

	private OS resolveOS() {
		return OS.getPlatformOS();
	}

	public String getHostName() {
		return this.hostName;
	}
	
	public OS getPlatformOS() {
		return platformOS;
	}
	
	public String getFileSeperator() {
		return System.getProperty("file.separator");
	}
	
	public String getLineSeperator() {
		return System.getProperty("line.separator");
	}
}
