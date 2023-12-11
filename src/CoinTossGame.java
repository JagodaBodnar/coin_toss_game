import java.util.Scanner;

public class CoinTossGame {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        CoinTossGame  game = new CoinTossGame();
        String name = game.askPlayersName();
        Player player1 = new Player(name);
        Player player2 = new Player("Computer");
        game.printMessageForUser();
        String usersGuess = game.getValueFromUser();
        game.assignValues(usersGuess, player1, player2);
        game.createNewGame(player1, player2);
    }
    public String askPlayersName(){
        System.out.println("Enter your name:");
        return scanner.next();
    }

    public void printMessageForUser() {
        System.out.println("Please choose HEADS or TAILS");
    }
    public String getValueFromUser(){
        String usersGuess = null;
        do {
            if (usersGuess != null){
                System.out.println("You have entered wrong value. Please try again.");
            }
            usersGuess = scanner.next();
        } while (!usersGuess.equalsIgnoreCase("HEADS") && !usersGuess.equalsIgnoreCase("TAILS") );
        return usersGuess;
    }
    public void assignValues(String usersGuess, Player player1, Player player2){
        player1.setGuess(usersGuess);
        if (usersGuess.equalsIgnoreCase("HEADS")) {
            player2.setGuess("TAILS");
        } else {
            player2.setGuess("HEADS");
        }
    }
    public void createNewGame(Player player1, Player player2){
        Coin game = new Coin();
        game.flip();
        System.out.printf("Coin landed on: %s%n", game.getSide());
        if (game.getSide().equalsIgnoreCase(player1.getGuess())) {
            System.out.printf("%s is the winner", player1.getName());
        } else {
            System.out.printf("%s is the winner", player2.getName());
        }
    }
}
