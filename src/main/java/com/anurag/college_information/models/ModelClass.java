package com.anurag.college_information.models;

public class ModelClass {

    private int collegeImage;
    private String collegeName, collegeRating;

    public ModelClass(int collegeImage, String collegeName, String collegeRating){
        this.collegeImage = collegeImage;
        this.collegeName = collegeName;
        this.collegeRating = collegeRating;
    }

    public int getCollegeImage() {
        return collegeImage;
    }

    public String getCollegeName() {
        return collegeName;
    }

    public String getCollegeRating() {
        return collegeRating;
    }
}
