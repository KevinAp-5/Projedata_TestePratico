# 🚀 Teste Prático - Projedata

Este repositório contém minha solução para o teste técnico da **Projedata**. Durante o desenvolvimento, busquei escrever um código limpo, bem estruturado e de fácil compreensão. Para que possam acompanhar minha linha de raciocínio, mantive as primeiras implementações comentadas e as versões otimizadas no código final.

## 📝 Descrição

O projeto realiza diversas operações sobre uma lista de funcionários, incluindo:

✅ Cadastro e manipulação de funcionários  
✅ Remoção de um funcionário específico  
✅ Formatação e impressão de dados  
✅ Aumento salarial  
✅ Agrupamento por função  
✅ Identificação do funcionário mais velho  
✅ Ordenação alfabética  
✅ Cálculo do total dos salários  
✅ Comparação com salário mínimo  

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **API de Data e Hora (java.time)**
- **BigDecimal** para cálculos financeiros

## 📂 Estrutura do Projeto

```
📦 src/main  
 ┣ 📂 entities  
 ┃ ┣ 📜 Pessoa.java  
 ┃ ┣ 📜 Funcionario.java  
 ┣ 📜 Principal.java  
```

## 🚀 Como Executar

1. **Clone o repositório:**  
   ```sh
   git clone https://github.com/KevinAp-5/Projedata_TestePratico.git
   ```  
2. **Abra o projeto em sua IDE favorita** (IntelliJ, Eclipse, VS Code, etc.)  
3. **Compile e execute o arquivo `Principal.java`**  

## 📌 Observações

- O código inclui tanto as implementações iniciais (comentadas) quanto as versões refatoradas.  
- O método `salarioMinimoFormatado()` foi adicionado na entidade `Funcionario` para facilitar a exibição.  
- O cálculo de idade e a busca do funcionário mais velho foram otimizados com `Comparator.comparing()`.  

## 💡 Conclusão

Gostei bastante da dinâmica do teste! Foi um exercício interessante para estruturar e refatorar código. Espero que apreciem minha solução e fiquem à vontade para entrar em contato para discutir qualquer detalhe! 🚀
