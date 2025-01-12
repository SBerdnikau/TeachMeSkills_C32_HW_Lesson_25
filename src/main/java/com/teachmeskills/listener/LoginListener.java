package com.teachmeskills.listener;

import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebListener
public class LoginListener implements HttpSessionListener, ServletContextListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        log("Session created: " + sessionId);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        String sessionId = se.getSession().getId();
        log("Session destroyed: " + sessionId);
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        log("App started");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        log("App stopped");
    }

    public void logLoginAttempt(String username, boolean success, String ipAddress) {
        String status = success ? "successful" : "failed";
        log("Login attempt for user '" + username + "' from IP " + ipAddress + " was " + status);
    }

    public void log(String msg) {
        String logFilePath = "D:\\TeachMeSkills_C32_HW\\TeachMeSkills_C32_HW_Lesson_25\\src\\main\\resources\\logs\\log.txt";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        String logMessage = timestamp + " - " + msg + System.lineSeparator();
        try {
            Files.write(Paths.get(logFilePath), logMessage.getBytes(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            System.err.println("Could not write log file: " + logFilePath);
        }
    }

}
