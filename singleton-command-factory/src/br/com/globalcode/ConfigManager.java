package br.com.globalcode;
public class ConfigManager {
	private static ConfigManager instance = new ConfigManager();	
	private String serverName;
	
	public String getServerName() {
		return serverName;
	}

	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	private ConfigManager() {}

	public static ConfigManager getInstance() {
		return instance;
	}
}
