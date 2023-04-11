/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.cc_hackathon;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class ClubLeaderManagedBean {
    private String username;
    private String password;
    private int clubId = -1;
    private String clubName;
    
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public int getClubId() { return clubId; }
    public void setClubId(int clubId) { this.clubId = clubId; }
    
    public String getClubName() { return clubName; }
    public void setClubName(String clubName) { this.clubName = clubName; }
    
    
    public void setClubIdFromLogin() throws NoSuchAlgorithmException {
        clubId = DatabaseOperations.getClubIdFromLogin(username, password);
    }
    
    public String printClubLeader() {
        switch (clubId) {
            case 0:
                return "Leader does not exist.";
            case -1:
                return "";
            default:
                List<Club> clubFromID = DatabaseOperations.clubById(clubId);
                if (clubFromID.isEmpty()) {
                    return "Club Leader has no club yet.";
                }
                return "Club Leader of " + DatabaseOperations.clubById(clubId).get(0).getName();
        }
    }
    
    public void createLeader() throws NoSuchAlgorithmException {
        DatabaseOperations.createLeader(username, password, clubName);
    }
    
    public boolean leaderHasAClub() {
        return !DatabaseOperations.clubById(clubId).isEmpty();
    }
}
