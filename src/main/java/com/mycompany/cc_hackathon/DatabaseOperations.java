/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cc_hackathon;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author User
 */
public class DatabaseOperations {
    public static final String PERSISTENCE_UNIT_NAME = "CC_Hackathon";
    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    private static EntityManager em = emf.createEntityManager();

    public static List<Club> getClubs() {
        Query query = em.createQuery("SELECT c FROM Club c");
        List<Club> clubList = query.getResultList();
        
        return clubList;
    }
    
    public static int getClubIdFromLogin(String username, String password) throws NoSuchAlgorithmException {
        String hashedPassword = Hashing.hash(password);
        Query query = em.createQuery("SELECT c FROM ClubLeader c WHERE c.username = '" + username + "' AND c.password = '" + hashedPassword + "'");
        List<ClubLeader> clubLeader = query.getResultList();
        
        if (clubLeader.isEmpty()) {
            return 0;
        }
        
        return clubLeader.get(0).getClubId();
    }
    
    public static List<Club> clubById(int clubId) {
        Query query = em.createQuery("SELECT c FROM Club c WHERE c.id = " + clubId);
        List<Club> club = query.getResultList();
        
        return club;
    }
    
    public static List<Club> clubByName(String clubName) {
        Query query = em.createQuery("SELECT c FROM Club c WHERE c.name = '" + clubName + "'");
        List<Club> club = query.getResultList();
        
        return club;
    }
    
    public static void createClub(Integer id, String name, String description, String meetingDay, String meetingTime, int roomNumber) {
        em.getTransaction().begin();
        Club editingClub = new Club(id, name, description, meetingDay, meetingTime, roomNumber);
        em.persist(editingClub);
        em.getTransaction().commit();
    }
    
    public static void editClub(Integer id, String name, String description, String meetingDay, String meetingTime, int roomNumber) {
        em.getTransaction().begin();
        Club editingClub = new Club(id, name, description, meetingDay, meetingTime, roomNumber);
        em.merge(editingClub);
        em.getTransaction().commit();
    }
    
    public static void createLeader(String username, String password, String clubName) throws NoSuchAlgorithmException {
        Integer clubId;
        
        List<Club> clubOfLeader = clubByName(clubName);
        
        if (!clubOfLeader.isEmpty()) {
            clubId = clubOfLeader.get(0).getId();
        }
        else {
            Query query = em.createQuery("SELECT MAX(c.id) FROM Club c");
            List<Integer> highestClubID = query.getResultList();

            clubId = highestClubID.get(0) + 1;
        }
        
        em.getTransaction().begin();
        ClubLeader leader = new ClubLeader(username, Hashing.hash(password), clubId);
        em.persist(leader);
        em.getTransaction().commit();
    }
 }
