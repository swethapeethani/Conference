package com.swetha;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Conference conference = new Conference();

        //For testing purpose just hardcoded session List, if required add module called "addSession"

        for(int i=1; i<=10; i++){
            Session session = new Session();
            session.title = "Session"+i;
            session.totalSeats = 5;

            conference.sessions.add(session);
        }


        int chooseOption = 0;
        Scanner sc = new Scanner(System.in);

        while(chooseOption!=3){
            System.out.println("Select an option from the below menu:");
            System.out.println("1.Display all the Sessions of the Conference");
            System.out.println("2.Display sessions available for registration");
            System.out.println("3.Exit the menu");

            switch (chooseOption = sc.nextInt()){

                case 1:
                    for(Session session: conference.sessions ){
                        System.out.println("Session" + session.title);
                    }
                    break;
                case 2:

                    for(Session session : conference.getSessionsAvailableForRegistration()){
                      System.out.println("Session :" +session.title + "total:" +session.totalSeats + "Seats Available" );
                    }
                    break;
                case 3:
                    System.out.println("Enter the details of Session title and User Details");
                    //Take input of session name to be registered and the user details
                    //conference.registerUserForSession(session,user);
                    break;
            }

        }

    }

}
