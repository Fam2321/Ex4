/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enterprise_ex4;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 60050257
 */
public class Enterprise_EX4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student emp1 = new Student(1, "John", 4.0);
       Student emp2 = new Student(2, "Marry", 3.0);
       StudentTable.insertStudent(emp1);
       StudentTable.insertStudent(emp2);
       Student emp;
       emp = StudentTable.findStudentById(1);
       if (emp != null) {
           emp.setName("Jack");
           StudentTable.updateStudent(emp);
       }
       emp = StudentTable.findStudentById(2);
       if (emp != null) {
           StudentTable.removeStudent(emp);
       }
    }
    
    
    
    public static void persist(Object object) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Enterprise_EX4PU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(object);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }
    
}
