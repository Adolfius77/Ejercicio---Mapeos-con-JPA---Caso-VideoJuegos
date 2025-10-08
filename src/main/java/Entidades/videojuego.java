/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 *
 * @author adoil
 */
@Entity
public class videojuego implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nombre;
    private String puntuaje;
    private String desarrolladora;
    
    @OneToMany(mappedBy = "videojuego", cascade = CascadeType.ALL)
    private Set<logro> logros;
    
    @ManyToMany
    @JoinTable(
            name = "videojuego_jugador",
            joinColumns = @JoinColumn(name = "videojuego_id"),
            inverseJoinColumns = @JoinColumn(name = "jugador_id")
            

    )
    private Set<jugador> jugadores;
    
    public videojuego() {
    }

    public videojuego(Long id, String nombre, String puntuaje, String desarrolladora, Set<logro> logros, Set<jugador> jugadores) {
        this.id = id;
        this.nombre = nombre;
        this.puntuaje = puntuaje;
        this.desarrolladora = desarrolladora;
        this.logros = logros;
        this.jugadores = jugadores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPuntuaje() {
        return puntuaje;
    }

    public void setPuntuaje(String puntuaje) {
        this.puntuaje = puntuaje;
    }

    public String getDesarrolladora() {
        return desarrolladora;
    }

    public void setDesarrolladora(String desarrolladora) {
        this.desarrolladora = desarrolladora;
    }

    public Set<logro> getLogros() {
        return logros;
    }

    public void setLogros(Set<logro> logros) {
        this.logros = logros;
    }

    public Set<jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Set<jugador> jugadores) {
        this.jugadores = jugadores;
    }

    
    
}
