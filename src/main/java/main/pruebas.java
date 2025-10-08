/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.SynchronizationType;

/**
 *
 * @author adoil
 */
public class pruebas {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("videojuegoPU");
        EntityManager em = emf.createEntityManager();
        
        
        
    }

}
