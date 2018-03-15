package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.StringTokenizer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {

	@FXML
	private ResourceBundle resources;
	@FXML
	private URL location;
	@FXML
	private TextField txtWord;
	@FXML
	private TextArea txtResult;
	@FXML
	private Button btnTranslate;
	@FXML
	private Button btnReset;


	private AlienDictionary alienDictionary = new AlienDictionary();


	@FXML // This method is called by the FXMLLoader when initialization is complete
	void initialize() {
		assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
		assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
		assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";

	}


	@FXML
	void doTranslate(ActionEvent event) {
		String riga = txtWord.getText().toLowerCase();
		// Controllo sull'input
		if (riga == null || riga.length() == 0) {
			txtResult.setText("Inserire una o due parole.\n");
			return;
		}

		StringTokenizer st = new StringTokenizer(riga, " ");
		String alienWord = st.nextToken();

		if (st.hasMoreTokens()) {
			// Devo inserire parola e traduzione nel dizionario

			// Estraggo la seconda parola
			String translation = st.nextToken();

			if (!alienWord.matches("[a-zA-Z]*") || !translation.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.\n");
				return;
			}

			alienDictionary.addWord(alienWord, translation);

			txtResult.appendText("Parola: " + alienWord + " Traduzione: " + translation + "\n");

		} else {

			// solo una parola, ricerco la traduzione

			if (!alienWord.matches("[a-zA-Z]*")) {
				txtResult.setText("Inserire solo caratteri alfabetici.\n");
				return;
			}

			String translation = alienDictionary.translateWord(alienWord);

			if (translation != null) {
				txtResult.appendText("\nLa traduzione della parola inserita e': "+translation);
			} else {
				txtResult.appendText("\nLa parola cercata non esiste nel dizionario.");
			}
		}

	}


	@FXML
	void doReset(ActionEvent event) {
		txtResult.clear();
		txtWord.clear();
	}

}
