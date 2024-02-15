package model;

import entities.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

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
    public List<User> getUsers() {
        em =  getEM();
        transaction = em.getTransaction();

        try {
            transaction.begin();

                    List<User> result = em
                            .createQuery("SELECT u FROM User u", User.class)
                            .getResultList();

            transaction.commit();
            return result;

        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (transaction.isActive()) {
                transaction.rollback();
            }
            return null;

        } finally {

            em.close();
        }
    }



}
