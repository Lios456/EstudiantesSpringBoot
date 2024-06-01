package com.myorganization.estudiantes.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity //Declara esto como entidad
@Data   // Getters y Setters
@NoArgsConstructor  //Constructor vacío
@AllArgsConstructor //Constructor con todos los argumentos
@ToString   //Método to string
public class Estudiantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEstudiante;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
}
