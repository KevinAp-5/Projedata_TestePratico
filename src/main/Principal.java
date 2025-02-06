package src.main;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import src.main.entities.Funcionario;

public class Principal {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);

        List<Funcionario> funcionarioLista = new ArrayList<>();

        // 3.1 – Inserir todos os funcionários, na mesma ordem e informações da tabela
        funcionarioLista
                .add(new Funcionario("Maria", LocalDate.of(2000, 10, 18), BigDecimal.valueOf(2009.44), "Operador"));
        funcionarioLista
                .add(new Funcionario("João", LocalDate.of(1990, 5, 12), BigDecimal.valueOf(2284.38), "Operador"));
        funcionarioLista
                .add(new Funcionario("Caio", LocalDate.of(1961, 5, 2), BigDecimal.valueOf(9836.14), "Coordenador"));
        funcionarioLista
                .add(new Funcionario("Miguel", LocalDate.of(1988, 10, 14), BigDecimal.valueOf(19119.88), "Diretor"));
        funcionarioLista
                .add(new Funcionario("Alice", LocalDate.of(1995, 1, 5), BigDecimal.valueOf(2234.68), "Recepcionista"));
        funcionarioLista
                .add(new Funcionario("Heitor", LocalDate.of(1999, 11, 19), BigDecimal.valueOf(1582.72), "Operador"));
        funcionarioLista
                .add(new Funcionario("Arthur", LocalDate.of(1993, 3, 31), BigDecimal.valueOf(4071.84), "Contador"));
        funcionarioLista
                .add(new Funcionario("Laura", LocalDate.of(1994, 7, 8), BigDecimal.valueOf(3017.45), "Gerente"));
        funcionarioLista
                .add(new Funcionario("Helóisa", LocalDate.of(2003, 5, 24), BigDecimal.valueOf(1606.85), "Eletricista"));
        funcionarioLista
                .add(new Funcionario("Helena", LocalDate.of(1996, 9, 2), BigDecimal.valueOf(2799.93), "Gerente"));

        // 3.2 – Remover o funcionário “João” da lista.
        funcionarioLista.removeIf(x -> x.getNome().equals("João"));
        System.out.println("João removido da tabela");

        /*
         * 3.3 – Imprimir todos os funcionários com todas suas informações, sendo que:
         * • informação de data deve ser exibido no formato dd/mm/aaaa;
         * • informação de valor numérico deve ser exibida no formatado com separador de
         * milhar como ponto e decimal como vírgula.
         */

        System.out.println("-----------------------------");
        System.out.println("3.3 Funcionários impressos com as formatações solicitadas(João já removido)");
        for (Funcionario funcionario : funcionarioLista) {
            System.out.println(funcionario);
        }

        // 3.4 – Os funcionários receberam 10% de aumento de salário, atualizar a lista
        // de funcionários com novo valor.
        funcionarioLista.stream().forEach(x -> x.setSalario(aumentoSalario(x.getSalario(), BigDecimal.valueOf(10L))));

        System.out.println("-----------------------------");
        System.out.println("3.4 Lista de funcionário com o salário ajustado para aumento de 10%");
        for (Funcionario funcionario : funcionarioLista) {
            System.out.println(funcionario);
        }

        // 3.5 – Agrupar os funcionários por função em um MAP, sendo a chave a “função”
        // e o valor a “lista de funcionários”.

        // Primeira implementação
        // Map<String, List<Funcionario>> funcionariosMap = new HashMap<>();
        // String[] funcao = new String[] { "Operador", "Coordenador", "Diretor",
        // "Recepcionista", "Contador", "Gerente",
        // "Eletricista" };
        // for (String func : funcao) {
        // funcionariosMap.put(func, funcionarioLista.stream().filter(x ->
        // x.getFuncao().equals(func)).toList());
        // }

        // Refatorado
        Map<String, List<Funcionario>> funcionariosMap = new HashMap<>();
        for (Funcionario func : funcionarioLista) {
            funcionariosMap.computeIfAbsent(func.getFuncao(), k -> new ArrayList<>()).add(func);
        }

        // 3.6 – Imprimir os funcionários, agrupados por função.

        System.out.println("------------------");
        System.out.println("Funcionários agrupados por função");
        funcionariosMap.forEach((x, y) -> System.out.printf("%s: %n   %s  | %d%n", x, y, y.size()));

        // 3.8 – Imprimir os funcionários que fazem aniversário no mês 10 e 12.
        System.out.println("---------------------");
        System.out.println("Funcionários com aniversário em outubro e dezembro");
        for (Funcionario func : funcionarioLista) {
            int mesNascimento = func.getDataNascimento().getMonthValue();
            if (mesNascimento == 10 || mesNascimento == 12) {
                System.out.println(func);
            }
        }

        // 3.9 – Imprimir o funcionário com a maior idade, exibir os atributos: nome e

        // idade.

        // Primeira implementação
        // Funcionario funcionarioMaisVelho = null;
        // LocalDate idade = LocalDate.now(); // Variável declarada para comparar as
        // idades
        // for (Map.Entry<String, List<Funcionario>> set : funcionariosMap.entrySet()) {
        // for (Funcionario func : set.getValue()) {
        // if (func.getDataNascimento().isBefore(idade)) {
        // funcionarioMaisVelho = func;
        // idade = func.getDataNascimento();
        // }
        // }
        // }
        // System.out.println("------------------");
        // if (funcionarioMaisVelho != null) {
        // System.out.println("Funcionário mais velho:");
        // System.out.println(funcionarioMaisVelho.getNome() + ", " +
        // funcionarioMaisVelho.dataNascimentoFormatada());
        // }

        // Refatorado
        Funcionario funcionarioMaisVelho = funcionarioLista.stream()
                .min(Comparator.comparing(Funcionario::getDataNascimento))
                .orElse(null);

        System.out.println("------------------");
        if (funcionarioMaisVelho != null) {
            int idade = LocalDate.now().getYear() - funcionarioMaisVelho.getDataNascimento().getYear();
            System.out.println("Funcionário mais velho:");
            System.out.println(funcionarioMaisVelho.getNome() + ", " + idade + " anos");
        }

        // 3.10 – Imprimir a lista de funcionários por ordem alfabética.
        System.out.println("----------------------------");
        System.out.println("Lista de funcionários por ordem alfabética");
        funcionarioLista.sort(Comparator.comparing(Funcionario::getNome));
        for (Funcionario funcionario : funcionarioLista) {
            System.out.println(funcionario);
        }

        // 3.11 – Imprimir o total dos salários dos funcionários.
        BigDecimal totalSalario = BigDecimal.ZERO;
        for (Funcionario func : funcionarioLista) {
            totalSalario = totalSalario.add(func.getSalario());
        }

        /*
         * Declarado um objeto novo apenas para utilizar o método salarioFormatado()
         * Não é performático nem otimizado esse tipo de declaração em prod, apenas
         * para ter a formatação nesse teste :)
         */

        System.out.println("----------------------");
        Funcionario slave = new Funcionario("Keven", LocalDate.of(2003, 10, 17), totalSalario, "Desenvolvedor Java ;)");
        System.out.println("Total dos salários: R$ " + slave.salarioFormatado());

        // Primeira implementação
        // for (Funcionario func : funcionarioLista) {
        //     BigDecimal salarioMinimo = BigDecimal.valueOf(1212.00);
        //     BigDecimal salarioMinimoFunc = func.getSalario().divide(salarioMinimo, 2, RoundingMode.HALF_UP);
        //     System.out.printf("%s ganha %s salário(s) minimo%n", func.getNome(), salarioMinimoFunc);
        // }

        // Refatorado com método adicionado na entidade Funcionario
        System.out.println("----------------------");
        for (Funcionario func : funcionarioLista) {
            System.out.printf("%s ganha %s salário(s) mínimo%n", func.getNome(), func.salarioMinimoFormatado());
        }

    }

    public static BigDecimal aumentoSalario(BigDecimal salario, BigDecimal porcentagem) {
        porcentagem = porcentagem.divide(BigDecimal.valueOf(100));
        BigDecimal aumento = salario.add(salario.multiply(porcentagem));
        return aumento;
    }
}
