/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokedex;

import javax.swing.ImageIcon;
import java.awt.Image;
/**
 *
 * @author aluno
 */
public class Imagem {
    
    private Image newImg;
    
    public Image setNewImg(boolean adicionado, String caminho, int width, int height) {
    	if(adicionado) {
    		System.out.println("x");
    		caminho = "../imagensBotoes/"+caminho+".png";
    	}
    	else {
    		System.out.println("r");
    		caminho = "../imagensBotoes/nao-"+caminho+".png";
    	}
    	ImageIcon img = new ImageIcon(getClass().getResource(caminho));
    	this.newImg = img.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    	
    	return getNewImg();
    }
    
    public Image setNewImg(int caminho, int width, int height) {
    	
    	ImageIcon img = new ImageIcon(getClass().getResource("../imagensPokemon/"+caminho+".png"));
    	this.newImg = img.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
    	
    	return getNewImg();
    }
    public Image setNewImg(String sexo,int width,int height){
        ImageIcon img = new ImageIcon(getClass().getResource("../pokemonSexo/"+sexo+".png"));
        this.newImg = img.getImage().getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
        
        return getNewImg();
    }
    
    
    public Image getNewImg(){
        return this.newImg;
    }
   
}
