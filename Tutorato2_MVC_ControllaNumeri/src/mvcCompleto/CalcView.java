package mvcCompleto;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.Observable;
import java.util.Observer;

// View della Calcolatrice. Implementiamo "Observer" per fare in modo di
// controllare le modifiche sul model e venir notificati ad ogni modifica
// del model
class CalcView extends JFrame implements Observer {
    // Campi della view
    private JTextField m_userInputTf = new JTextField(5);
    private JTextField m_totalTf     = new JTextField(20);
    private JButton    m_checkBtn = new JButton("Controlla");
    
    // Riferimento a model
    private CalcModel m_model;
    
    // Costruttore
    CalcView(CalcModel model) {
    	// Alloco il riferimento passato relativo al modello
    	m_model = model;
    	// Il model implementa Observable, aggiungo al modello un Observer 
    	// (la view stessa)
    	m_model.addObserver(this);
    	
    	// Inizio a configurare la vista
        m_totalTf.setText(model.getResult());
        m_totalTf.setEditable(false);
        
        // Layout dei componenti  
        JPanel content = new JPanel();
        content.setLayout(new FlowLayout());
        content.add(new JLabel("Input"));
        content.add(m_userInputTf);
        content.add(m_checkBtn);
        content.add(new JLabel("Result"));
        content.add(m_totalTf);
        
        // Creo il contenitore...
        this.setContentPane(content);
        this.pack();
        // Imposto il titolo alla view
        this.setTitle("Simple Check Num - MVC");
        // Imposto il meccanismo di chiusura sulla finestra
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
        
    /*
     * I metodi seguenti servono a chi detiene un riferimento alla view 
     * (il controller)
     * Se non ci fossero, il controller dovrebbe avere un riferimento 
     * esplicito a tutti gli elementi della view per poter svolgere 
     * operazioni. In questo modo, invece, � sufficiente avere il 
     * riferimento all'intera classe CalcView.
     */
    // Getter per rendere disponibile all'esterno il valore del campo 
    // testo del textField
    String getUserInput() {
        return m_userInputTf.getText();
    }    
    
    // Rende disponibile all'esterno l'eventuale testo del messaggio di errore 
    void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }
    
    // Permette di impostare dall'esterno il listener del bottone moltiplica
    void addCheckListener(ActionListener mal) {
        m_checkBtn.addActionListener(mal);
    }

	// Ereditato da Observer, chiama il metodo update definito localmente 
    // quando l'osservato (il modello) effettua una notifica
	@Override
	public void update(Observable o, Object arg) {
		update();		
	}
	
    // Permette di fare l'update dall'esterno.
    // In questo caso è l'azione compiuta dalla GUI quando il model 
	// (che è stato impostato come Observable) effettua una notifica
	private void update() {
		// Estraggo il valore corrente della "memoria" del modello dal
		// riferimento al modello e aggiorno il textField.
		System.out.println("[VIEW] Notified by the model");
		m_totalTf.setText(m_model.getResult());
	}


}
