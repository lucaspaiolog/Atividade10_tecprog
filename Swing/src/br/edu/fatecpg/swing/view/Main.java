package br.edu.fatecpg.swing.view;

import br.edu.fatecpg.swing.model.Empresa;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Empresa empresa = new Empresa();

    public Main() {
        setTitle("Sistema de Gestão de Empresa");
        setSize(500, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JButton btnAddCliente = new JButton("Adicionar Cliente");
        JButton btnExibirClientes = new JButton("Exibir Clientes");
        JButton btnAddFuncionario = new JButton("Adicionar Funcionário");
        JButton btnExibirFuncionarios = new JButton("Exibir Funcionários");
        JButton btnExibirFolha = new JButton("Exibir Folha Salarial");
        JButton btnExibirMedia = new JButton("Exibir Média Salarial");

        btnAddCliente.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Cliente:");
                String email = JOptionPane.showInputDialog("Email do Cliente:");
                empresa.adicionarCliente(nome, email);
            }
        });

        btnExibirClientes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.exibirClientes());
            }
        });

        btnAddFuncionario.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nome = JOptionPane.showInputDialog("Nome do Funcionário:");
                String cargo = JOptionPane.showInputDialog("Cargo do Funcionário:");
                double salario = Double.parseDouble(JOptionPane.showInputDialog("Salário do Funcionário:"));
                empresa.adicionarFuncionario(nome, cargo, salario);
            }
        });

        btnExibirFuncionarios.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.exibirFuncionarios());
            }
        });

        btnExibirFolha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Total da Folha Salarial: " + empresa.calcularFolhaSalarial());
            }
        });

        btnExibirMedia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, empresa.exibirMediaSalarial());
            }
        });

        add(btnAddCliente);
        add(btnExibirClientes);
        add(btnAddFuncionario);
        add(btnExibirFuncionarios);
        add(btnExibirFolha);
        add(btnExibirMedia);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
