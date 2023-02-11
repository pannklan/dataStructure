package logic;

import java.util.ArrayList;

public class UnitDeck {
	//Fields
    private ArrayList<CardCounter> cardsInDeck;
    private String deckName;

    //Constructors
    public UnitDeck(String deckName) {
    	setCardsInDeck(new ArrayList<CardCounter>(0));
        setDeckName(deckName);
    }

    //Methods
    public void addCard(UnitCard newCard, int count) {
    	if (count<=0){
    		return;
    	}
    	for (CardCounter c: cardsInDeck) {
    		if (c.getCard().equals(newCard)) {
                c.setCount(c.getCount() + count);
                return;
    		}
    	}
    	this.cardsInDeck.add(new CardCounter(newCard, count));
    }
   
    public void removeCard(UnitCard toRemove, int count) {
    	if (count<=0){
    		return;
    	}
    	for (CardCounter c : cardsInDeck) {
    		if (c.getCard().equals(toRemove)) {
                if (count >= c.getCount()) {
                    cardsInDeck.remove(c);
                } else {
                    c.setCount(c.getCount() - count);
                }
                return;
            }
    	}
    }

    public int cardCount() {
        int count = 0;
        for (CardCounter counter : cardsInDeck){
            count += counter.getCount();
        }
        return count;
    }

    
    public boolean existsInDeck(UnitCard card) {
    	for (CardCounter c : cardsInDeck) {
            if (c.getCard().equals(card)) {
                return true;
            }
    	}
    	return false;
    }
    
    public boolean equals(UnitDeck other) {
        return deckName.equals(other.getDeckName());
    }

    public void setCardsInDeck(ArrayList<CardCounter> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public void setDeckName(String deckName) {
        this.deckName = deckName.isBlank() ? "Untitled Deck" : deckName;
    }

    public ArrayList<CardCounter> getCardsInDeck() {
        return cardsInDeck;
    }
    
    public String getDeckName() {
        return deckName;
    }
}