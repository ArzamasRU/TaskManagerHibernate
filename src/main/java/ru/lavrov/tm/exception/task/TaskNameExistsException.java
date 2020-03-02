package ru.lavrov.tm.exception.task;

public class TaskNameExistsException extends RuntimeException{
    private static final String message = "task name already exists!";
    public TaskNameExistsException() {
        super(message);
    }
    public TaskNameExistsException(String message) {
        super(message);
    }
}