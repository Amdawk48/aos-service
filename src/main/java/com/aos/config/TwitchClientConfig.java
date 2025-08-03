package com.aos.config;

import org.springframework.context.annotation.Bean;

import com.github.philippheuer.credentialmanager.CredentialManager;
import com.github.philippheuer.credentialmanager.CredentialManagerBuilder;
import com.github.twitch4j.TwitchClient;
import com.github.twitch4j.TwitchClientBuilder;
import com.github.twitch4j.auth.TwitchAuth;

public class TwitchClientConfig {
	
	@Bean
	public TwitchClient twitchClient() {
		CredentialManager credentialManager = CredentialManagerBuilder.builder().build();
		TwitchAuth.registerIdentityProvider(credentialManager, "your-client-id", "your-client-secret", "your-redirect-url", true);;
		return TwitchClientBuilder.builder()
			     .withEnableHelix(true)
			     .build();
	}
}
