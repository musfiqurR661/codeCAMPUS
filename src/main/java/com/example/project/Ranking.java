package com.example.project;

public class Ranking {
    String rank;
    String userName;
    String numContest;
    String rating;

    public Ranking(String rank, String userName,String numContest, String rating) {
        this.rank = rank;
        this.userName = userName;
        this.numContest = numContest;
        this.rating = rating;

    }

    public void setRank(String rank) {

        this.rank = rank;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }
    public void setNumContest(String numContest) {
        this.numContest = numContest;
    }

    public void setRating(String rating) {

        this.rating = rating;
    }

    public String getRank() {

        return rank;
    }

    public String getUserName() {

        return userName;
    }
    public String getNumContest() {
        return numContest;
    }

    public String getRating() {

        return rating;
    }


}
