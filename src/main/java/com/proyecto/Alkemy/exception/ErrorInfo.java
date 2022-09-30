package com.proyecto.Alkemy.exception;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorInfo {

    //Atributos
    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;

    @JsonProperty("timestamp")
    private long timestamp;

    @JsonProperty("path")
    private String path;

    //Constructor
    public ErrorInfo(String message, int status, long timestamp, String path) {
        this.message = message;
        this.status = status;
        this.timestamp = timestamp;
        this.path = path;
    }



    public String getMessage() {
        return message;
    }

    public int getStatus() {
        return status;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public String getPath() {
        return path;
    }
}
