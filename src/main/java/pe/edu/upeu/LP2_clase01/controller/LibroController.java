package pe.edu.upeu.LP2_clase01.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import pe.edu.upeu.LP2_clase01.entity.Libro;
import pe.edu.upeu.LP2_clase01.service.LibroService;

@RestController
@RequestMapping("/libros")
public class LibroController {
	@Autowired
	private LibroService libroService;
	
	@GetMapping
	public ResponseEntity<List<Libro>> readAll(){
		try {
			List<Libro> Libros = libroService.readAll();
			if(Libros.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(Libros, HttpStatus.OK);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PostMapping
	public ResponseEntity<Libro> crear(@Valid @RequestBody Libro lib){
		try {
			Libro l = libroService.create(lib);
			return new ResponseEntity<>(l, HttpStatus.CREATED);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@GetMapping("/{id}")
	public ResponseEntity<?> getSeccionId(@PathVariable("id") Long id){
		try {
			Optional<Libro> l = libroService.read(id);
			if(l.isEmpty()) {
				return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(l, HttpStatus.OK);
			
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Libro> delSeccion(@PathVariable("id") Long id){
		try {
			libroService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			// TODO: handle exception
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@PutMapping("/{id}")
	public ResponseEntity<?> updateSeccion(@PathVariable("id") Long id, @Valid @RequestBody Libro lib){

			Optional<Libro> l = libroService.read(id);
			if(l.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}else {
				
				return new ResponseEntity<>(libroService.update(lib), HttpStatus.OK);
			}		
		
	}
}
