package com.myorganization.estudiantes.repositorio;
import com.myorganization.estudiantes.modelo.Estudiantes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstudianteRepositorio extends JpaRepository<Estudiantes, Integer> {

}
