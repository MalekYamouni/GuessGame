package Game;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.concurrent.ThreadLocalRandom;



public class Guess {
	// statische Variablen bzw. gloable Variablen
	static Integer myNumber = ThreadLocalRandom.current().nextInt(0, 100+1);
	static JLabel text = new JLabel("Gebe eine Zahl zwischen 0 und 100 ein!");
	static JTextField textField = new JTextField();
	static Integer tries = 0;
	
	public static void main(String[] args){
		openUI();
	}
	
	public static void openUI() {
		// Defintion der GUI
		JFrame frame = new JFrame("Guess the Number");
		// Fenstergröße
		frame.setSize(400,300);
		// Koordinaten des Fensters
		frame.setLocation(200, 200);
		// Default Aktion beim Schließen des Fensters
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// Default Look des Fensters und Elemente
		JFrame.setDefaultLookAndFeelDecorated(true);
		
		// größe und Koordinaten des Labels
		text.setBounds(50, 50, 300, 30);
		
		// größe und Koordinaten der Textbox
		textField.setBounds(50, 100, 200, 30);
		
		// Der Button bei dem 
		JButton button = new JButton("Guess!");
		button.setBounds(50, 150, 200, 30);
		
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {String textFromTextField = textField.getText();
				Integer number = Integer.parseInt(textFromTextField);
				guess(number);
				} catch (Exception error) {
					text.setText("Bitte gebe eine Zahl ein!!!");
				}
			
				
			}
		});
		// Das Fenster Sichtbar stellen
		frame.setVisible(true);
		// Hinzufügen der Elemente
		frame.add(text);
		// passt die Elemente an
		frame.setLayout(null);
		frame.add(textField);
		frame.add(button);
	}
	
	// Rate Funktion
	public static void guess(Integer number) {
		if(number == myNumber){
			
			text.setText("Richtig geraten :) !"
					+ " Du hast " + tries + " Versuche gebraucht!");
		}
		else{
			// tries zählt die Versuche die du gebraucht hast um die Lösung zu finden
			tries++;
			if(number < myNumber) {
				text.setText("Falsch geraten ! "
						+ "Deine Zahl ist zu klein!");
			}
			else {
				text.setText("Falsch geraten! "
						+ "Deine Zahl ist zu gross!");

			}
			textField.setText("");
		}
	}
}
