package com.eugene.spring.boot.pet.project.TaskTracker.entity;

public enum TaskStatus {
    WAITING("Waiting"),
    IMPLEMENTATION("Implementation"),
    VERIFYING("Verifying"),
    RELEASING("Releasing");

    private final String displayText;

    TaskStatus(String displayText) {
        this.displayText = displayText;
    }

    public String getDisplayText() {
        return displayText;
    }
}
