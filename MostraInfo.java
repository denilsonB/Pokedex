package pokedex;

import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.chart.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MostraInfo {
	private int idPokemon;
	private String nomePokemon;
	private String descricaoDoPokemon;
	private static String pathImagemPokemon="C:\\imagensPokemon\\";
	private String[] arrayTipo = new String[2];
	private double alturaDoPokemon;
 	private String categoriaDoPokemon;
 	private double pesoDoPokemon;
 	private String[] arrayHabilidades = new String[2];
 	private String[] arrayFraquezas = new String[6];
 	private JButton[] arrayBotoesTipo = new JButton[2];
	private JButton[] arrayBotoesFraquezas = new JButton[6];
	private int hpDoPokemon;
	private int ataqueDoPokemon;
	private int defesaDoPokemon;
	private int spAtqDoPokemon;
	private int spDefDoPokemon;
	private int velocidadeDoPokemon;
	
 	public MostraInfo() {
		//-------------------pegar do banco e colocar nessas variaveis--------------------
		idPokemon=1;
		nomePokemon="Bulbassauro";
		descricaoDoPokemon="Bulbasauro pode ser visto se banhando\n sob a luz do sol.\nhá uma semente em suas costas,\nao se banhar no sol\nsua semente vai ficando maior";
		String[] arrayTipos = {"Planta","Venenoso"};		
		alturaDoPokemon=0.7;
		categoriaDoPokemon="Semente";
		pesoDoPokemon = 6.9;
		String[] arrayHabilidades = {"Overgrow"};
		String[] arrayFraquezas = {"Fogo","Voador","Gelo","Psiquico"};
		hpDoPokemon=45;
		ataqueDoPokemon=49;
		defesaDoPokemon=49;
		spAtqDoPokemon=65;
		spDefDoPokemon=65;
		velocidadeDoPokemon=45;
		//------------------------------------------------------------------------------
		JFrame tela = new JFrame("Informações do Pokemon");
		tela.setSize(800,800);
		tela.setLocation(250,0);
		
		JLabel labelNomeDoPokemon = new JLabel();
		labelNomeDoPokemon.setBounds(250,-50,200,150);
		labelNomeDoPokemon.setFont(new Font("Courier New", Font.BOLD, 25));
		labelNomeDoPokemon.setText(nomePokemon);
		
		JLabel labelNumero = new JLabel();
		labelNumero.setBounds(450,0,50,50);
		labelNumero.setText("Nº");
		labelNumero.setFont(new Font("Courier New", Font.BOLD, 25));
		
		JLabel labelNumeroDoPokemon = new JLabel();
		labelNumeroDoPokemon.setBounds(485,0,50,50);
		labelNumeroDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelNumeroDoPokemon.setText(""+idPokemon);
		
		pathImagemPokemon=pathImagemPokemon+idPokemon+".png";
		ImageIcon imagemDoPokemon = new ImageIcon(pathImagemPokemon);
		JLabel labelImagemDoPokemon = new JLabel(imagemDoPokemon);
		labelImagemDoPokemon.setBounds(70, 50, 350, 350);
		
		JTextArea descricaoPokemon = new JTextArea();
		descricaoPokemon.setBounds(450,50,300,120);
		descricaoPokemon.setText(descricaoDoPokemon);
		descricaoPokemon.setFont(new Font("Serial", Font.BOLD, 14));
		descricaoPokemon.setOpaque(false);
		descricaoPokemon.setEditable(false);
		
		JLabel labelTipo = new JLabel();
		labelTipo.setBounds(570,252,100,100);
		labelTipo.setText("Tipo");
		labelTipo.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		int eixoX=500;
		for(int i=0;i<arrayTipos.length;i++) {
			String tipo = arrayTipos[i];
			arrayBotoesTipo[i]= new JButton(tipo);
			arrayBotoesTipo[i].setBounds(eixoX,330,100,25);
			eixoX+=110;
		}
		for(int i=0;i<arrayTipo.length;i++) {
			tela.add(arrayBotoesTipo[i]);
		}
		
		JLabel labelFraquezas = new JLabel();
		labelFraquezas.setBounds(540,325,200,100);
		labelFraquezas.setText("Fraquezas");
		labelFraquezas.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		eixoX=370;
		int eixoY=405;
		for(int i=0;i<arrayFraquezas.length;i++) {
			String fraqueza = arrayFraquezas[i];
			arrayBotoesFraquezas[i] = new JButton(fraqueza);
			arrayBotoesFraquezas[i].setBounds(eixoX,eixoY,90,25);
			eixoX+=100;
			if(i==3) {
				eixoX=370;
				eixoY+=30;
			}
		}
		for(int i=0;i<arrayFraquezas.length;i++) {
			tela.add(arrayBotoesFraquezas[i]);
		}		
		
		JLabel labelAltura = new JLabel();
		labelAltura.setBounds(450,135,100,100);
		labelAltura.setText("Altura");
		labelAltura.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel labelAlturaDoPokemon = new JLabel();
		labelAlturaDoPokemon.setBounds(450,162,100,100);
		labelAlturaDoPokemon.setText(alturaDoPokemon+" m");
		labelAlturaDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));		
		
		JLabel labelCategoria = new JLabel();
		labelCategoria.setBounds(660,135,150,100);
		labelCategoria.setText("Categoria");
		labelCategoria.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelCategoriaDoPokemon = new JLabel();
		labelCategoriaDoPokemon.setBounds(660,160,150,100);
		labelCategoriaDoPokemon.setText(categoriaDoPokemon);
		labelCategoriaDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelPeso = new JLabel();
		labelPeso.setBounds(450,190,100,100);
		labelPeso.setText("Peso");
		labelPeso.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelPesoDoPokemon = new JLabel();
		labelPesoDoPokemon.setBounds(450,215,100,100);
		labelPesoDoPokemon.setText(pesoDoPokemon+" kg");
		labelPesoDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));			
		
		JLabel labelHabilidades = new JLabel();
		labelHabilidades.setBounds(660,190,150,100);
		labelHabilidades.setText("Habilidades");
		labelHabilidades.setFont(new Font("Times New Roman", Font.BOLD, 20));				
		
		
		String habilidades="";
		for(String habilidade:arrayHabilidades) {
			habilidades = habilidades + habilidade + "\n";
		}
		
		JLabel labelHabilidadesDoPokemon = new JLabel();
		labelHabilidadesDoPokemon.setBounds(660,215,150,100);
		labelHabilidadesDoPokemon.setText(habilidades);
		labelHabilidadesDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		JButton botaoEstatisticas = new JButton("Estatísticas");
		botaoEstatisticas.setBounds(0, 400, 120, 20);
		botaoEstatisticas.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
	            DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	            dataset.setValue(hpDoPokemon, "Status", "HP");
	            dataset.setValue(ataqueDoPokemon, "Status", "Ataque");
	            dataset.setValue(defesaDoPokemon, "Status", "Defesa");
	            dataset.setValue(spAtqDoPokemon, "Status", "Sp.Atq");
	            dataset.setValue(spDefDoPokemon, "Status", "Sp.Def");
	            dataset.setValue(velocidadeDoPokemon, "Status", "Velocidade");
	            JFreeChart chart = ChartFactory.createBarChart("Estatísticas", "", "Status", dataset,PlotOrientation.VERTICAL,false,true,false);
	            CategoryPlot p = chart.getCategoryPlot();
	            p.setRangeGridlinePaint(Color.RED);
	            chart.getCategoryPlot().getRenderer(0).setSeriesPaint(0, Color.BLUE); 
	            ChartFrame frame = new ChartFrame("Estatisticas do Pokemon",chart);
	            frame.setSize(600,300);
	            frame.setLocation(250,250);
	            frame.setVisible(true);
	            
	        }  
	    }); 
		
		tela.add(botaoEstatisticas);
		tela.add(labelHabilidadesDoPokemon);
		tela.add(labelHabilidades);
		tela.add(labelPesoDoPokemon);
		tela.add(labelPeso);
		tela.add(labelCategoriaDoPokemon);
		tela.add(labelCategoria);
		tela.add(labelAlturaDoPokemon);
		tela.add(labelAltura);
		tela.add(labelFraquezas);
		tela.add(labelTipo);
		tela.add(descricaoPokemon);
		tela.add(labelImagemDoPokemon);
		tela.add(labelNumeroDoPokemon);
		tela.add(labelNumero);
		tela.add(labelNomeDoPokemon);
		
		tela.setLayout(null);
		tela.setVisible(true);
	}
	

	public static void main(String[] args) {
		MostraInfo ativa = new MostraInfo();
	}
}
