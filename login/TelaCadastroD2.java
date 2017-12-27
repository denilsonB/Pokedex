package gui;

import connections.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class TelaCadastroD2{
    public TelaCadastroD2(){
        JFrame telaCadastro = new JFrame("Tela De Cadastro");
        
        JLabel labelCadastro = new JLabel("Cadastro");
        labelCadastro.setBounds(170,-30, 300, 100);
        labelCadastro.setFont(new Font("Times New Roman",Font.BOLD,25));
        
        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setBounds(85, 40, 100, 100);
        labelUsuario.setFont(new Font("Arial",Font.BOLD,18));
 
        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(97, 70, 100, 100);
        labelSenha.setFont(new Font("Arial",Font.BOLD,18));        
        
        JLabel labelNome = new JLabel("Nome:");
        labelNome.setBounds(99, 105, 100, 100);
        labelNome.setFont(new Font("Arial",Font.BOLD,18)); 

        JLabel labelSobrenome = new JLabel("Sobrenome:");
        labelSobrenome.setBounds(50, 38, 300, 300);
        labelSobrenome.setFont(new Font("Arial",Font.BOLD,18));

        JLabel labelEmail = new JLabel("Email:");
        labelEmail.setBounds(102, 75, 300, 300);
        labelEmail.setFont(new Font("Arial",Font.BOLD,18));
        
        JTextField caixaUsuario = new JTextField();
        caixaUsuario.setBounds(165, 80, 170, 22);

        JPasswordField  caixaSenha = new JPasswordField ();
        caixaSenha.setBounds(165, 110, 170, 22);        
        
        JTextField caixaNome = new JTextField();
        caixaNome.setBounds(165,143,170,22);

        JTextField caixaSobrenome = new JTextField();
        caixaSobrenome.setBounds(165,178,170,22);        

        JTextField caixaEmail = new JTextField();
        caixaEmail.setBounds(165,213,170,22);            
       


        
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.setBounds(160, 280, 75, 22); 
        botaoVoltar.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){
        telaCadastro.setVisible(false);
        TelaLoginD2 t2 = new TelaLoginD2();
}  
    });        
        
        
        JButton botaoCadastrar = new JButton("Cadastrar");
        botaoCadastrar.setBounds(260, 280, 100, 22);
        botaoCadastrar.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){
        UsuarioDAO conexao = new UsuarioDAO();
        
        String usuario = caixaUsuario.getText();
        String senha = caixaSenha.getText();
        String nome = caixaNome.getText();
        String sobrenome = caixaSobrenome.getName();
        String email = caixaEmail.getText();
        
    try {
        conexao.cadastraUsuario(usuario, senha, nome, sobrenome, email);
	System.out.println("cadastrado");
        TelaLoginD2 tela2 = new TelaLoginD2();
    } catch (SQLException ex) {
        System.out.println("Deu erro");
    }
        
}  
    });        
        
        
        telaCadastro.add(botaoVoltar);
        telaCadastro.add(botaoCadastrar);
        telaCadastro.add(labelEmail);
        telaCadastro.add(labelSobrenome);
        telaCadastro.add(labelNome);
        telaCadastro.add(labelCadastro);
        telaCadastro.add(labelUsuario);
        telaCadastro.add(labelSenha);
        telaCadastro.add(caixaEmail);
        telaCadastro.add(caixaUsuario);
        telaCadastro.add(caixaSenha);
        telaCadastro.add(caixaNome);
        telaCadastro.add(caixaSobrenome);
        telaCadastro.setLayout(null);
        telaCadastro.setSize(500,500);
        telaCadastro.setLocation(400,100);
        telaCadastro.setVisible(true);
       
    }
}
