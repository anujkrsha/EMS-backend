package net.javaguides.ems.exception;

import java.time.LocalDateTime;


//java Records introduced in Java-14 to create immutable class
public record ErrorDetails(LocalDateTime timestamp, String message, String details, String errorCode) {

}
