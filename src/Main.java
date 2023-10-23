import java.util.Random;
import java.util.Scanner;
public class Main {

    public static Scanner testScan = new Scanner (System.in);
    public static void main(String[] args) {
        Random = new Random();
        boolean continuePlaying = true;

        while (continuePlaying) {
            int point = 0;
            int sum = rollDice(Random);

            if (sum ==2 || sum == 3 || sum == 12) {
                System.out.println("You rolled" + sum + " - Craps! You lose.");
            } else if (sum == 7 || sum == 11) {
                System.out.println("You rolled" + sum + " - Natural! You win.");
            } else {
                point = sum;
                System.out.println("Point is set to " + point);
                boolean continueRolling = true;

                while (continueRolling) {
                    int newSum = rollDice(Random);
                    System.out.println("You rolled" + newSum);

                    if (newSum == point) {
                        System.out.println("Made point and won!");
                        continueRolling = false;
                    } else if (newSum == 7) {
                        System.out.println("You rolled a 7 - You lose.");
                        continueRolling = false;
                    }
                }
            }

            System.out.println("Play again? (yes/no): ");
            String playAgain = Scanner.next().toLowerCase();
            if (!playAgain.equals("yes")) {
                continuePlaying = false;
            }
        }
        System.out.println("Thanks for playing!");
    }

    public static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Rolling dice: " + die1 + " + " + die2 + " = " + sum);
        return sum;
    }
}