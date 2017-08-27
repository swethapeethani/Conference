package com.swetha;

import java.util.ArrayList;
import java.util.Scanner;

public class Conference {


    public ArrayList<Session> sessions = new ArrayList<>();
    public ArrayList<Registration> registrations = new ArrayList<>();


    public void showListOfSessions(){


    }

    public ArrayList<Session> getSessionsAvailableForRegistration() {
        ArrayList<Session> availableSessions = new ArrayList<>();

        for(Session session: sessions){
            if(isSeatAvailableForSession(session)){
                availableSessions.add(session);
            }
        }

        return availableSessions;
    }

    private boolean isSeatAvailableForSession(Session session){
        int usedSeatCountForSession = 0;
        for(Registration registration : registrations){
            if(registration.session.title.equals(session.title)){
                usedSeatCountForSession++;
            }
            System.out.println("isSeatAvailable");
        }
        if(session.totalSeats > usedSeatCountForSession){
            return true;
        }
        else {
            return false;
        }
    }
    public void registerUserForSession(Session session, User user){
        if(isSeatAvailableForSession(session)){
            this.registrations.add(new Registration(user, session));
        }

    }



}


 //   public void addSession(Scanner scanner){

//        Session session = new Session();
//        Scanner sc = scanner;
//       System.out.println("Enter title of the session");
//     sc.next(session.title);
//   System.out.println(" Enter the number of seats");
// sc.nextInt(session.totalSeats);
//System.out.println(" Enter the session start time");
//sc.nextFloat(session.startTime);
//sessions.add(session);
// }
