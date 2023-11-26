package com.herbert.java.travelClub.ui.console;

import com.herbert.java.travelClub.entity.TravelClub;
import com.herbert.java.travelClub.services.ClubService;
import com.herbert.java.travelClub.services.ServiceLogicLifeCycler;
import com.herbert.java.travelClub.util.ConsoleUtil;

import java.util.logging.SocketHandler;

public class ClubConsole {

    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        //
        this.clubService = ServiceLogicLifeCycler.getUniqueInstance().getClubService();
    }

    public void register() {
        while(true) {
            String clubName = consoleUtil.getValueOf("Club Name (0.Club Menu)");
            if(clubName.equals("0")) {
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro (0.Club Menu)");
            if(intro.equals("0")) {
                return;
            }

            TravelClub newClub = new TravelClub(clubName, intro);
            System.out.println("Registered club : " + newClub.toString());

            clubService.register(newClub);

        }

    }

    public void findAll() {
        TravelClub[] foundClubs = clubService.findAll();
        if(foundClubs.length == 0) {
            System.out.println("Empty~~");
            return;
        }
        for(TravelClub club : foundClubs) {
            System.out.println(club.toString());
        }
    }

    public void findById() {
        TravelClub foundClub = null;

        while (true) {
            String clubID = consoleUtil.getValueOf("Club ID to find (0.Club Menu)");
            if(clubID.equals("0")) {
                break;
            }

            foundClub = clubService.findByID(clubID);

            if(foundClub != null) {
                System.out.println(foundClub.toString());
            } else {
                System.out.println("Can't find club ID : " + clubID);
            }
        }

    }

    public TravelClub findByOne() {
        TravelClub foundClub = null;

        while (true) {
            String clubID = consoleUtil.getValueOf("Club ID to find (0.Club Menu)");
            if(clubID.equals("0")) {
                break;
            }

            foundClub = clubService.findByID(clubID);

            if(foundClub != null) {
                break;
            } else {
                System.out.println("Can't find club ID : " + clubID);
            }
        }
        return foundClub;
    }

    public void modify() {
        TravelClub targetClub = findByOne();

        String newName = consoleUtil.getValueOf("New Club Name (0.Club Menu, No Change)");
        if(newName.equals("0")) {
            return;
        }
        if(!newName.isEmpty()) {
            targetClub.setClubName(newName);
        }

        String newIntro = consoleUtil.getValueOf("New Club Intro (0.Club Menu, No Change)");
        if(!newIntro.isEmpty()) {
            targetClub.setIntro(newIntro);
        }

        clubService.modify(targetClub);
        System.out.println("Modify Club : " + targetClub.toString());

    }

    public void findByName() {
        TravelClub[] foundClubs = null;
        while (true) {
            String clubName = consoleUtil.getValueOf("Club Name to find (0.Club Menu)");
            if (clubName.equals("0")) {
                break;
            }

            foundClubs = clubService.findByName(clubName);

            if (foundClubs != null && foundClubs.length != 0) {
                for (TravelClub club : foundClubs) {
                    System.out.println(club);
                }
            } else {
                System.out.println("Can't find club name : " + clubName);
            }
        }
    }

    public void remove() {
        TravelClub targetClub = findByOne();

        String confirmStr = consoleUtil.getValueOf("Remove this club? (Y:yes, N:no)");
        if(confirmStr.toLowerCase().equals("y") || confirmStr.toLowerCase().equals("yes")) {
            System.out.println("Removing a club --> " + targetClub.getClubName());
            clubService.remove(targetClub.getId());
        } else {
            System.out.println("Remove Canceled, your club is safe. " + targetClub.getClubName());
        }
    }
}
