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
    List<videojuego> buscarPorNombre(String nombre);
    List<videojuego> buscarPorDesarrolladora(String desarrolladora);
    List<videojuego> filtrarPorPuntajeMayorA(int puntajeMinimo);
    List<videojuego> ordenarPorNombre();
    List<videojuego> ordenarPorPuntajeDesc();
    List<Object[]> contarVideojuegosPorDesarrolladora();
    List<videojuego> buscarSinJugadores();
    List<videojuego> buscarConLogrosMayorA(int puntosMinimos);
    int actualizarPuntajePorNombre(String nombre, int nuevoPuntaje);
    int eliminarPorNombre(String nombre);

    
    
}
