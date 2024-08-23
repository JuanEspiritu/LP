package pe.edu.upeu.LP2_clase01.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="libros")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	@Column(name="titulo")
	private String titulo;
	@Column(name="paginas")
	private Integer paginas;
	@Column(name="edicion")
	private String edicion;
	@Column(name="estado")
	private char estado;
	@ManyToOne
	@JoinColumn(name="seccion_id", nullable = false)
	private Seccion seccion;
}
