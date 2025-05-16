package com.java.vault.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import lombok.Data;

@Data
@ConfigurationProperties("example")
public class VaultConfig {

	private String username;
	private String password;
}
