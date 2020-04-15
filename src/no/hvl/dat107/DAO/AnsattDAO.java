package no.hvl.dat107.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.Ansatt;

public class AnsattDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

    public Ansatt finnAnsatt(int id) {
        EntityManager em = emf.createEntityManager();
        Ansatt a = null;
        try {
            a = em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
        return a;
    }

    public List<Ansatt> finnAlleAnsatte() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ansatt> query = em.createQuery("SELECT a from Ansatt a", Ansatt.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void LagNyAnsatt(Ansatt nyAnsatt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(nyAnsatt);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }
}
