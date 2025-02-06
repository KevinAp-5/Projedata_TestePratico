package src.main.entities;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.util.Locale;

public class Funcionario extends Pessoa {
    private BigDecimal salario;
    private String funcao;

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao) {
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String salarioFormatado() {
        DecimalFormatSymbols simbolos = new DecimalFormatSymbols(new Locale("pt", "BR"));
        simbolos.setDecimalSeparator(',');
        simbolos.setGroupingSeparator('.');

        DecimalFormat formato = new DecimalFormat("#,###.00", simbolos);
        return formato.format(this.getSalario());
    }

    // Ao printar o funcionário, o salário e data de nascimento vão estar
    // formatados.
    @Override
    public String toString() {
        return "Nome: " + this.getNome() + ", Data Nascimento: " + super.dataNascimentoFormatada()
                + ", Salário: R$" + salarioFormatado() + ", Função: " + funcao;
    }

    public String salarioMinimoFormatado() {
        BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        BigDecimal qtdSalariosMinimos = this.salario.divide(salarioMinimo, 2, RoundingMode.HALF_UP);
        return qtdSalariosMinimos.toString();
    }

}
