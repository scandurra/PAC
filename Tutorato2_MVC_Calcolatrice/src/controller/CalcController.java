package controller;

import java.awt.event.*;

import model.CalcModel;
import view.CalcView;

public class CalcController {
    //Riferimenti, il controller deve interagire sia con la view che con il modello
    private CalcModel m_model;
    private CalcView  m_view;
    
    
    //Costruttore
    public CalcController(CalcModel model, CalcView view) {
    	//alloco i riferimenti passati
        m_model = model;
        m_view  = view;
        
        //Aggiungo i listener (definiti qui) alla view attraverso i metodi appositi 
        //messi a disposizione della view
        view.addMultiplyListener(new MultiplyListener());
        view.addClearListener(new ClearListener());
    }
    
    
    /*
     * Definizione dei listener (Inner classes)
     */
    //Listener per la moltiplicazione. Questa azione viene eseguita quando 
    //l'utente preme il tasto di moltiplicazione
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	System.out.println("[CONTROLLER] multiply action received");
            String userInput = "";
            try {
            	//uso il riferimento alla view per catturare l'input
            	//inserito dall'utente
                userInput = m_view.getUserInput();
                //uso il riferimento al modello per fargli eseguire la moltiplicazione
                m_model.multiplyBy(userInput);
            } catch (NumberFormatException nfex) {
                m_view.showError("Bad input: '" + userInput + "'");
            }
        }
    }
    
    //Listener per il reset. Questa azione viene eseguita quando 
    //l'utente preme il tasto di clear
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
        	System.out.println("[CONTROLLER] reset action received");
        	//Uso il riferimento al modello per fargli effettuare il reset
            m_model.reset();
         }
    }
}
