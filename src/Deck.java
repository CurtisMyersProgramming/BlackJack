import java.util.ArrayList;

public class Deck {
    //Arraylist top hold the card objects to form a deck
    private ArrayList<Card> Deck;

    public Deck() {
        this.Deck = new ArrayList<>();
    }

    public void createFullDeck(){
        for(Suits cardSuit : Suits.values()){ // iterate over each suit
            for(Values value : Values.values()){ // iterate over each value for each suit
                Deck.add(new Card(cardSuit,value)); // add to arraylist new card of iterations
            }

        }
    } //method to create full deck of cards
}
