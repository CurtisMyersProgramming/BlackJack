import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Deck user = new Deck(); // players deck/hand
        Deck dealer = new Deck(); // dealers deck/hand

        Deck playing = new Deck(); // deck that player and dealer draw from
        playing.createFullDeck();
        playing.shuffle();
        Scanner scanner =  new Scanner(System.in);

        System.out.println("WELCOME TO BLACKJACK");
        System.out.print("Please enter the balance you would like to start with: ");
        String useramount = scanner.nextLine();
        Double startingBalance = Double.valueOf(useramount);
        System.out.println("\nStarting Balance = " + startingBalance);

        Double currentBalance = startingBalance;
        rules();

        while(currentBalance > 0){
            playing.createFullDeck();
            playing.shuffle();

            int turncount = 0;
            System.out.println("Balance: " + currentBalance);
            System.out.print("enter your stake: ");
            double stake = Double.valueOf(scanner.nextLine());
            currentBalance = currentBalance - stake;
            System.out.println("Balance: " + currentBalance);
            System.out.println("Stake: "+ stake);
            System.out.println("");
            boolean endround = false;

            dealer.draw(playing);
            dealer.draw(playing);
            user.draw(playing);
            user.draw(playing);


            while(true){

                System.out.println("-YOUR HAND-");
                System.out.println(user);
                System.out.println("your hand value " + user.cardsValue());
                System.out.println("");

                System.out.println("Dealers hand");

                System.out.println(dealer.getCard(0) + (" + hidden"));
                System.out.println("");

                System.out.println("what option would you like to take");
                System.out.println("[x] - hit");
                System.out.println("[s] - stand");
                if(turncount < 1){
                    System.out.println("[D] - DOUBLE DOWN");
                }
                System.out.println("Selection: ");

                String choice = scanner.nextLine();

                if(choice.equals("x")){

                    user.draw(playing);
                    System.out.println("");
                    if(user.cardsValue() > 21){
                        System.out.println("YOU BUST");
                        endround = true;
                        break;
                    }


                }

                if(choice.equals("s")){
                        break;
                }

            }
            System.out.println("dealer total: " + dealer.cardsValue());


            while((dealer.cardsValue() < 17) && endround == false) {
                dealer.draw(playing);
                System.out.println("drawing");
                System.out.println("dealer total: " + dealer.cardsValue());
            }

                if(dealer.cardsValue() >= 17 && dealer.cardsValue() <= 21 && dealer.cardsValue() > user.cardsValue() && endround == false) {
                    System.out.println("DEALER WINS!");
                    System.out.println(dealer);
                    System.out.println("dealer total: " + dealer.cardsValue());
                    endround = true;




                }
                if((dealer.cardsValue() > 21) && endround == false){
                    System.out.println("YOU WIN");
                    currentBalance = stake*2+currentBalance;
                    endround = true;




            }

                if((user.cardsValue() > dealer.cardsValue())&& endround == false){
                    System.out.println("YOU WIN");
                    currentBalance = stake*2+currentBalance;
                    endround = true;
                }

                if(dealer.cardsValue() == user.cardsValue() && endround ==false){
                    System.out.println("PUSH");
                    currentBalance = stake+currentBalance;
                    endround = true;
                }

                user.moveallltodeck(playing);
                dealer.moveallltodeck(playing);
                user.restore();
                dealer.restore();
            }
        System.out.println("");
        System.out.println("you lost all your money you bum bitch");

        }







        public static void rules() {
        System.out.println("\n-Rules of the game- ");
        System.out.println("");
        System.out.println("-Place your stake and wait for the cards to be draw");
        System.out.println("-you will get the option to hit, stand or double down(on inital hand only");
        System.out.println("-Dealer will draw until they hit 17, if they go over 21 the dealer will bust and you will win aslong as you dont have a total over 21");
        System.out.println("");
    }

}
