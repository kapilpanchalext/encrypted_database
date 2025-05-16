package com.java.vault;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.java.vault.config.VaultConfig;
import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
@EnableConfigurationProperties(VaultConfig.class)
public class HashicorpVault1Application {

	public static void main(String[] args) {
		SpringApplication.run(HashicorpVault1Application.class, args);
	}

}
