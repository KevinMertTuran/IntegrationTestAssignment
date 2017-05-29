
package Facade;

import Entity.Person;
import Entity.School;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class FacadeTest {
    
    static EntityManagerFactory emf;
    static EntityManager em;
    static Facade facade;
    
    public FacadeTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        emf = mock(EntityManagerFactory.class);
        em = mock(EntityManager.class);
        facade = mock(Facade.class);
    } 
    
    @AfterClass
    public static void tearDownClass() {
        emf.close();
        em.close();
    }

    @Test
    public void testFindPersonById() {

        Person p = new Person();
        
        int id = 1;
        p.setId(id);
        p.setFirstname("testfirstname");
        p.setLastname("testlastname");
        p.setAddress("testaddress");
        p.setPhone("123456789");
        
        when(emf.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(Person.class, id)).thenReturn(p);
        when(facade.findPersonById(id)).thenReturn(p);
        
        Person returnPerson = facade.findPersonById(id);
        assertEquals(p, returnPerson);
    }
    
    @Test
    public void testFindPersonByFirstname(){
        Person p = new Person();
        
        
        p.setId(1);
        String firstName = "tester";
        p.setFirstname(firstName);
        p.setLastname("testlastname");
        p.setAddress("testaddress");
        p.setPhone("123456789");
        
        when(emf.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(Person.class, firstName)).thenReturn(p);
        when(facade.findPersonByFirstName(firstName)).thenReturn(p);
        
        Person returnPerson = facade.findPersonByFirstName(firstName);
        assertEquals(p, returnPerson);
        
    }
    
    @Test
    public void testFindPersonByLastName(){
        Person p = new Person();
        
        p.setId(1);
        p.setFirstname("testFirstname");
        String lastName = "testLastname";
        p.setLastname(lastName);
        p.setAddress("testaddress");
        p.setPhone("123456789");
        
        when(emf.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(Person.class, lastName)).thenReturn(p);
        when(facade.findPersonByFirstName(lastName)).thenReturn(p);
        
        Person returnPerson = facade.findPersonByFirstName(lastName);
        assertEquals(p, returnPerson);
        
    }

    @Test
    public void testFindSchoolById() {

        School s = new School();
        
        int id = 1;
        s.setId(id);
        s.setName("testSchool");
        
        when(emf.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(School.class, id)).thenReturn(s);
        when(facade.findSchoolById(id)).thenReturn(s);
        
        School returnSchool = facade.findSchoolById(id);
        assertEquals(s, returnSchool);
    }
    
    @Test
    public void testFindSchoolByName(){

        School s = new School();
        
        s.setId(1);
        String name = "nameTester";
        s.setName(name);
        
        when(emf.createEntityManager()).thenReturn(em);
        when(facade.getEM()).thenReturn(em);
        when(em.find(School.class, name)).thenReturn(s);
        when(facade.findSchoolByName(name)).thenReturn(s);
        
        School returnSchool = facade.findSchoolByName(name);
        assertEquals(s, returnSchool);
        
    }
    
}
