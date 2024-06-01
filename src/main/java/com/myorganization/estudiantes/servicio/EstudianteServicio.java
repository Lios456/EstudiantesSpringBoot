package com.myorganization.estudiantes.servicio;

import com.myorganization.estudiantes.modelo.Estudiantes;
import com.myorganization.estudiantes.repositorio.EstudianteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class EstudianteServicio implements IEstudianteServicio{

    @Autowired
    private EstudianteRepositorio estudianteRepositorio;
    @Override
    public List<Estudiantes> obtenerEstudiantes() {
        List<Estudiantes> estudiantes = estudianteRepositorio.findAll();
        return estudiantes;
    }

    @Override
    public Estudiantes obtenerEstudianteporId(int id) {
        Estudiantes estudiantes = estudianteRepositorio.findById(id).orElse(null);
        return estudiantes;
    }

    @Override
    public void guardarEstudiante(Estudiantes estudiantes) {
        estudianteRepositorio.save(estudiantes);
    }

    @Override
    public void eliminarEstudiante(Estudiantes estudiantes) {
        estudianteRepositorio.delete(estudiantes);
    }
}
