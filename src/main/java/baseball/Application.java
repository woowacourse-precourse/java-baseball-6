package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Computer computer = new Computer();
            computer.createAnswer();

            String guessData = readLine();
            if (!validateGuess(guessData)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static boolean validateGuess(String guessData) {
        // check guess data length is 3
        if (guessData.length() != 3) {
            return false;
        }

        // check guess data is number
        try {
            Integer.parseInt(guessData);
        } catch (NumberFormatException e) {
            return false;
        }

        // check guess data's number is different for all each number
        if (guessData.charAt(0) == guessData.charAt(1)
                || guessData.charAt(0) == guessData.charAt(2)
                || guessData.charAt(1) == guessData.charAt(2)) {
            return false;
        }

        // check each number is not zero (in range 1 to 9)
        for (int i = 0; i < 3; i++) {
            if (guessData.charAt(i) == '0') {
                return false;
            }
        }

        return true;
    }
}
