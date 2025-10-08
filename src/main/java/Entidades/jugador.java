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
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

/**
 *
 * @author adoil
 */
@Entity
public class jugador implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String psudonimo;
    private String sexo;
    private LocalDate fechaNacimiento;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direcion direcion;
    
    @ManyToMany(mappedBy = "jugadores")
    private Set<videojuego> videojuegos;

    public jugador() {
    }

    public jugador(Long id, String psudonimo, String sexo, LocalDate fechaNacimiento, Direcion direcion, Set<videojuego> videojuegos) {
        this.id = id;
        this.psudonimo = psudonimo;
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.direcion = direcion;
        this.videojuegos = videojuegos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPsudonimo() {
        return psudonimo;
    }

    public void setPsudonimo(String psudonimo) {
        this.psudonimo = psudonimo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Direcion getDirecion() {
        return direcion;
    }

    public void setDirecion(Direcion direcion) {
        this.direcion = direcion;
    }

    public Set<videojuego> getVideojuegos() {
        return videojuegos;
    }

    public void setVideojuegos(Set<videojuego> videojuegos) {
        this.videojuegos = videojuegos;
    }

   
    
    
}
