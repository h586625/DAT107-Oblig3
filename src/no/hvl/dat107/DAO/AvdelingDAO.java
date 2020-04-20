package no.hvl.dat107.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.entity.Ansatt;
import no.hvl.dat107.entity.Avdeling;

public class AvdelingDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPersistenceUnit");

    public Avdeling finnAvdelingMedId(int id) {
        EntityManager em = emf.createEntityManager();
        Avdeling a = null;
        try {
            a = em.find(Avdeling.class, id);
        } finally {
            em.close();
        }
        return a;
    }

    public List<Avdeling> finnAlleAvdelinger() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Avdeling> query = em.createQuery("SELECT a from Avdeling a", Avdeling.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public List<Ansatt> finnAlleAnsatteForAvdeling() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Ansatt> query = em.createQuery("SELECT a from Avdeling a", Ansatt.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void LagNyAvdeling(Avdeling avdeling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(avdeling);
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
