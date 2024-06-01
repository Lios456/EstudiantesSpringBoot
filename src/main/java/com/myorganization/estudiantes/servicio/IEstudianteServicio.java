package com.myorganization.estudiantes.servicio;

import com.myorganization.estudiantes.modelo.Estudiantes;

import java.util.List;

public interface IEstudianteServicio {
    public List<Estudiantes> obtenerEstudiantes();
    public Estudiantes obtenerEstudianteporId(int id);
    public void guardarEstudiante(Estudiantes estudiantes);
    public void eliminarEstudiante(Estudiantes estudiantes);
}
