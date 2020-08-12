public class Card {

    // values that a card will hold
    private Suits suit;
    private Values value;
    //constructor of card
    public Card(Suits suit, Values value) {
        this.suit = suit;
        this.value = value;
    }

    public Values getValue() {
        return value;
    }

    public String toString(){
        return this.value + " " +this.suit;
    }
}
