package zmaster.framework.utilities;

public class DriverFactory {
	
	private static String chromeDriverPath;
	private static String firefoxDriverPath;
	private static String configPropertyFile;
	private static String gridPath;
	private static boolean isRemote = false;
	
	
	public static String getChromeDriverPath() {
		return chromeDriverPath;
	}
	public static void setChromeDriverPath(String chromeDriverPath) {
		DriverFactory.chromeDriverPath = chromeDriverPath;
	}
	public static String getFirefoxDriverPath() {
		return firefoxDriverPath;
	}
	public static void setFirefoxDriverPath(String firefoxDriverPath) {
		DriverFactory.firefoxDriverPath = firefoxDriverPath;
	}
	public static String getConfigPropertyFile() {
		return configPropertyFile;
	}
	public static void setConfigPropertyFile(String configPropertyFile) {
		DriverFactory.configPropertyFile = configPropertyFile;
	}
	public static String getGridPath() {
		return gridPath;
	}
	public static void setGridPath(String gridPath) {
		DriverFactory.gridPath = gridPath;
	}
	
	public static void setIsRemote(boolean flag) {
		isRemote = flag;
	}
	
	public static boolean getRemote() {
		return isRemote;
	}
	
	

}
