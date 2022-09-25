import java.util.Scanner;

public class BlackJack {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("\nWelcome to Java Casino!");
        System.out.println("Do you have a knack for Black Jack?");
        System.out.println("We shall see..");
        System.out.println("..Ready? Press anything to begin!");
        scan.nextLine();


        int value1 = drawRandomCard();
        int value2 = drawRandomCard();

        System.out.println("\n You get a \n" + cardString(value1) + "\n and a \n" + cardString(value2));
        int userTotal = Math.min(value1,10) + Math.min(value2,10);
        System.out.println("Your total is: " + userTotal);

        int dealerFirstCard = drawRandomCard();
        int dealerSecondCard = drawRandomCard();

        System.out.println("The dealer shows: \n" + cardString(dealerFirstCard)
                + "\nand has a card facing down: \n" + faceDown());
        int dealersTotal =  Math.min(dealerFirstCard,10) + Math.min(dealerSecondCard,10);
        System.out.println("The dealer's total is hidden");

        while(true){
            String usersTurn = hitOrStay();

            if(usersTurn.equals("stay")){
                break;

            }

            if(usersTurn.equals("hit")){
                int newCard = drawRandomCard();
                userTotal += Math.min(newCard,10);
                System.out.println("\nYou get a: \n" + newCard + cardString(newCard));
                System.out.println("Your new total is: " + userTotal);

                if(userTotal > 21) {
                    System.out.println("Bust! player loses.");
                    System.exit(0);
                }
            }
        }

        System.out.println("\nDealer's turn" +
                "\nThe dealer's cards are \n" + cardString(dealerFirstCard)
                + "\n and a \n" + cardString(dealerSecondCard));
        System.out.println("\nDealer's total is " + dealersTotal);

        while(dealersTotal < 17) {
            int value = drawRandomCard();

            dealersTotal += Math.min(value,10);
            System.out.println("\nDealer gets a\n" + cardString(value));
            System.out.println("\nDealer's total is " + dealersTotal);
        }

        if(dealersTotal > 21){
            System.out.println("Bust! Dealer loses.");
            System.exit(0);
        }


        if(userTotal > dealersTotal){
            System.out.println("Player wins!");
        }else{
            System.out.println("Dealer wins!");
        }
        scan.close();
    }

    public static int drawRandomCard() {
        double randomNumber = Math.random() * 13;
        randomNumber += 1;
        return (int) randomNumber;
    }

    public static String cardString(int cardNumber) {
        switch (cardNumber) {
            case 1:
                return "   _____\n" +
                        "  |A _  |\n" +
                        "  | ( ) |\n" +
                        "  |(_'_)|\n" +
                        "  |  |  |\n" +
                        "  |____V|\n";

            case 2:
                return "   _____\n" +
                        "  |2    |\n" +
                        "  |  o  |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____Z|\n";

            case 3:
                return "   _____\n" +
                        "  |3    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  |  o  |\n" +
                        "  |____E|\n";

            case 4:
                return "   _____\n" +
                        "  |4    |\n" +
                        "  | o o |\n" +
                        "  |     |\n" +
                        "  | o o |\n" +
                        "  |____h|\n";

            case 5:
                return "   _____ \n" +
                        "  |5    |\n" +
                        "  | o o |\n" +
                        "  |  o  |\n" +
                        "  | o o |\n" +
                        "  |____S|\n";

            case 6:
                return "   _____ \n" +
                        "  |6    |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  | o o |\n" +
                        "  |____6|\n";

            case 7:
                return "   _____ \n" +
                        "  |7    |\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |____7|\n";

            case 8:
                return "   _____ \n" +
                        "  |8    |\n" +
                        "  |o o o|\n" +
                        "  | o o |\n" +
                        "  |o o o|\n" +
                        "  |____8|\n";

            case 9:
                return "   _____ \n" +
                        "  |9    |\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |____9|\n";

            case 10:
                return "   _____ \n" +
                        "  |10  o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |o o o|\n" +
                        "  |___10|\n";

            case 11:
                return "   _____\n" +
                        "  |J  ww|\n" +
                        "  | o {)|\n" +
                        "  |o o% |\n" +
                        "  | | % |\n" +
                        "  |__%%[|\n";

            case 12:
                return "   _____\n" +
                        "  |Q  ww|\n" +
                        "  | o {(|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%O|\n";
            case 13:
                return "   _____\n" +
                        "  |K  WW|\n" +
                        "  | o {)|\n" +
                        "  |o o%%|\n" +
                        "  | |%%%|\n" +
                        "  |_%%%>|\n";

            default: return "not possible";
        }
    }


    public static String faceDown() {
        return
                "   _____\n" +
                        "  |     |\n" +
                        "  |  J  |\n" +
                        "  | JJJ |\n" +
                        "  |  J  |\n" +
                        "  |_____|\n";
    }

    public static String hitOrStay() {
        System.out.println("Do you want to hit or stay?");
        String usersChoice = scan.nextLine();

        while(true){
            if(usersChoice.equalsIgnoreCase("hit") || usersChoice.equalsIgnoreCase("stay")){
                return usersChoice;
            }else{
                System.out.println("Please write 'hit' or 'stay'");
                usersChoice = scan.nextLine();
            }
        }
    }
}