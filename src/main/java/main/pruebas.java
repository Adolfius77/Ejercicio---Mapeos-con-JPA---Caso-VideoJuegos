package main;

import Entidades.Direcion;
import Entidades.jugador;
import Entidades.logro;
import Entidades.videojuego;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class pruebas {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("videojuegoPU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            
            Direcion direccionJugador1 = new Direcion(null, "Calle Falsa", "123", "Centro");

            jugador jugador1 = new jugador();
            jugador1.setPsudonimo("Adolfius77");
            jugador1.setSexo("Masculino");
            jugador1.setFechaNacimiento(LocalDate.of(1995, 5, 20));
            jugador1.setDirecion(direccionJugador1); 

            videojuego juego1 = new videojuego();
            juego1.setNombre("The Legend of Zelda: Tears of the Kingdom");
            juego1.setDesarrolladora("Nintendo");
            juego1.setPuntuaje(10); 

            logro logro1 = new logro(null, "Maestro de la Espada", 50); 
            logro logro2 = new logro(null, "Explorador de Hyrule", 100); 

            logro1.setVideojuego(juego1);
            logro2.setVideojuego(juego1);

            Set<logro> logrosDelJuego = new HashSet<>();
            logrosDelJuego.add(logro1);
            logrosDelJuego.add(logro2);
            juego1.setLogros(logrosDelJuego);

            Set<videojuego> videojuegosDelJugador = new HashSet<>();
            Set<jugador> jugadoresDelVideojuego = new HashSet<>();

            videojuegosDelJugador.add(juego1);
            jugadoresDelVideojuego.add(jugador1);

            jugador1.setVideojuegos(videojuegosDelJugador);
            juego1.setJugadores(jugadoresDelVideojuego);
            
            System.out.println("Guardando videojuego en la base de datos...");
            em.persist(juego1);

            em.getTransaction().commit();
            System.out.println("¡Datos guardados con éxito!");

            System.out.println("\n--- Verificando datos guardados ---");
            
            videojuego juegoRecuperado = em.find(videojuego.class, juego1.getId());
            if (juegoRecuperado != null) {
                System.out.println("Juego recuperado: " + juegoRecuperado.getNombre());
                jugador primerJugador = juegoRecuperado.getJugadores().iterator().next();
                System.out.println("Jugador: " + primerJugador.getPsudonimo());
                System.out.println("Direccion: " + primerJugador.getDirecion().getCalle());
                System.out.println("Logros del juego: " + juegoRecuperado.getLogros().size());
            }

        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}