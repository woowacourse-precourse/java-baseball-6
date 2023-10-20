package baseball;

import java.util.Random;

public class ComputerPlayer {
    public static int[] generateRandomNumber() {
        Random random = new Random();
        int[] number = new int[3];
        boolean[] used = new boolean[10];

        for (int i = 0; i < 3; i++) {
            int digit;
            do {
                digit = random.nextInt(10);
            } while (used[digit]);
            number[i] = digit;
            used[digit] = true;
        }

        return number;
    }
}
