package my.core.sysmon;

import org.junit.Ignore;
import org.junit.Test;

import my.core.sysmon.DiskInfo;
import my.core.sysmon.Instance;

public class InstanceTest {

	@Test
	public void shouldReturnHostInfo() {
		Instance instance = new Instance();
		instance.init();
		System.out.println(instance.getHostName());
	}

	@Test
	public void shouldReturnPlatformOS() {
		Instance instance = new Instance();
		instance.init();
		System.out.println(instance.getPlatformOS());
	}

	@Test
	public void shouldReturnFileSeparator() {
		Instance instance = new Instance();
		instance.init();
		System.out.println(instance.getFileSeperator());
	}

	@Test
	public void shouldReturnLineSeparator() {
		Instance instance = new Instance();
		instance.init();
		System.out.println(instance.getLineSeperator());
	}
	
	@Test
	public void shouldReturnDiskInfo() {
		DiskInfo info = DiskInfo.getDiskInfo();
		System.out.println(info);
	}
	
	@Ignore
	@Test
	public void test() {
		System.out.println(System.getProperty("os.name"));

        //Operating system version
        System.out.println(System.getProperty("os.version"));

        //Path separator character used in java.class.path
        System.out.println(System.getProperty("path.separator"));

        //User working directory
        System.out.println(System.getProperty("user.dir"));

        //User home directory
        System.out.println(System.getProperty("user.home"));

        //User account name
        System.out.println(System.getProperty("user.name"));

        //Operating system architecture
        System.out.println(System.getProperty("os.arch"));

        //Sequence used by operating system to separate lines in text files
        System.out.println(System.getProperty("line.separator"));

        System.out.println(System.getProperty("java.version")); //JRE version number

        System.out.println(System.getProperty("java.vendor.url")); //JRE vendor URL

        System.out.println(System.getProperty("java.vendor")); //JRE vendor name

        System.out.println(System.getProperty("java.home")); //Installation directory for Java Runtime Environment (JRE)

        System.out.println(System.getProperty("java.class.path"));

        System.out.println(System.getProperty("file.separator"));
	}

}
