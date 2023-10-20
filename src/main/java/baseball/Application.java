package baseball;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (true) {
            Computer computer = new Computer();
            computer.createAnswer();

            while (true) {
                System.out.print("숫자를 입력해주세요 : ");
                String guessData = readLine();
                if (!validateGuess(guessData)) {
                    throw new IllegalArgumentException();
                }

                List<Integer> guess = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    guess.add(Integer.parseInt(guessData.substring(i, i+1)));
                }

                List<Integer> result = computer.getResultOfGuess(guess);
                if (result.get(0) == 0) {
                    if (result.get(1) == 0) {
                        System.out.println("낫싱");
                    } else {
                        System.out.printf("%d볼\n", result.get(1));
                    }
                } else {
                    if (result.get(1) == 0) {
                        System.out.printf("%d스트라이크\n", result.get(0));
                    } else {
                        System.out.printf("%d볼 %d스트라이크\n", result.get(1), result.get(0));
                    }
                }

                if (result.get(0) == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
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
