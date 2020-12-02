package com.cht.spring.boot.task;

import com.cht.spring.boot.config.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class Task {

    private Random random = new Random();

    private ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(3, 3, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5), new ThreadPoolExecutor.AbortPolicy());

    @Scheduled(fixedRate = 2000)
    public void testTasks() {
        poolExecutor.execute(() -> {
            WebSocketServer.sendInfo(Thread.currentThread().getName() + "------------" + System.currentTimeMillis() + "------" + random.nextInt(10000));
        });
    }

    @Scheduled(fixedRate = 2000)
    public void testTasksb() {
        poolExecutor.execute(() -> {
            WebSocketServer.sendInfo(Thread.currentThread().getName() + "------------" + System.currentTimeMillis() + "------" + random.nextInt(10000));
        });
    }
}
