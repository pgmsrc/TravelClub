package com.herbert.java.travelClub.services.logic;

import com.herbert.java.travelClub.entity.TravelClub;
import com.herbert.java.travelClub.services.ClubService;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ClubServiceLogic implements ClubService {
    private TravelClub[] clubs;
    private int index;

    public ClubServiceLogic() {
        this.clubs = new TravelClub[10];
        this.index = 0;
    }

    @Override
    public void register(TravelClub travelClub) {
        clubs[index] = travelClub;
        index++;
    }

    @Override
    public TravelClub[] findAll() {
        return Arrays.copyOfRange(clubs, 0, index);
    }

    @Override
    public TravelClub[] findByName(String clubName) {
        TravelClub[] creatdClubs = Arrays.copyOfRange(clubs, 0, index);
        TravelClub[] foundClubs = new TravelClub[creatdClubs.length];
        int subIndex = 0;
        for (TravelClub club : creatdClubs) {
            if (club.getClubName().equals(clubName)) {
                foundClubs[subIndex] = club;
                subIndex++;
            }
        }
        return Arrays.copyOfRange(foundClubs, 0, subIndex);
    }

    @Override
    public TravelClub findByID(String clubId) {
        TravelClub[] creatdClubs = Arrays.copyOfRange(clubs, 0, index);
        TravelClub foundClub = null;
        for (TravelClub club : creatdClubs) {
           if (club.getId().equals(clubId)) {
               foundClub = club;
               break;
           }
        }
        return foundClub;
    }

    @Override
    public void modify(TravelClub modifyClub) {
        int foundIndex = 0;
        for(int i = 0; i < clubs.length; i++) {
            if(clubs[i].getId().equals(modifyClub.getId())) {
                foundIndex = i;
                break;
            }
        }
        this.clubs[foundIndex] = modifyClub;
    }

    @Override
    public void remove(String clubId) {
        int foundIndex = 0;
        for(int i = 0; i < clubs.length; i++) {
            if(clubs[i].getId().equals(clubId)) {
                foundIndex = i;
                break;
            }
        }
        for(int i = foundIndex; i < this.index + 1; i++) {
            clubs[i] = clubs[i+1];
        }
        this.index--;
    }
}
