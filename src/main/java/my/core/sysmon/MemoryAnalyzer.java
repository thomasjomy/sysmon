package my.core.sysmon;

public class MemoryAnalyzer {
	public void takeMemorySnapshot(int count) throws InterruptedException{
		for(int i = 0 ; i < count ; i++ ) {
			MemoryInfo mem = MemoryInfo.getMemoryInfo();
			System.out.println(mem);
			Thread.sleep(10000);
		}
		
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		MemoryAnalyzer analyzer = new MemoryAnalyzer();
		analyzer.takeMemorySnapshot(100);
	}
}
