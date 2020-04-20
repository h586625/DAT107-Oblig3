package no.hvl.dat107.DAO;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import no.hvl.dat107.Ansatt;

public class AnsattDAO {

    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("firmaPersistenceUnit");

    public Ansatt finnAnsattMedId(int id) {
        EntityManager em = emf.createEntityManager();
        Ansatt a = null;
        try {
            a = em.find(Ansatt.class, id);
        } finally {
            em.close();
        }
        return a;
    }

    // Søke på brukernavn..uten inntasting av ID, finner ID i metode nedenfor
    // Burde ha kontroll?
    public Ansatt finnAnsattMedBrukernavn(String brukernavn) {
        EntityManager em = emf.createEntityManager();
        List<Ansatt> ansatteList = finnAlleAnsatte();
        Ansatt a = null;
        for (Ansatt ans : ansatteList) {
            if (ans.getBrukernavn().equals(brukernavn)) {
                a = ans;
                try {
                    a = em.find(Ansatt.class, a.getId());
                } finally {
                    em.close();
                }
            }
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
            // e.printStackTrace();
            if (tx.isActive()) {
                tx.rollback();
            }
        } finally {
            em.close();
        }
    }

    public void slettAnsatt(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        
        try {
            tx.begin();
            Ansatt slettThis = em.find(Ansatt.class, id);
            em.remove(slettThis);
            tx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (tx.isActive())
                ;
            tx.rollback();
        }
    }

    // Metoden tar inn ett Ansatt objekt vha. finnAnsatt(id)
    // Deretter må objektet bruke setBrukernavn (f.eks) for ny endring.
    // Det er da dette som objektet som mates inn inn under, a
    public void oppdaterAnsatt(Ansatt a) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(a);
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

    public void oppdaterFornavn(int id, String nyttNavn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setFornavn(nyttNavn);
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

    public void oppdaterEtternavn(int id, String nyttNavn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setEtternavn(nyttNavn);
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

    public void oppdaterAnsettelsesdato(int id, LocalDate nyDato) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setAnsettelsesdato(nyDato);
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

    public void oppdaterBrukernavn(int id, String nyttNavn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setBrukernavn(nyttNavn);
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

    public void oppdaterLonn(int id, int nyLonn) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setLonn(nyLonn);
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

    public void oppdaterStilling(int id, String nyStilling) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setStilling(nyStilling);
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

    // Viktig at ikke ID er tatt!!
    public void oppdaterId(int id, int nyId) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            Ansatt a = em.find(Ansatt.class, id);
            a.setId(nyId);
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
