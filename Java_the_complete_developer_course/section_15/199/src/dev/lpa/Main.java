package dev.lpa;


import java.util.List;

public class Main {

    public static void main(String[] args) {
    	
    	Card2.PrintMola("Kepa");
    	List<Card> deck = Card.getStandardDeck();
        Card.printDeck(deck);
        Card2.PrintMola("KepaJamecho");
        Card.getStandardDeck();
        Card2.PrintMola("KepaJamecho2");

    }
}
