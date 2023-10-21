package baseball;

public class Checker {
    public static Boolean isCorrectInput(String input) {
        Integer length = input.length();
        Boolean[] isUsed = new Boolean[10];

        if (length != 3) {
            return false;
        }

        for (int i = 1; i <= 9; i++) {
            isUsed[i] = false;
        }

        for (Integer i = 0; i < length; i++) {
            Character presentDigit = input.charAt(i);

            if ('0' <= presentDigit && presentDigit <= '9') {
                Integer number = presentDigit.charValue() - '0';

                if (!isUsed[number]) {
                    isUsed[number] = true;
                    continue;
                }
            }

            return false;
        }

        return true;
    }

    public static Integer numberOfBalls(String input, String randomNumber) {
        Integer length = input.length();
        Integer result = 0;

        for (Integer i = 0; i < length; i++) {
            Character presentDigit = input.charAt(i);

            for (Integer j = 0; j < length; j++) {
                if (i.equals(j)) {
                    continue;
                }

                Character computerDigit = randomNumber.charAt(j);

                if (presentDigit.equals(computerDigit)) {
                    result++;
                }
            }
        }

        return result;
    }

    public static Integer numberOfStrikes(String input, String randomNumber) {
        Integer length = input.length();
        Integer result = 0;

        for (Integer i = 0; i < length; i++) {
            Character presentDigit = input.charAt(i);
            Character computerDigit = randomNumber.charAt(i);

            if (presentDigit.equals(computerDigit)) {
                result++;
            }
        }

        return result;
    }
}
