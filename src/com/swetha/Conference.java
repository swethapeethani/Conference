package com.swetha;

import java.util.ArrayList;
import java.util.Scanner;

public class Conference {

    public ArrayList<Session> sessions = new ArrayList<>();
    private ArrayList<Registration> registrations = new ArrayList<>();


    public void showListOfSessions() {
        for (Session session : sessions) {
            System.out.println("Session" + session.title);
        }
    }

    public ArrayList<Session> getSessionsAvailableForRegistration() {
        ArrayList<Session> availableSessions = new ArrayList<>();

        for (Session session : sessions) {
            if (isSeatAvailableForSession(session)) {
                availableSessions.add(session);
            }
        }

        return availableSessions;
    }

    private boolean isSeatAvailableForSession(Session session) {
        return session.availableSeats != 0;
    }


    public boolean registerUserForSession(Session session, User user) {
        if (isSeatAvailableForSession(session)) {
            for (Registration registration : registrations) {
                if (registration.user.userName.equals(user.userName)) {
                    System.out.println("User registration denied as already registered");
                    return false;
                }
            }

            this.registrations.add(new Registration(user, session));
            session.availableSeats--;

            return true;
        } else {
            System.out.println("Registration closed for this session, seats are already filled ");
            return false;
        }

    }

    public Session getSessionByTitle(String title) {
        for (Session session : sessions) {
            if (session.title.equals(title)) {
                return session;
            }
        }

        System.out.println("No matching session found");
        return null;

    }

    public boolean checkIfUserRegistered(String name) {
        for (Registration registration : registrations) {
            if (registration.user.userName.equals(name)) {
                System.out.println("Ooops this user already registered");
                return true;
            }
        }
        System.out.println("User not yet registered");
        return false;

    }


    public void addSession() {

        Session session = new Session();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter title of the session");
        session.title = sc.next();
        System.out.println(" Enter the number of seats");
        session.totalSeats = sc.nextInt();
        session.availableSeats = session.totalSeats;
        sessions.add(session);
    }
}