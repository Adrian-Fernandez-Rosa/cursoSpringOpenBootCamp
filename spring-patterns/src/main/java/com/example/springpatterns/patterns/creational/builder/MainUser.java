package com.example.springpatterns.patterns.creational.builder;

public class MainUser {

    public static void main(String[] args) {

         User user1 = new User.Builder().setId(1L).build();

         User user2 = new User.Builder().setId(1L).setFirstName("Adrian").build();

         User user3 = new User.Builder().setId(2L).setFirstName("Adrian").setLastName("Fernández Rosa").build();


    }
}
