    package gui;

import javax.swing.*;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import pokedex.ListaDePokemons;
import pokedex.Pokemon;

import org.jfree.chart.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import pokedex.Imagem;

public class MostraInfo{
	private JPanel container;
        private JFrame tela;        
	private int idPokemon,idEvolucao;
	private String nomePokemon,descricaoDoPokemon,categoriaDoPokemon;
	private static String pathSexoPokemon2="C:\\pokemonSexo\\";
	private	ArrayList<String> arrayTipo = new ArrayList<String>();
	private double alturaDoPokemon;
 	private double pesoDoPokemon;
 	private	ArrayList<String> arrayHabilidades = new ArrayList<String>();
 	private	ArrayList<String> arraySexo = new ArrayList<String>();
 	private	ArrayList<String> arrayFraquezas = new ArrayList<String>();
 	private JButton[] arrayBotoesTipo = new JButton[2];
	private JButton[] arrayBotoesFraquezas = new JButton[6];
	private int hpDoPokemon,ataqueDoPokemon,defesaDoPokemon,spAtqDoPokemon,spDefDoPokemon,velocidadeDoPokemon;	
	private ListaDePokemons pokemonLista;
	private Imagem imagens = new Imagem();
	public MostraInfo(int id,ListaDePokemons pokemonLista) {
                tela = new JFrame("Informações do Pokemon");
 		Pokemon poke = pokemonLista.getLista().get(id-1);
 		this.pokemonLista=pokemonLista;
 		imagens = new Imagem();
 		System.out.println(poke.getNome());
		container = new JPanel();
		container.setPreferredSize(new Dimension(300, 1300));
		container.setLayout(null);
		
		//-------------------pegar do banco e colocar nessas variaveis--------------------
		idPokemon=id;
		nomePokemon=poke.getNome();
		descricaoDoPokemon=poke.getDescricao();
		arrayTipo = poke.getTipos();		
		alturaDoPokemon=poke.getAltura();
		categoriaDoPokemon=poke.getCategoria();
		pesoDoPokemon =poke.getPeso();
		this.arrayHabilidades=poke.getHabilidades();
		this.arraySexo=poke.getSexo();
		this.arrayFraquezas=poke.getFraquezas(); 
		hpDoPokemon=poke.getVida();
		ataqueDoPokemon=poke.getAtaque();
		defesaDoPokemon=poke.getDefesa();
		spAtqDoPokemon=poke.getAtaqueSp();
		spDefDoPokemon=poke.getDefesaSp();
		velocidadeDoPokemon=poke.getVelocidade();
		idEvolucao=poke.getIdEvolucao();
                
		//------------------------------------------------------------------------------
		
		
		JLabel labelNomeDoPokemon = new JLabel();
		labelNomeDoPokemon.setBounds(270,-50,200,150);
		labelNomeDoPokemon.setFont(new Font("Courier New", Font.BOLD, 25));
		labelNomeDoPokemon.setText(nomePokemon);
		
		JLabel labelNumero = new JLabel();
		labelNumero.setBounds(470,0,50,50);
		labelNumero.setText("N");
		labelNumero.setFont(new Font("Courier New", Font.BOLD, 25));
		
		JLabel labelNumeroDoPokemon = new JLabel();
		labelNumeroDoPokemon.setBounds(505,0,50,50);
		labelNumeroDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 25));
		labelNumeroDoPokemon.setText(""+idPokemon);
                
		Image imagemDoPokemon = imagens.setNewImg(idPokemon, 350, 350);
		JLabel labelImagemDoPokemon = new JLabel(new ImageIcon(imagemDoPokemon));
		labelImagemDoPokemon.setBounds(40, 50, 350, 350);
		
		JTextArea descricaoPokemon = new JTextArea();
		descricaoPokemon.setBounds(470,50,300,120);
		descricaoPokemon.setText(descricaoDoPokemon);
		descricaoPokemon.setFont(new Font("Serial", Font.BOLD, 14));
		descricaoPokemon.setOpaque(false);
		descricaoPokemon.setEditable(false);
		
		JLabel labelTipo = new JLabel();
		labelTipo.setBounds(590,252,100,100);
		labelTipo.setText("Tipo");
		labelTipo.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		int eixoX=520;
		for(int i=0;i<arrayTipo.size();i++) {
			String tipo = arrayTipo.get(i);
			arrayBotoesTipo[i]= new JButton(tipo);
			arrayBotoesTipo[i].setBounds(eixoX,330,100,25);
			eixoX+=110;
		}
		for(int i=0;i<arrayTipo.size();i++) {
			container.add(arrayBotoesTipo[i]);
		}
		
		JLabel labelFraquezas = new JLabel();
		labelFraquezas.setBounds(560,325,200,100);
		labelFraquezas.setText("Fraquezas");
		labelFraquezas.setFont(new Font("Times New Roman", Font.BOLD, 26));
		
		eixoX=390;
		int eixoY=405;
		for(int i=0;i<arrayFraquezas.size();i++) {
			String fraqueza = arrayFraquezas.get(i);
			arrayBotoesFraquezas[i] = new JButton(fraqueza);
			arrayBotoesFraquezas[i].setBounds(eixoX,eixoY,90,25);
			eixoX+=100;
			if(i==3) {
				eixoX=370;
				eixoY+=30;
			}
		}
		for(int i=0;i<arrayFraquezas.size();i++) {
			container.add(arrayBotoesFraquezas[i]);
		}		
		
		JLabel labelAltura = new JLabel();
		labelAltura.setBounds(470,135,100,100);
		labelAltura.setText("Altura");
		labelAltura.setFont(new Font("Times New Roman", Font.BOLD, 20));

		JLabel labelAlturaDoPokemon = new JLabel();
		labelAlturaDoPokemon.setBounds(470,162,100,100);
		labelAlturaDoPokemon.setText(alturaDoPokemon+" m");
		labelAlturaDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));		
		
		JLabel labelCategoria = new JLabel();
		labelCategoria.setBounds(680,135,150,100);
		labelCategoria.setText("Categoria");
		labelCategoria.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelCategoriaDoPokemon = new JLabel();
		labelCategoriaDoPokemon.setBounds(680,160,150,100);
		labelCategoriaDoPokemon.setText(categoriaDoPokemon);
		labelCategoriaDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelPeso = new JLabel();
		labelPeso.setBounds(470,190,100,100);
		labelPeso.setText("Peso");
		labelPeso.setFont(new Font("Times New Roman", Font.BOLD, 20));		

		JLabel labelPesoDoPokemon = new JLabel();
		labelPesoDoPokemon.setBounds(470,215,100,100);
		labelPesoDoPokemon.setText(pesoDoPokemon+" kg");
		labelPesoDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));			
		
		JLabel labelHabilidades = new JLabel();
		labelHabilidades.setBounds(680,190,150,100);
		labelHabilidades.setText("Habilidades");
		labelHabilidades.setFont(new Font("Times New Roman", Font.BOLD, 20));				
		
		
		String habilidades="";
		for(String habilidade:arrayHabilidades) {
			habilidades = habilidades + habilidade + "\n";
		}
		
		JLabel labelHabilidadesDoPokemon = new JLabel();
		labelHabilidadesDoPokemon.setBounds(655,115,300,300);
		labelHabilidadesDoPokemon.setText(habilidades);
		labelHabilidadesDoPokemon.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		eixoX=460;
		for(int i=0;i<arraySexo.size();i++) {
			String sexo = arraySexo.get(i);
                        Image imagemSexo = imagens.setNewImg(sexo, 30, 30);
			JLabel sexoPokemon = new JLabel((Icon) imagemSexo);
			sexoPokemon.setBounds(eixoX, 285, 40, 40);
			container.add(sexoPokemon);
			eixoX+=35;
		}

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
	    ChartPanel grafico = new ChartPanel(chart);
	    grafico.setBounds(70,470,700,400);
	    
	    JScrollPane jsp = new JScrollPane(container);
	   
	    
	    tela.getContentPane().add(jsp);
	    container.add(grafico);	            	         
	    container.add(labelHabilidadesDoPokemon);
	    container.add(labelHabilidades);
	    container.add(labelPesoDoPokemon);
	    container.add(labelPeso);
	    container.add(labelCategoriaDoPokemon);
	    container.add(labelCategoria);
		container.add(labelAlturaDoPokemon);
		container.add(labelAltura);
		container.add(labelFraquezas);
		container.add(labelTipo);
		container.add(descricaoPokemon);
		container.add(labelImagemDoPokemon);
		container.add(labelNumeroDoPokemon);
		container.add(labelNumero);
		container.add(labelNomeDoPokemon);
		boolean desativa = this.mostraEvolucoes(idEvolucao);
		
		tela.setSize(870,800);
		tela.setLocation(250,0);		
		tela.setVisible(true);
	}
	public boolean mostraEvolucoes(int idEvolucao) {
		int idEvolucaoEx=1;
		Pokemon poke2 = new Pokemon();
		if(this.idPokemon!=1) {
			poke2 = pokemonLista.getLista().get(this.idPokemon-1);
			idEvolucaoEx=poke2.getIdEvolucao();
		}
		System.out.println(idEvolucaoEx);
		if(this.idPokemon==1 || idEvolucaoEx!=this.idPokemon) {
			System.out.println("entrou qui");
			//ImageIcon labelImagemDoPokemon = retornaImagemEvolucao(this.idPokemon);
                        Image labelImagemDoPokemon = imagens.setNewImg(idPokemon, 250, 250);                        
			
                        JButton botaoPokemon1 = new JButton((Icon) labelImagemDoPokemon);
                        botaoPokemon1.setBounds(-50, 950, 350, 350);
                        botaoPokemon1.setContentAreaFilled(false);
                        botaoPokemon1.setBorderPainted(false);
			container.add(botaoPokemon1);
			
			botaoPokemon1.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
                                    tela.setVisible(false);
                                    MostraInfo t2 = new MostraInfo(idPokemon,pokemonLista);
                                        
				}  
		    });  
		}else {
			int idEvolucaoEx2=2;
			Pokemon poke3 = pokemonLista.getLista().get(this.idPokemon-2);
			idEvolucaoEx2=poke3.getIdEvolucao();
			if(idEvolucaoEx2==idEvolucaoEx-1) {
				//ImageIcon imagemDoPokemon = retornaImagemEvolucao(idEvolucaoEx2-1);
                                Image labelImagemDoPokemon = imagens.setNewImg(idEvolucaoEx2-1, 250, 250);    
				JButton botaoPokemon  = new JButton((Icon) labelImagemDoPokemon);
                                botaoPokemon.setBounds(-60, 950, 350, 350);					
				Pokemon pokea = pokemonLista.getLista().get(this.idPokemon-2);
                                botaoPokemon.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
                                                tela.setVisible(false);
						MostraInfo t2 = new MostraInfo(pokea.getId(),pokemonLista);
			        }  
			    });  
                                botaoPokemon.setContentAreaFilled(false);
                                botaoPokemon.setBorderPainted(false);                                
				container.add(botaoPokemon);
				//ImageIcon imagemDoPokemon2 = retornaImagemEvolucao(idEvolucaoEx-1);
                                Image imagemDoPokemon2 = imagens.setNewImg(idEvolucaoEx-1, 250, 250);
				JButton botaoPokemon2 = new JButton((Icon) imagemDoPokemon2);
                                botaoPokemon2.setBounds(230, 950, 350, 350);
			//	poke2 = pokemonLista.get(this.idPokemon-1);
				int aux = idEvolucaoEx-1;
				botaoPokemon2.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
						MostraInfo t2 = new MostraInfo(aux,pokemonLista);
			        }  
			    }); 
                                botaoPokemon2.setContentAreaFilled(false);
                                botaoPokemon2.setBorderPainted(false);                                
				container.add(botaoPokemon2);
				//ImageIcon imagemDoPokemon3 = retornaImagemEvolucao(this.idPokemon);
                                Image imagemDoPokemon3 = imagens.setNewImg(this.idPokemon, 250, 250);
				JButton botaoPokemon3 = new JButton((Icon) imagemDoPokemon3);
                                botaoPokemon3.setBounds(545, 950, 350, 350);
				botaoPokemon3.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
                                                tela.setVisible(false);
						MostraInfo t2 = new MostraInfo(idPokemon,pokemonLista);  
			        }  
			    });
                            botaoPokemon3.setContentAreaFilled(false);
                            botaoPokemon3.setBorderPainted(false);                                
				container.add(botaoPokemon3);
			}else {
				//ImageIcon imagemDoPokemon = retornaImagemEvolucao(idEvolucaoEx-1);
                                Image imagemDoPokemon = imagens.setNewImg(idEvolucaoEx-1, 250, 250);
				JButton botaoPokemon = new JButton((Icon) imagemDoPokemon);
                                botaoPokemon.setBounds(-60, 950, 350, 350);		
				
				int aux = idEvolucaoEx-1;
				botaoPokemon.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){
                                                tela.setVisible(false);
						MostraInfo t2 = new MostraInfo(aux,pokemonLista);  
			        }  
			    });  
                                botaoPokemon.setContentAreaFilled(false);
                                botaoPokemon.setBorderPainted(false);	
				container.add(botaoPokemon);
				//ImageIcon imagemDoPokemon2 = retornaImagemEvolucao(this.idPokemon);
                                Image imagemDoPokemon2 = imagens.setNewImg(this.idPokemon, 250, 250);
				JButton botaoPokemon2 = new JButton((Icon) imagemDoPokemon2);
                                botaoPokemon2.setBounds(230, 950, 350, 350);
				
				botaoPokemon2.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
                                            tela.setVisible(false);
                                            MostraInfo t2 = new MostraInfo(idPokemon,pokemonLista);  
			        }  
			    });  
                                botaoPokemon2.setContentAreaFilled(false);
                                botaoPokemon2.setBorderPainted(false);                                
				container.add(botaoPokemon2);
			}
						
			if(idEvolucao!=0) {
				//ImageIcon imagemDoPokemon3 = retornaImagemEvolucao(idEvolucao);
                                Image imagemDoPokemon3 = imagens.setNewImg(idEvolucao, 250, 250);
				JButton botaoPokemon3 = new JButton((Icon) imagemDoPokemon3);
                                botaoPokemon3.setBounds(545, 950, 350, 350);
				int aux = idEvolucao;
				botaoPokemon3.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
                                            tela.setVisible(false);	
                                            MostraInfo t2 = new MostraInfo(aux,pokemonLista);  
			        }  
			    });   
                                botaoPokemon3.setContentAreaFilled(false);
                                botaoPokemon3.setBorderPainted(false);                                
				container.add(botaoPokemon3);	
				idEvolucao=500;
			}
		}
		if(idEvolucao==this.idPokemon+1) {
			System.out.println("entrou qui2");
			//ImageIcon imagemDoPokemon2 = retornaImagemEvolucao(idEvolucao);
                        Image imagemDoPokemon2 = imagens.setNewImg(idEvolucao, 250, 250);
			JButton botaoPokemon2 = new JButton((Icon) imagemDoPokemon2);
                        botaoPokemon2.setBounds(230, 950, 350, 350);	
			
			int aux = idEvolucao;
			botaoPokemon2.addActionListener(new ActionListener(){  
				public void actionPerformed(ActionEvent e){  
                                    tela.setVisible(false);
                                    MostraInfo t2 = new MostraInfo(aux,pokemonLista);  
		        }  
		    });
			container.add(botaoPokemon2);
			Pokemon poke3 = pokemonLista.getLista().get(idEvolucao);
			idEvolucaoEx=poke3.getIdEvolucao();	
			if(idEvolucaoEx!=0) {
				//ImageIcon labelImagemDoPokemon3 = retornaImagemEvolucao(idEvolucaoEx);
                                Image imagemDoPokemon3 = imagens.setNewImg(idEvolucaoEx, 250, 250);
				JButton botaoPokemon3 = new JButton((Icon) imagemDoPokemon3);
                                botaoPokemon3.setBounds(545, 950, 350, 350);	
				
				int aux2 = idEvolucaoEx;
				botaoPokemon3.addActionListener(new ActionListener(){  
					public void actionPerformed(ActionEvent e){  
                                            tela.setVisible(false);
                                            MostraInfo t2 = new MostraInfo(aux2,pokemonLista);  
			        }  
			    });
                                botaoPokemon3.setContentAreaFilled(false);
                                botaoPokemon3.setBorderPainted(false);
				container.add(botaoPokemon3);
				idEvolucao=500;
			}
		
	}
            return false;
        
        }



}
