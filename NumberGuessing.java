import java.util.Random;
import java.util.Scanner;

class NumberGuessing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int attempt = 15;
        int i = 1;
        int round = 1;
        float score;
        float totalscore = 0;
        while (round <= 3) {
             System.out.print("\n");
            System.out.println("+++++++Welcome to Round " + (round)+"+++++++");
            Random r = new Random();
            int randomNumber = r.nextInt(100) + 1;
            while (i <= attempt) {
                System.out.print("\nEnter your Guess Number Between(1-100): ");
                int playerguess = scanner.nextInt();

                if (playerguess == randomNumber) {
                    System.out.println("\nCorrect Guess");
                    System.out.println("\nNo of Attempt Taken for guessing Number: " + i);
                    score = ((attempt - i) * 100) / attempt;
                    totalscore += score;
                    System.out.println("\nYou have got score: " + score);
                    break;
                } else if (playerguess > 100) {
                    System.out.println("\nOut of range");
                   
                } else if (randomNumber > playerguess) {
                    System.out.println("Guessing number is higher,Please try again");
                    i++;
                }

                else {
                    System.out.println("Guessing number is lower,Please try again");
                    i++;
                }
            }

            round += 1;
            i--;
            if (i == attempt) {
                score = 0;
                totalscore += score;
                System.out.println("\nYour are take all attempt for this round the game is over");

                break;
            }

            i = 1;
            attempt -= 5;
        }
        System.out.println("\nTotal Score:" + totalscore);

    }
}
