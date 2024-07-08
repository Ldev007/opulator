package com.ldev.opulator.services;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.stereotype.Service;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.ldev.opulator.entities.Opule;

class CustomTimerTask extends TimerTask {

	OpulatorService service = new OpulatorService();

	@Override
	public void run() {
		service.addRecord();
	}

}

@Service
public class OpulatorService {
	private Timer timer = new Timer("counter");

	public void startPopulatingDatabase() {
		try {
			TimerTask task = new CustomTimerTask();
			timer.scheduleAtFixedRate(task, 0, 10000);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	public void addRecord() {
		Firestore db = FirestoreClient.getFirestore();
		CollectionReference colref = db.collection("opinions");
		Random randomNumGenerator = new Random();

		double generatedProbability = randomNumGenerator.nextInt(101);
		int opinionIndex = randomNumGenerator.nextInt(2);

		int hour = randomNumGenerator.nextInt(1, 5);
		int minutes = randomNumGenerator.nextInt(60);
		int seconds = randomNumGenerator.nextInt(60);

		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX");

		ZonedDateTime rawDateTime = ZonedDateTime.now();
		ZonedDateTime moddedDateTime = rawDateTime.plusHours(hour).plusMinutes(minutes).plusSeconds(seconds);

		String timeStamp = moddedDateTime.format(dateTimeFormatter);

		Opule record = new Opule(timeStamp, generatedProbability, opinionIndex == 0 ? "yes" : "no");

		ApiFuture<DocumentReference> result = colref.add(record.toJson());
		System.out.println("Probability changed :" + result.toString());
	}

	public void stopPopulatingDatabase() {
		timer.cancel();
	}
}
