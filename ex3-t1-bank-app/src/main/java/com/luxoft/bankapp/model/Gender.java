package com.luxoft.bankapp.model;

public enum Gender {

    MALE("Mr"), FEMALE("Ms"), UNDEFINED("");

    private final String prefix;

    Gender(String prefix) {
        this.prefix = prefix;
    }

    String getSalutation() {
        return prefix;
    }

}