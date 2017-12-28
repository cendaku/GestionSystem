package Dao;

import Entidades.Localidad;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author administrador
 */
@Stateless
public class LocalidadFacade extends AbstractFacade<Localidad> {

    @PersistenceContext(unitName = "GestionSystemPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public LocalidadFacade() {
        super(Localidad.class);
    }
    
    public List<Localidad> findByMunicipio(Integer municipio) {
        TypedQuery<Localidad> q = em.createQuery("SELECT p FROM Localidad p WHERE p.municipio.id = :m", Localidad.class);
        q.setParameter("m", municipio);    
        return (q.getResultList());

    }
    
    public boolean LocalidadUnico(Localidad localidad) {
        boolean b;
        TypedQuery<Localidad> q = this.em.createQuery("SELECT f FROM Localidad f WHERE f.descripcion = :n", Localidad.class);
        q.setParameter("n", localidad.getDescripcion());
        if (q.getResultList().isEmpty()) {
            b = true;
            return b;
        } else {
            b = false;
            return b;
        }
    }

    public Localidad findByLocalidad(String localidad) {
        TypedQuery<Localidad> q = this.em.createQuery("SELECT f FROM Localidad f WHERE f.descripcion = :n", Localidad.class);
        q.setParameter("n", localidad);
        if (!q.getResultList().isEmpty()) {
            return q.getResultList().get(0);
        } else {
            return null;
        }
    }
}
