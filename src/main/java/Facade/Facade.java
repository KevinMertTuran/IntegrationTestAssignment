/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Entity.Person;
import Entity.School;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author mustafahakimi
 */
public class Facade {
    
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.mycompany_IntegrationMockAsg_jar_1.0-SNAPSHOTPU");

    public EntityManager getEM() {
        return emf.createEntityManager();
    }
    
    public Person findPersonById(int id) {
        EntityManager em = getEM();
        return em.find(Person.class, id);
    }
    
    public Person findPersonByFirstName(String firstName){
        EntityManager em = getEM();
        return em.find(Person.class, firstName);
    }
    
    public Person findPersonByLastName(String lastName){
        EntityManager em = getEM();
        return em.find(Person.class, lastName);
    }
    
    public School findSchoolById(int id){
        EntityManager em = getEM();
        return em.find(School.class, id);
    }
    
    public School findSchoolByName(String name){
        EntityManager em = getEM();
        return em.find(School.class, name);
    }
    
    
}
