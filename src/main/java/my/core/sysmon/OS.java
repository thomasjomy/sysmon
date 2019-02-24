package my.core.sysmon;

import java.util.EnumSet;

public enum OS {
	WINDOWS {
		private static final String WINDOWS_OS_NAME = "win";

		@Override
		public boolean matchName(String osName) {
			return osName.indexOf(WINDOWS_OS_NAME) >= 0;
		}
	},
	SOLARIS {
		private static final String SOLARIS_OS_NAME = "solaris";
		private static final String SOLARIS_OS_ALT_NAME = "sunos";

		@Override
		public boolean matchName(String osName) {
			return osName.indexOf(SOLARIS_OS_NAME) >= 0 || osName.indexOf(SOLARIS_OS_ALT_NAME) >= 0;
		}
	},
	MAC {
		private static final String MAC_OS_NAME = "mac";

		@Override
		public boolean matchName(String osName) {
			return osName.indexOf(MAC_OS_NAME) >= 0;
		}
	};

	public abstract boolean matchName(String osName);

	static OS os;
	private String name;
	private String version;
	private String architecture;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getArchitecture() {
		return architecture;
	}

	public void setArchitecture(String architecture) {
		this.architecture = architecture;
	}
	

	static {
		String osName = OSName();
		for (OS osEnum : EnumSet.allOf(OS.class)) {
			if (osEnum.matchName(osName)) {
				os = osEnum;
				os.setName(osName);
				os.setArchitecture(OsArchitecture());
				os.setVersion(OSVersion());
				break;
			}
		}
	}

	public static OS getPlatformOS() {
		return os;
	}

	private static String OSName() {
		return System.getProperty("os.name").toLowerCase();
	}

	private static String OSVersion() {
		return System.getProperty("os.version");
	}

	private static String OsArchitecture() {
		return System.getProperty("os.arch");
	}
}