package usu.fcm.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import usu.fcm.service.FCMService;

@RestController
@RequestMapping("/api/notification")
public class NotificationController {

    private final FCMService fcmService;

    public NotificationController(FCMService fcmService) {
        this.fcmService = fcmService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendNotification(
            @RequestParam String token,
            @RequestParam String title,
            @RequestParam String body) {

        try {
            fcmService.sendNotification(token, title, body);
            return ResponseEntity.ok("Notification sent successfully");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error sending notification: " + e.getMessage());
        }
    }
}
