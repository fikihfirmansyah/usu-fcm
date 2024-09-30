package usu.fcm.service;

import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import org.springframework.stereotype.Service;
import usu.fcm.config.FirebaseInitializer;

@Service
public class FCMService {

    /**
     * Sends a notification to a specified device token.
     *
     * @param token the device token to send the notification to
     * @param title the title of the notification
     * @param body  the body of the notification
     * @throws Exception if an error occurs while sending the notification
     */
    public void sendNotification(String token, String title, String body) throws Exception {
        if (FirebaseApp.getApps().isEmpty()) {
            FirebaseInitializer.initialize();
        }
        Message message = Message.builder()
                .setToken(token)
                .setNotification(Notification.builder()
                        .setTitle(title)
                        .setBody(body)
                        .build())
                .build();

        FirebaseMessaging.getInstance().send(message);
    }}
