package logic;

public class CardCounter {
	
	//Fields
	private UnitCard card;
	private int count;
	
	//Constructors
	public CardCounter(UnitCard card, int count) {
		setCard(card);
		setCount(count);
	}
	
	//Methods
	public void setCount(int count) {
		this.count = count < 0 ? 0 : count;
	}
	
	public String toString() {
		return  this.getCard() + " x " + this.getCount();
	}
	
	public void setCard(UnitCard card) {
		this.card = card;
	}
	
	public UnitCard getCard() {
		return card;
	}
	
	public int getCount() {
		return count;
	}
}