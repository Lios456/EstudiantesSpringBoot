package com.myorganization.estudiantes;

import com.myorganization.estudiantes.modelo.Estudiantes;
import com.myorganization.estudiantes.servicio.EstudianteServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {
	@Autowired
	private EstudianteServicio estudianteServicio;
	private static final Logger logger =
			LoggerFactory.getLogger(EstudiantesApplication.class);
	private static String nl = System.lineSeparator();
	@Override
	public void run(String... args) throws Exception {
		logger.info(nl + "EJECUTANDO RUN DE SPRINT ..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpcion(consola);
			logger.info(nl);
		}
	}
	private void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				Sistema de Estudiantes
				1. Listar 
				2. Buscar
				3. Agregar
				4. Modificar
				5. Eliminar
				6. Salir
				Elige una opción:""");
	}

	private boolean ejecutarOpcion(Scanner consola){
		var salir = false;
		try{
			var opcion = Integer.parseInt(consola.nextLine());
			switch(opcion){
				case 1:{
					// Listar estudiantes
					logger.info(nl + "Lista de Estudiantes" + nl);
					estudianteServicio.obtenerEstudiantes().forEach(System.out::println);
					break;
				}

				case 2:{
					// Buscar estudiantes
					logger.info(nl + "Buscar Estudiante" + nl);
					logger.info("Ingres el ID: ");
					var id = Integer.parseInt(consola.nextLine());
					Estudiantes est = estudianteServicio.obtenerEstudianteporId(id);
					if(est == null){
						logger.info(nl + "El estudiante no existe" + nl);
					}else{
						logger.info(String.valueOf(est));
					}
					break;
				}
				case 3: {
					logger.info("Agregar Estudiante" + nl);
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Teléfono: ");
					var telefono = consola.nextLine();
					logger.info("Email: ");
					var email = consola.nextLine();
					var estudiante = new Estudiantes();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante agregado" + estudiante + nl);
					break;
				}
				case 4:{
					logger.info("Modificar estudiante" + nl);
					logger.info("Id:\t");
					var id = Integer.parseInt(consola.nextLine());

					var estudiante = estudianteServicio.obtenerEstudianteporId(id);

					if (estudiante!=null){
						logger.info("Nombre: ");
						var nombre = consola.nextLine();
						logger.info("Apellido: ");
						var apellido = consola.nextLine();
						logger.info("Teléfono: ");
						var telefono = consola.nextLine();
						logger.info("Email: ");
						var email = consola.nextLine();
						estudiante.setNombre(nombre);
						estudiante.setApellido(apellido);
						estudiante.setTelefono(telefono);
						estudiante.setEmail(email);
						estudiante.setIdEstudiante(id);
						estudianteServicio.guardarEstudiante(estudiante);
						logger.info("Estudiante modificado "+ estudiante + nl);
					}else{
						logger.info("No existe ese estudiante");
					}
					break;
				}
				case 5:{
					logger.info("Eliminar estudiante" + nl);
					logger.info("Id:\t");
					var id = Integer.parseInt(consola.nextLine());
					var estudiante = estudianteServicio.obtenerEstudianteporId(id);
					if(estudiante != null){
						estudianteServicio.eliminarEstudiante(estudiante);
						logger.info("Estudiante eliminado " + estudiante + nl);
					}else{
						logger.info("Estudiante no existe " + id + nl);
					}
					break;
				}
				case 6:{
					salir = true;
					break;
				}
				default:{
					logger.info("Opción no válida" + nl);
					break;
				}
			}
		}catch (Exception e) {
			logger.info("Entrada no válida: " + e.getMessage() + nl);
		}
		return salir;
	}

	public static void main(String[] args) {
		logger.info(nl + "INICIANDO ..." + nl);
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info(nl + "FINALIZADO ..." + nl);
	}

}
