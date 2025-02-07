package src.main.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Pessoa {
    private String nome;

    private LocalDate dataNascimento;

    public Pessoa(String nome, LocalDate dataNascimento) {
        this.nome = nome;
        this.dataNascimento = dataNascimento;
    }

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

}
