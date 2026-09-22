/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import gui.geom.Forma;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Prof. Dr. David Buzatto
 */
public class PainelDesenho extends JPanel {
    
   // private List<Forma> formas;
    private LinkedStack<Forma> undoStack;
    private LinkedStack<Forma> redoStack;
    
    
    
    public PainelDesenho() {
        //formas = new ArrayList<>();
        undoStack = new LinkedStack<>();
        redoStack = new LinkedStack<>();
    }

    @Override
    protected void paintComponent( Graphics g ) {
        
        super.paintComponent( g );
        
        g.setColor( Color.WHITE );
        g.fillRect( 0, 0, getWidth(), getHeight() );
        
        LinkedStack<Forma> aux = new LinkedStack<>();
        for ( Forma forma : undoStack ) {
            aux.push( forma );
        }
        
        for ( Forma forma : aux ) {
            forma.desenhar( g );
        }
        
    }
    
    public void adicionarForma( Forma forma ) {
        //formas.add( forma );
        undoStack.push(forma);
        
        redoStack.clear();
        
        repaint();
    }
    
    public void undo(){
        if(!undoStack.isEmpty()){
            Forma formaRem = undoStack.pop();
            
            redoStack.push(formaRem);
            repaint();
        }
    }
    
    public void redo(){
        if(!redoStack.isEmpty()){
            Forma formaRest = redoStack.pop();
            undoStack.push(formaRest);
            repaint();
        }
    }
    
}
