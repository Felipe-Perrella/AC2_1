package ac2_project.example.ac2_ca.entity;

import java.util.Objects;
import jakarta.persistence.*;

@Embeddable
public class Aluno_Senha {

    private String password;

    // Construtor padrão necessário para o JPA
    protected Aluno_Senha() {}

    public Aluno_Senha(String password) {
        if (password == null || password.length() < 8) {
            throw new IllegalArgumentException("Senha inválida");
        }
        this.password = password;
    }

    public String getEmailAddress() {
        return password;
    }

    // Sobrescreva equals e hashCode para garantir comparação por valor
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno_Senha alpassword = (Aluno_Senha) o;
        return Objects.equals(password, alpassword.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(password);
    }

	
}