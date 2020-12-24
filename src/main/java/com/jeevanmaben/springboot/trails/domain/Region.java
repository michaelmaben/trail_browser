package com.jeevanmaben.springboot.trails.domain;

public enum Region {
    Southern_California("Southern California"), Northern_California("Northern California"),
    Central_Coast("Central Coast"), Varies("Varies");
    private String label;
    private Region(String label){
        this.label = label;
    }
}
