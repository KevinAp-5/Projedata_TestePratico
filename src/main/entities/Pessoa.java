package src.main.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Pessoa {
    private String nome;

    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

    // public Pessoa(String nome, String dataNasicmento) {
    // this.nome = nome;
    // this.dataNascimento = stringToLocalDate(dataNasicmento);
    // }

    public Pessoa() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    @Override
    public String toString() {
        return "Nome: " + nome + ", Data de Nascimento: " + dataNascimentoFormatada();
    }

    // Função para converter a data de nascimento para o formato solicitado
    public String dataNascimentoFormatada() {
        DateTimeFormatter dataTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataTimeFormatter.format(this.getDataNascimento());
    }

    // @Override
    // public int hashCode() {
    //     final int prime = 31;
    //     int result = 1;
    //     result = prime * result + ((nome == null) ? 0 : nome.hashCode());
    //     return result;
    // }

    // @Override
    // public boolean equals(Object obj) {
    //     if (this == obj)
    //         return true;
    //     if (obj == null)
    //         return false;
    //     if (getClass() != obj.getClass())
    //         return false;
    //     Pessoa other = (Pessoa) obj;
    //     if (nome == null) {
    //         if (other.nome != null)
    //             return false;
    //     } else if (!nome.equals(other.nome))
    //         return false;
    //     return true;
    // }

    // private LocalDate stringToLocalDate(String dataNascimento) {
    // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd");
    // formatter = formatter.withLocale(putAppropriateLocaleHere); // Locale
    // specifies human language for translating,
    // // and cultural norms for lowercase/uppercase and
    // // abbreviations and such. Example: Locale.US or
    // // Locale.CANADA_FRENCH
    // LocalDate date = LocalDate.parse("2005-nov-12", formatter);
    // }
}
