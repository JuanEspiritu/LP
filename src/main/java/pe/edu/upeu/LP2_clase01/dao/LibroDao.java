package pe.edu.upeu.LP2_clase01.dao;

import java.util.List;
import java.util.Optional;

import pe.edu.upeu.LP2_clase01.entity.Libro;

public interface LibroDao {
	Libro create(Libro l);
	Libro update(Libro l);
	void delete(Long id);
	Optional<Libro> read(Long id);
	List<Libro> readAll();
}
