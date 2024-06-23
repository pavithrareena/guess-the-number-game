import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int number = random.nextInt(101);

        int rounds = 0;
        int attempts = 10;
        int score = 0;
        System.out.println("++++++++++++++++++++++++++++");
        System.out.println("[--Welcome to Number Game--]");
        System.out.println("++++++++++++++++++++++++++++");
        boolean play = true;
        while (play != false) {
            rounds++;

            while (attempts != 0) {
                System.out.print("Enter your guess b/w 1 to 100: ");
                int userNum = sc.nextInt();
                if (userNum < 0 || userNum > 100) {
                    System.out.println("number out of range!");
                    System.out.println("====================");
                    continue;
                }

                if (number == userNum) {
                    System.out.println("===============================");
                    System.out.println("Great you Guessed right number!");
                    if (attempts == 10) {
                        score += 10;
                    } else if (attempts >= 5) {
                        score += 5;
                    } else {
                        score += 2;
                    }
                    break;
                } else if (userNum < number) {
                    System.out.println("======================");
                    System.out.println("Enter a Higher number");
                    attempts--;
                } else if (userNum > number) {
                    System.out.println("=====================");
                    System.out.println("Enter a Lower number");
                    attempts--;
                }

                if (attempts == 0) {
                    System.out.println("====================================================");
                    System.out.println("No attempts left!, the number to be guessed is " + number);
                    System.out.println("====================================================");
                }
            }
            System.out.println("===============================");
            System.out.print("want to try again?(1[yes]|0[no]): ");
            int wantsToPlay = sc.nextInt();
            if (wantsToPlay != 1) {
                System.out.println("====================================================");
                System.out.println("you have played " + rounds + " round, your score is " + score);
                System.out.println("====================================================");

                play = false;
            }
        }
        sc.close();
    }

}
