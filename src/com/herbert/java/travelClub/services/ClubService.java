package com.herbert.java.travelClub.services;

import com.herbert.java.travelClub.entity.TravelClub;

public interface ClubService {

    void register(TravelClub travelClub);
    TravelClub[] findAll();
    TravelClub[] findByName(String clubName);
    TravelClub findByID(String clubId);

    void modify(TravelClub modifyClub);
    void remove(String clubId);

}
