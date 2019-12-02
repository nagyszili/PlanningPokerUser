package com.example.plannigpokeruser;

public class User {

//    private static int countUser;
//    private int id;
    private String name;
    private String votedValue;

    public User() {
//        this.id = ++countUser;
    }

    public User(String name) {
        this.name = name;
//        this.id = ++countUser;
    }

//    public User(int id, String name) {
//        this.id = id;
//        this.name = name;
//
//    }


//    public int getCountUser() {
//        return countUser;
//    }

//    public int getId() {
//        return id;
//    }

    public String getName() {
        return name;
    }

    public String getVotedValue() {
        return votedValue;
    }

//    public void setId(int id) {
//        this.id = id;
//    }


    public void setName(String name) {
        this.name = name;
    }

    public void setVotedValue(String votedValue) {
        this.votedValue = votedValue;
    }
}
