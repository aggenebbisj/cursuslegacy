package aggenebbisj;

public class Configuration {

	private static class ConfigurationHolder {
		private static final Configuration INSTANCE = new Configuration();
	}

	public static Configuration getInstance() {
		return ConfigurationHolder.INSTANCE;
	}

	public boolean shouldRound() {
		throw new ShouldNotBeCalledFromUnitTestException();
	}
	
	
}
