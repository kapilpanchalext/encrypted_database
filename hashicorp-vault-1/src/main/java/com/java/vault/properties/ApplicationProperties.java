package com.java.vault.properties;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import com.java.vault.config.VaultConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class ApplicationProperties implements CommandLineRunner{
	private final VaultConfig vaultConfig;

	@Override
	public void run(String... args) throws Exception {
		log.info("----------------------------------------");
		
		log.info("configuration Properties");
		
		log.info("  example.username is: {} ", vaultConfig.getUsername());
		
		log.info("  example.password is: {} ", vaultConfig.getPassword());
		
		log.info("----------------------------------------");
	}

}
