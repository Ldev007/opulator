package com.ldev.opulator.configs;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;

public class FirebaseConfig {
	public void configureFirebaseConnection() throws IOException {
		InputStream configStream = this.getClass().getClassLoader().getResourceAsStream("config/firebase-config.json");

		FirebaseOptions options = FirebaseOptions	.builder()
													.setCredentials(GoogleCredentials.fromStream(configStream))
													.build();

		FirebaseApp.initializeApp(options);

	}

}
