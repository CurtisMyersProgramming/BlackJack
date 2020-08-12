import java.util.ArrayList;
import java.util.Random;

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

    public void removeCard(int i){
        this.Deck.remove(i);

    } // remove card from the arraylist

    public void shuffle(){
        ArrayList<Card> tmpDeck = new ArrayList<Card>(); // create new empty deck
        Random r = new Random(); // new random
       int rindex = 0;
       int ogsize = this.Deck.size();

       for( int i = 0; i < ogsize; i++){ // loop which gets card from origional deck at random int and adds them to new deck removing from old
            rindex = r.nextInt((this.Deck.size()-1 -0) + 1) +0;
            tmpDeck.add(Deck.get(rindex));
            this.Deck.remove(rindex);

       }
       this.Deck = tmpDeck; // deck now equals new in random order

    } // shuffle deck

    public Card getCard(int i){
        return this.Deck.get(i); //get card at index
    }

    public void draw(Deck x ){ // draw from deck(playing deck that neither user is using as is only there to deal cards)
        this.Deck.add(x.getCard(0)); // get card from top of deck
        x.removeCard(0); // remove card from deck
    }

    public String toString(){
        String cardoutout ="";
        int i = 0;
        for(Card x : this.Deck){ // iterate through deck
            cardoutout +=  "\n"+ i + " - " +Deck.get(i).toString(); // string concatination of index of card placement and value
            i++; //iterate over value

        }
        return cardoutout; // return results as a whole;
    }
}
