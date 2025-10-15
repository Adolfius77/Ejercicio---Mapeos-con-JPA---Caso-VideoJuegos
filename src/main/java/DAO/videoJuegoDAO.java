/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.videojuego;
import interfaces.IVideoJuegoDAO;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;
import java.util.List;

/**
 *
 * @author adoil
 */
public class videoJuegoDAO implements IVideoJuegoDAO {

    @Override
    public void agregar(EntityManager em, videojuego videojuego) {
        try {
            em.getTransaction().begin();
            em.persist(videojuego);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public void editar(EntityManager em, videojuego videojuego) {
        try {
            em.getTransaction().begin();
            em.merge(videojuego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        } finally {
            em.close();
        }
    }

    @Override
    public void eliminar(EntityManager em, Long id) {
        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        } finally {
            em.close();
        }
    }

    @Override
    public videojuego buscarPorId(EntityManager em, Long id) {
        return em.find(videojuego.class, id);
    }

    @Override
    public List<videojuego> obtenerTodos(EntityManager em) {
        return em.createQuery("SELECT v FROM videojuego v", videojuego.class).getResultList();
    }

    @Override
    public List<videojuego> buscarPorNombre(EntityManager em, String nombre) {
        TypedQuery<videojuego> query = em.createQuery("SELECT v FROM videojuego v WHERE v.nombre LIKE :nombre", videojuego.class);
        query.setParameter("nombre", "%" + nombre + "%");
        return query.getResultList();
    }

    @Override
    public List<videojuego> buscarPorDesarrolladora(EntityManager em, String desarrolladora) {
        TypedQuery<videojuego> query = em.createQuery("SELECT v FROM videojuego v WHERE v.desarrolladora = :desarrolladora", videojuego.class);
        query.setParameter("desarolladora", desarrolladora);
        return query.getResultList();
    }

    @Override
    public List<videojuego> filtrarPorPuntajeMayorA(EntityManager em, int puntajeMinimo) {
        try {
            TypedQuery<videojuego> query = em.createQuery(
                    "SELECT v FROM videojuego v WHERE v.puntuaje >= :minimo", videojuego.class);
            query.setParameter("minimo", puntajeMinimo);
            query.setMaxResults(15);
            return query.getResultList();
        } catch (PersistenceException ex) {
            System.err.println("error al filtrar videjuegos: " + ex.getMessage());
            return List.of();
        }
    }

    @Override
    public List<videojuego> ordenarPorNombre(EntityManager em) {
        return em.createQuery("SELECT v FROM videojuego v ORDER BY v.nombre ASC").getResultList();
    }

    @Override
    public List<videojuego> ordenarPorPuntajeDesc(EntityManager em) {
        return em.createQuery("SELECT v FROM videojuego v ORDER BY v.puntuaje DESC").getResultList();
    }

    @Override
    public List<Object[]> contarVideojuegosPorDesarrolladora(EntityManager em) {
        return em.createQuery("SELECT v.desarrolladora, COUNT(v) FROM videojuego v GROUP BY v.desarrolladora", Object[].class).getResultList();

    }

    @Override
    public List<videojuego> buscarSinJugadores(EntityManager em) {
        return em.createQuery("SELECT v FROM videojuego v WHERE v.jugadores IS EMPTY", videojuego.class).getResultList();

    }

    @Override
    public List<videojuego> buscarConLogrosMayorA(EntityManager em, int puntosMinimos) {
        TypedQuery<videojuego> query = em.createQuery("SELECT DISTINCT v FROM videojuego v JOIN v.logros l WHERE l.puntos > :puntos", videojuego.class);
        query.setParameter("puntos", puntosMinimos);
        return query.getResultList();
    }

    @Override
    public int actualizarPuntajePorNombre(EntityManager em, String nombre, int nuevoPuntaje) {
        em.getTransaction().begin();
        int updatedCount = em.createQuery("UPDATE videojuego v SET v.puntuaje = :puntaje WHERE v.nombre = :nombre")
                .setParameter("puntaje", nuevoPuntaje)
                .setParameter("nombre", nombre)
                .executeUpdate();
        em.getTransaction().commit();
        return updatedCount;
    }

    @Override
    public int eliminarPorNombre(EntityManager em, String nombre) {
        em.getTransaction().begin();
        int deletedCount = em.createQuery("DELETE FROM videojuego v WHERE v.nombre =:nombre")
                .setParameter("nombre", nombre)
                .executeUpdate();
        em.getTransaction().commit();
        return deletedCount;
    }

}
