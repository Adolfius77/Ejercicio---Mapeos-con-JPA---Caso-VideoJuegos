/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package interfaces;

import Entidades.videojuego;
import jakarta.persistence.EntityManager;
import java.util.List;

/**
 *
 * @author adoil
 */
public interface IVideoJuegoDAO {
    // CRUD básico
    void agregar(EntityManager em, videojuego videojuego);
    void editar(EntityManager em,videojuego videojuego);
    void eliminar(EntityManager em,Long id);
    videojuego buscarPorId(Long id);



    // Consultas NamedQuery
    List<videojuego> obtenerTodos(EntityManager em);
    List<videojuego> buscarPorNombre(EntityManager em,String nombre);
    List<videojuego> buscarPorDesarrolladora(EntityManager em,String desarrolladora);
    List<videojuego> filtrarPorPuntajeMayorA(EntityManager em,int puntajeMinimo);
    List<videojuego> ordenarPorNombre(EntityManager em);
    List<videojuego> ordenarPorPuntajeDesc(EntityManager em);
    List<Object[]> contarVideojuegosPorDesarrolladora(EntityManager em);
    List<videojuego> buscarSinJugadores(EntityManager em);
    List<videojuego> buscarConLogrosMayorA(EntityManager em,int puntosMinimos);
    int actualizarPuntajePorNombre(EntityManager em,String nombre, int nuevoPuntaje);
    int eliminarPorNombre(EntityManager em,String nombre);

    
    
}
