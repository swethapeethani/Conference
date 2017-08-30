package com.swetha;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Conference conference = new Conference();

        //For testing purpose just hardcoded session List,
        //  "addSession() is in the menu

        for(int i=1; i<=10; i++){
            Session session = new Session();
            session.title = "Session"+i;
            session.totalSeats = 5;
            session.availableSeats = session.totalSeats;

            conference.sessions.add(session);
        }



        int chooseOption = 0;
        Scanner sc = new Scanner(System.in);

        while (chooseOption != 5) {
            System.out.println("Select an option from the below menu:");
            System.out.println("1.Display all the Sessions of the Conference");
            System.out.println("2.Display sessions available for registration");
            System.out.println("3.Registration");
            System.out.println("4.Add session");
            System.out.println("5.Exit the menu");

            switch (chooseOption = sc.nextInt()) {

                case 1:
                    conference.showListOfSessions();
                    break;
                case 2:

                    for (Session session : conference.getSessionsAvailableForRegistration()) {
                        System.out.println("Session :" + session.title + "total:" + session.totalSeats + "Seats Available");
                    }
                    break;
                case 3: {
                    System.out.println("Enter the Session title");
                    String sessionTitle = sc.next();
                    System.out.println("Enter username");
                    String userName = sc.next();
                    new Session();
                    Session registerForSession = conference.getSessionByTitle(sessionTitle);
                    if (registerForSession == null) {
                        System.out.println("Session title doesn't match ");
                        break;
                    }

                    if (!conference.checkIfUserRegistered(userName)) {
                        User registerForUsername = new User();
                        registerForUsername.userName = userName;
                        if (conference.registerUserForSession(registerForSession, registerForUsername)) {
                            System.out.println("User " + userName + " registered successfully for " + sessionTitle);
                        }
                    } else {
                        System.out.println("User " + userName + "registration failed for  " + sessionTitle);
                    }
                }
                    break;
                case 4:
                    conference.addSession();
                    break;
                case 5:
                    break;
            }

        }

    }

}
