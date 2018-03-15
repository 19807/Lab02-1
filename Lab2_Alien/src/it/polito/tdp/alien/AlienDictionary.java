package it.polito.tdp.alien;

import java.util.ArrayList;
import java.util.List;


public class AlienDictionary { 

	private List<Word> dictionary;

	public AlienDictionary() {
		dictionary = new ArrayList<Word>();
	}

	public void addWord(String alien, String trans) {
		// Controllo se la parola è già stata inserita nel dizionario
		for (Word w : dictionary) {
			if(w.toString().equals(alien)) { // Aggiorno la traduzione
				w.setTranslation(trans);
				return;
			}
		}
		Word w = new Word(alien, trans);
		dictionary.add(w);
	}

	public String translateWord(String alien) {
		for (Word w : dictionary) {
			if(w.getAlienWord().equals(alien)) {
				//if(w.compare(alien)){
				return w.getTranslation();
			}
		}
		return null;
	}

}
