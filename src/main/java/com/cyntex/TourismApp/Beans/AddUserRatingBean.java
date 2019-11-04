package com.cyntex.TourismApp.Beans;

public class AddUserRatingBean {
    private String userId;
    private String ratingUserId;
    private int adventurer;
    private int entertainer;
    private int masterChef;
    private int friendInNeed;
    private int animalLover;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRatingUserId() {
        return ratingUserId;
    }

    public void setRatingUserId(String ratingUserId) {
        this.ratingUserId = ratingUserId;
    }

    public int getAdventurer() {
        return adventurer;
    }

    public void setAdventurer(int adventurer) {
        this.adventurer = adventurer;
    }

    public int getEntertainer() {
        return entertainer;
    }

    public void setEntertainer(int entertainer) {
        this.entertainer = entertainer;
    }

    public int getMasterChef() {
        return masterChef;
    }

    public void setMasterChef(int masterChef) {
        this.masterChef = masterChef;
    }

    public int getFriendInNeed() {
        return friendInNeed;
    }

    public void setFriendInNeed(int friendInNeed) {
        this.friendInNeed = friendInNeed;
    }

    public int getAnimalLover() {
        return animalLover;
    }

    public void setAnimalLover(int animalLover) {
        this.animalLover = animalLover;
    }
}
