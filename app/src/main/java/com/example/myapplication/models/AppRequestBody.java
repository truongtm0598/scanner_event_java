package com.example.myapplication.models;

public class AppRequestBody {
    String checkedInAt;
    String checkedInLocation;
    public AppRequestBody(String checkedInAt, String checkedInLocation) {
        this.checkedInAt = checkedInAt;
        this.checkedInLocation = checkedInLocation;
    }
}