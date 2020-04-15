package no.hvl.dat107.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.Prosjekt;

public class ProsjektDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("ansattPersistenceUnit");

    public Prosjekt finnProsjektMedId(int id) {
        EntityManager em = emf.createEntityManager();
        Prosjekt a = null;
        try {
            a = em.find(Prosjekt.class, id);
        } finally {
            em.close();
        }
        return a;
    }

    public List<Prosjekt> finnAlleProsjekter() {
        EntityManager em = emf.createEntityManager();
        try {
            TypedQuery<Prosjekt> query = em.createQuery("SELECT p from Prosjekt p", Prosjekt.class);
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void LagNyProsjekt(Prosjekt prosjekt) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(prosjekt);
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
