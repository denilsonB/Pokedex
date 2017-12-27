package gui.login;
import connections.UsuarioDAO;
import gui.TelaInicial;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class TelaLoginD2{
    public TelaLoginD2(){
        JFrame telaLogin = new JFrame("Tela de Login");
        
        JLabel labelLogin = new JLabel("LOGIN");
        labelLogin.setBounds(185,20,150,150);
        labelLogin.setFont(new Font("Times New Roman",Font.BOLD,30));

        JLabel labelUsuario = new JLabel("Usuario:");
        labelUsuario.setBounds(100,112,150,150);
        labelUsuario.setFont(new Font("Times New Roman",Font.BOLD,20));

        JLabel labelSenha = new JLabel("Senha:");
        labelSenha.setBounds(113,150,150,150);
        labelSenha.setFont(new Font("Times New Roman",Font.BOLD,20));        
        
        JTextField caixaLogin = new JTextField();
        caixaLogin.setBounds(185,180,140,20);
        
        JPasswordField  caixaSenha = new JPasswordField ();
        caixaSenha.setBounds(185,215,140,20);      
        
        JButton botaoLogin = new JButton("Entrar");
        botaoLogin.setBounds(275,280,85,22);        
botaoLogin.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
        UsuarioDAO conexao = new UsuarioDAO();
        
        String login = caixaLogin.getText();
        String senha = caixaSenha.getText();
        Object[] doBanco = new Object[2];
    try {
        doBanco=conexao.selecionaFromUsuarioByLogin(login);
    } catch (SQLException ex) {
        System.out.println("DEU ERRO1");
    }
        if(senha.equals(doBanco[0])){
            try {
                TelaInicial tela = new TelaInicial(doBanco[1]);
                telaLogin.dispose();
            } catch (SQLException ex) {
                System.out.println("DEU ERRO2");
            }
        }else{
            System.out.println("senha incorreta");
        }
        
        }  
    });        
        
        JButton botaoCadastrar = new JButton("Cadastrar ");
        botaoCadastrar.setBounds(80,280,100,22);          
        botaoCadastrar.addActionListener(new ActionListener(){  
public void actionPerformed(ActionEvent e){  
        telaLogin.dispose();
        TelaCadastroD2 t2 = new TelaCadastroD2();
        }  
    });        
            
        
        
        telaLogin.add(labelLogin);
        telaLogin.add(labelUsuario);
        telaLogin.add(labelSenha);
        telaLogin.add(caixaLogin);
        telaLogin.add(caixaSenha);
        telaLogin.add(botaoLogin);
        telaLogin.add(botaoCadastrar);
        
        telaLogin.setLayout(null);
        telaLogin.setSize(500,500);
        telaLogin.setLocation(400,100);
        telaLogin.setVisible(true);
    }
    public static void main(String[] args) {
        TelaLoginD2 d = new TelaLoginD2();
    }
    
}
