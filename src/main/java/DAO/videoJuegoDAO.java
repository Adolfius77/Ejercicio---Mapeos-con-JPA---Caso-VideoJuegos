/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Entidades.videojuego;
import interfaces.IVideoJuegoDAO;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author adoil
 */
public class videoJuegoDAO implements IVideoJuegoDAO{

    @Override
    public void agregar(EntityManager em,videojuego videojuego) {
        try {
            em.getTransaction().begin();
            em.persist(videojuego);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }

    @Override
    public void editar(EntityManager em,videojuego videojuego) {
        try {
            em.getTransaction().begin();
            em.merge(videojuego);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw ex;
        }finally{
            em.close();
        }
    }

    @Override
    public void eliminar(EntityManager em,Long id) {
        try {
            em.getTransaction().begin();
            em.remove(id);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }

    @Override
    public void buscarPorId(EntityManager em,Long id) {
        try {
            em.getTransaction().begin();
            videojuego v = em.find(videojuego.class, id);
            if (v != null) {
                em.remove(v);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw e;
        }finally{
            em.close();
        }
    }

    @Override
    public List<videojuego> obtenerTodos(EntityManager em) {
        
    }

    @Override
    public List<videojuego> buscarPorNombre(String nombre) {
    }

    @Override
    public List<videojuego> buscarPorDesarrolladora(String desarrolladora) {
    }

    @Override
    public List<videojuego> filtrarPorPuntajeMayorA(int puntajeMinimo) {
    }

    @Override
    public List<videojuego> ordenarPorNombre() {
    }

    @Override
    public List<videojuego> ordenarPorPuntajeDesc() {
    }

    @Override
    public List<Object[]> contarVideojuegosPorDesarrolladora() {
    }

    @Override
    public List<videojuego> buscarSinJugadores() {
    }

    @Override
    public List<videojuego> buscarConLogrosMayorA(int puntosMinimos) {
    }

    @Override
    public int actualizarPuntajePorNombre(String nombre, int nuevoPuntaje) {
    }

    @Override
    public int eliminarPorNombre(String nombre) {
    }
    
}
