package examen.rest.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import examen.rest.Models.Alumnos;

@RestController
@CrossOrigin("http://localhost:8080/")
@RequestMapping("/api/")
public class ApiController {
    List<Alumnos> listadoAlumnos = new ArrayList<>();
    @PostMapping("ALUMNOS/LIST")
	public ResponseEntity<List<Alumnos>> listadoAlumnos() {
		return new ResponseEntity(listadoAlumnos, HttpStatus.OK);
	}

	@PostMapping("ALUMNOS/INSERT")
	public ResponseEntity<Alumnos> insertarAlumnos() {
        Alumnos alumno = new Alumnos(1, "nombre", "SI");
        listadoAlumnos.add(alumno);
		return new ResponseEntity(alumno, HttpStatus.CREATED);
	}

    @GetMapping("ALUMNOS/DELETE/")
	public ResponseEntity DeleteAlumnos(@RequestParam("id") int id) {
        try{
            listadoAlumnos.remove(id-1);
        }catch(Exception e){
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
		return new ResponseEntity(HttpStatus.OK);
	}

    @GetMapping("ALUMNOS/DELETEALL")
	public ResponseEntity<List<Alumnos>> DeleteAlumnos() {
        listadoAlumnos.clear();
		return new ResponseEntity(listadoAlumnos, HttpStatus.OK);
	}

    @GetMapping("ALUMNOS/UPDATE/{param}/")
	public ResponseEntity<Alumnos> UpdateAlumnos(@PathVariable int param, @RequestParam("fct") String fct) {
        Alumnos alumno = new Alumnos(0, "nombre", fct);
        try{
            listadoAlumnos.set(0, alumno);
        }catch(Exception e){
            return new ResponseEntity(alumno,HttpStatus.CONFLICT);
        }
        return new ResponseEntity(alumno, HttpStatus.ACCEPTED);
	}
}
