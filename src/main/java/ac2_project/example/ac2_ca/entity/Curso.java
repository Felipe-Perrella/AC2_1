package ac2_project.example.ac2_ca.entity;

import jakarta.persistence.*;
import lombok.*;


@Table(name = "tb_Curso")
@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor

@Entity
public class Curso {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Embedded
	private Curso_Codigo codigo;
	
	public String getCodigo(){
		return this.codigo.getCodigo();
	}
}
