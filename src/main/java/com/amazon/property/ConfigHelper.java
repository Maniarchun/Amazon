package com.amazon.property;

import java.io.IOException;

public class ConfigHelper {
	private ConfigHelper() {
	}

	public static ConfigReader getInstance() throws IOException {
		ConfigReader cr = new ConfigReader();
		return cr;
	}
}
