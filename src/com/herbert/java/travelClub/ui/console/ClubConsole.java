package com.herbert.java.travelClub.ui.console;

import com.herbert.java.travelClub.entity.TravelClub;
import com.herbert.java.travelClub.services.ClubService;
import com.herbert.java.travelClub.services.logic.ClubServiceLogic;
import com.herbert.java.travelClub.util.ConsoleUtil;

import java.util.logging.SocketHandler;

public class ClubConsole {

    private ConsoleUtil consoleUtil;

    private ClubService clubService;

    public ClubConsole() {
        this.consoleUtil = new ConsoleUtil();
        //
        this.clubService = new ClubServiceLogic();
    }

    public void register() {
        while(true) {
            String clubName = consoleUtil.getValueOf("Club Name (0.Club Name)");
            if (clubName.equals("0")) {
                return;
            }

            String intro = consoleUtil.getValueOf("Club Intro (0.Club Name)");
            if (intro.equals("0")) {
                return;
            }

            TravelClub newClub = new TravelClub(clubName, intro);

            clubService.register(newClub);

        }

    }

    public void findAll() {
        TravelClub[] foundClubs = clubService.findAll();
        if(foundClubs.length ==0) {
            System.out.println("Empty~~");
            return;
        }
        for(TravelClub club : foundClubs) {
            System.out.println(club.toString());
        }
    }

    public void findById() {
        System.out.println("Find By ID!");
    }
}
