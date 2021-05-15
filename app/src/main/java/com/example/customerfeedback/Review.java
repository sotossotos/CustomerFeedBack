package com.example.customerfeedback;

public class Review {
    private String telephone;
    private int rating;
    public Review(){}
    public Review(String telephone,int rating){
        this.telephone=telephone;
        this.rating=rating;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }



}
