package com.mytube;

public class VideoProcessor {
    private final VideoEncoder encoder;
    private final VideoDatabase database;
    private final NotificationService notificationService;

    public VideoProcessor(
            VideoEncoder encoder,
            VideoDatabase database,
            NotificationService notificationService) {
        this.encoder = encoder;
        this.database = database;
        this.notificationService = notificationService;
    }

    public void process(Video video) {
        encoder.encode(video);
        database.store(video);
        notificationService.sendNotification(video.getUser());
    }
}

