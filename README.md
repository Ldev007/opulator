# Opulator

A service which is responsible to populate random data in Firebase Cloud Firestore at random intervals where data is an opinion and it's probability to be true at a certain time

##### Requirements :

- JDK >= 17
- Eclipse IDE >= 4.27.0
- Google account to use Firebase and it's services

##### Steps to build/run :

1. Open the firebase console -> Create new project -> Open project settings -> Open the "Service accounts" tab
2. Under "Service accounts" tab under "Admin SDK configuration snippet" click "Generate new private key" button
3. Clone this repo and place the downloaded private key at ```src/main/resources/config```
4. Import this project in Eclipse IDE (File -> Import -> Existing Maven Projects)
5. Now, from within Eclipse IDE's "Project navigator" just right click the project folder and click "Run as" after which choose "Spring Boot App" or "Run on server"
6. Check the logs in the console and if you did everything as per the instructions above, the service should be running fine
7. Now, either from the [Opulizer app](https://github.com/Ldev007/opulizer) try starting the service or make a call to ```http://localhost:8080/start``` directly. This will kickstart the service
8. Check Firebase Cloud Firestore, the generated data points will start to show up under a collection named "opinions". Also, check console in Eclipse IDE if everything is fine then you'll see repeated logs prefixed with "Probability changed:"