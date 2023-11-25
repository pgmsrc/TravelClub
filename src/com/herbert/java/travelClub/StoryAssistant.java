package com.herbert.java.travelClub;

import com.herbert.java.travelClub.entity.TravelClub;
import com.herbert.java.travelClub.ui.menu.ClubMenu;
import com.herbert.java.travelClub.util.DateUtil;

public class StoryAssistant {
    private void startStory() {
        ClubMenu clubMenu = new ClubMenu();
        clubMenu.show();
    }

    public static void main(String[] args) {
//        StoryAssistant assistant = new StoryAssistant();
//        assistant.startStory();
        TravelClub newClub = new TravelClub("Sydney Club", "Located at Sydney");
        System.out.println(newClub.toString());
        System.out.println(TravelClub.getSample().toString());
    }
}
