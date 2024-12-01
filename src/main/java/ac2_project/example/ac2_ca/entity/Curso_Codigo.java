package ac2_project.example.ac2_ca.entity;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class Curso_Codigo {

    private String codigo;

    // Construtor padrão necessário para o JPA
    protected Curso_Codigo() {}

    public Curso_Codigo(String codigo) {
        if (codigo == null || !codigo.matches("[a-zA-Z]+")) {
            throw new IllegalArgumentException("Código inválido");
        }
        this.codigo = codigo;
    }

    public String getCodigo() {
        return this.codigo;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso_Codigo cod = (Curso_Codigo) o;
        return Objects.equals(codigo, cod.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

	
	
}