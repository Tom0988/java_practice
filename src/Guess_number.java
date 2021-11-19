import java.util.Random;
import java.util.Scanner;

public class Guess_number {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner sc = new Scanner(System.in);
        int secret = random.nextInt(10) + 1;// secret number that player have to guess
        System.out.println(secret);
        int i;// if i = 5 mean player didnt guess right number
        for(i = 0; i<5; i++){
            System.out.print("enter a number: ");
            int guess = sc.nextInt();
            if (secret > guess) System.out.println("bigger");
            else if (secret < guess) System.out.println("smaller");
            else {
                System.out.println("bingo!");
                break;
            }
        }
        if (i == 5) System.out.println("you have guess more than 5 times..");
    }
}
