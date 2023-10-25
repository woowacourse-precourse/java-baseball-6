package baseball;

import java.util.List;

public class Counter {
    public static int ballCounter(List<Integer> computer, String user) {

        int count = 0;

        for (int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(user.charAt(i));
            if (computer.contains(number) && number != computer.get(i)) {
                count += 1;
            }
        }

        return count;
    }

    public static int strikeCounter(List<Integer> computer, String user) {
        int count = 0;

        for(int i = 0; i < 3; i++) {
            int number = Character.getNumericValue(user.charAt(i));

            if (computer.get(i) == number) {
                count += 1;
            }
        }

        return count;
    }

}