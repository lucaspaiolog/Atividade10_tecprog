package br.edu.fatecpg.swing.model;

import javax.swing.JOptionPane;

public class Empresa {
    private Cliente[] clientes = new Cliente[5];
    private Funcionario[] funcionarios = new Funcionario[10];
    private int clienteCount = 0;
    private int funcionarioCount = 0;

    public void adicionarCliente(String nome, String email) {
        if (clienteCount < clientes.length) {
            clientes[clienteCount++] = new Cliente(nome, email);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de clientes atingido.");
        }
    }

    public String exibirClientes() {
        StringBuilder sb = new StringBuilder("Clientes cadastrados:\n");
        for (int i = 0; i < clienteCount; i++) {
            sb.append("Nome: ").append(clientes[i].getNome())
              .append(", Email: ").append(clientes[i].getEmail())
              .append("\n");
        }
        return sb.toString();
    }

    public void adicionarFuncionario(String nome, String cargo, double salario) {
        if (funcionarioCount < funcionarios.length) {
            funcionarios[funcionarioCount++] = new Funcionario(nome, cargo, salario);
        } else {
            JOptionPane.showMessageDialog(null, "Limite de funcionários atingido.");
        }
    }

    public String exibirFuncionarios() {
        StringBuilder sb = new StringBuilder("Funcionários cadastrados:\n");
        for (int i = 0; i < funcionarioCount; i++) {
            sb.append("Nome: ").append(funcionarios[i].getNome())
              .append(", Cargo: ").append(funcionarios[i].getCargo())
              .append(", Salário: ").append(funcionarios[i].getSalario())
              .append("\n");
        }
        return sb.toString();
    }

    public double calcularFolhaSalarial() {
        double total = 0;
        for (int i = 0; i < funcionarioCount; i++) {
            total += funcionarios[i].getSalario();
        }
        return total;
    }

    public double calcularMediaSalarial() {
        if (funcionarioCount == 0) return 0;

        Calculadora calculadora = new Calculadora();
        double somaSalarios = 0;
        for (int i = 0; i < funcionarioCount; i++) {
            somaSalarios = calculadora.soma(somaSalarios, funcionarios[i].getSalario());
        }
        return calculadora.multiplicacao(somaSalarios, 1.0 / funcionarioCount);
    }

    public String exibirMediaSalarial() {
        return "Média Salarial: " + calcularMediaSalarial();
    }
}
