/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycompany.cc_hackathon;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class ClubManagedBean {
    private String name;
    private String description;
    private String meetingDay;
    private String meetingTime;
    private int roomNumber;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getMeetingDay() { return meetingDay; }
    public void setMeetingDay(String meetingDay) { this.meetingDay = meetingDay; }

    public String getMeetingTime() { return meetingTime; }
    public void setMeetingTime(String meetingTime) { this.meetingTime = meetingTime; }
    
    public int getRoomNumber() { return roomNumber; }
    public void setRoomNumber(int roomNumber) { this.roomNumber = roomNumber; }
    
    
    public List<Club> getClubs() {
        return DatabaseOperations.getClubs();
    }
    
    public List<Club> clubById(int clubId) {
        return DatabaseOperations.clubById(clubId);
    }
    
    public void editClub(Integer id) {
        DatabaseOperations.editClub(id, name, description, meetingDay, meetingTime, roomNumber);
    }
    
    public void createClub(Integer id) {
        DatabaseOperations.createClub(id, name, description, meetingDay, meetingTime, roomNumber);
    }
    
    public void autoFillInfo(Integer id) {
        name = DatabaseOperations.clubById(id).get(0).getName();
        description = DatabaseOperations.clubById(id).get(0).getDescription();
        meetingDay = DatabaseOperations.clubById(id).get(0).getMeetingDay();
        meetingTime = DatabaseOperations.clubById(id).get(0).getMeetingTime();
        roomNumber = DatabaseOperations.clubById(id).get(0).getRoomNumber();
    }
}
