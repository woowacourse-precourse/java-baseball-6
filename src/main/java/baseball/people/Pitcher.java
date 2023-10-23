package baseball.people;

public class Pitcher {

    Pitcher() {
    }

    public static Pitcher enter() {
        return new Pitcher();
    }

    public int[] pitch(String input) {
        if (!isValidInput(input)) {
            throw new IllegalArgumentException();
        }

        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = (input.charAt(i) - '0');
        }
        return numbers;
    }

    public boolean restart(String input) {
        if (input.equals("1")) {
            return true;
        }
        if (input.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean isValidInput(String input) {
        if (input.length() != 3) {
            return false;
        }

        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            char c = input.charAt(i);
            if (c < '1' || c > '9' || duplicationCheck[(c - '0')]) {
                return false;
            }
            duplicationCheck[(c - '0')] = true;
        }

        return true;
    }
}
