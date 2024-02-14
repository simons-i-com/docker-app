package model;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DAO extends EMF{

    EntityManager em;
    EntityTransaction transaction;


    public boolean addUser(User user) {
        em =  getEM();
        transaction = em.getTransaction();

        try {
            transaction.begin();

            em.persist(user);

            transaction.commit();
            return true;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return false;

        } finally {

            em.close();
        }
    }



}
