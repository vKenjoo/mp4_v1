import java.util.Random;

public class computerGuess {

    public static int[] comGuess() {
        Random random = new Random();
        int integer = random.nextInt(9000) + 1000; // Generate a random integer between 1000 and 9999
        int[] digits = new int[4];
        for (int i = 0; i < 4; i++) {
            digits[i] = integer % 10;
            integer /= 10;
        }
        return digits;
    }

    public static void printGuess() {
        int[] digits = comGuess();
        for (int digit : digits) {
            System.out.print(digit);
        }
    }
}
