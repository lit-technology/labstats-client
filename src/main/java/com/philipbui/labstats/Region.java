package com.philipbui.labstats;

public enum Region {

    NA,
    SEA,
    EUROPE;

    String getBaseURL() {
        switch (this) {
            case NA:
                return "https://api.labstats.com";
            case SEA:
                return "https://sea-api.labstats.com";
            case EUROPE:
                return "https://weu-api.labstats.com";
            default:
                throw new IllegalStateException();
        }
    }
}
