package com.jeevanmaben.springboot.trails.domain;

import javax.persistence.*;

@Entity
public class Tour {
    @Id
    @GeneratedValue
    private Integer id;

    @Column
    private String Title;

    @Column
    private String description;

    @Column
    private String blurb;

    @Column
    private Integer price;

    @Column
    private String duration;

    @Column
    private String bullets;

    @Column
    private String keywords;

    @Column
    @Enumerated
    private Difficulty difficulty;

    @Column
    @Enumerated
    private Region region;

    @ManyToOne
    private TourPackage tourPackage;

    public Tour(String title, String description,
                String blurb, Integer price, String duration,
                String bullets, String keywords, Difficulty difficulty,
                Region region, TourPackage tourPackage) {
        Title = title;
        this.description = description;
        this.blurb = blurb;
        this.price = price;
        this.duration = duration;
        this.bullets = bullets;
        this.keywords = keywords;
        this.difficulty = difficulty;
        this.region = region;
        this.tourPackage = tourPackage;
    }

    protected Tour(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getBullets() {
        return bullets;
    }

    public void setBullets(String bullets) {
        this.bullets = bullets;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
}
