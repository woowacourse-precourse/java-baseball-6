package baseball;

import camp.nextstep.edu.missionutils.Randoms;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Game {
    private static final int rangeStart = 1;
    private static final int rangeEnd = 9;
    private static final int numberCount = 3;
    private static final int restartGame = 1;
    private static final int finishGame = 2;

    private static final String startMsg = "숫자 야구 게임을 시작합니다.";
    private static final String inputMsg = "숫자를 입력해주세요 : ";
    private static final String endMsg = Game.numberCount + "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String continueMsg = "게임을 새로 시작하려면 " + Game.restartGame + ", 종료하려면 " + Game.finishGame + "를 입력하세요.";

    List<Integer> answer = new ArrayList<>();

    public void mainLogic() {
        while (true) {
            generateAnswerNumber();
            System.out.println(startMsg);

            while (true) {
                List<Integer> userInputArray = generateUserInputArray(getUserInput());

                int strike = generateStrike(userInputArray);
                int ball = updateBall(strike, generateBallNothing(userInputArray));

                printResult(strike, ball);
                if (strike == Game.numberCount) {
                    System.out.println(endMsg);
                    break;
                }
            }
            if (getContinueMsg() == finishGame) {
                break;
            }
        }
    }

    private int updateBall(int strike, int ball) {
        if (ball - strike > 0) {
            ball -= strike;
        } else {
            ball = 0;
        }
        return ball;
    }

    private String getUserInput() {
        System.out.print(inputMsg);
        String userInput = readLine();

        checkUserInputAsInt(userInput);
        checkUserInputAsLength(userInput);

        return userInput;
    }

    private int getContinueMsg() {
        System.out.println(continueMsg);
        String userInput = readLine();

        checkUserInputAsInt(userInput);
        checkContinueMsgAsValue(userInput);

        return Integer.parseInt(userInput);
    }

    private void printResult(int strike, int ball) {
        if (ball == 0 && strike == 0) {
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.println(ball + "볼");
        } else if (ball == 0) {
            System.out.println(strike + "스트라이크");
        } else {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
    }

    private void generateAnswerNumber() {
        answer.clear();
        while (answer.size() < Game.numberCount) {
            int randomNumber = Randoms.pickNumberInRange(rangeStart, rangeEnd);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }
    }

    private List<Integer> generateUserInputArray(String input) {
        List<Integer> userInputArray = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            int digit = Integer.parseInt(String.valueOf(input.charAt(i)));
            userInputArray.add(digit);
        }
        return userInputArray;
    }

    public static void checkUserInputAsInt(String input) {
        if (input.isEmpty() || !input.matches("\\d+")) {
            throw new IllegalArgumentException("숫자를 입력하십시오.");
        }
    }

    public static void checkUserInputAsLength(String input) {
        if (input.length() != Game.numberCount) {
            throw new IllegalArgumentException(numberCount + "자리의 수를 입력해주세요.");
        }
    }

    public static void checkContinueMsgAsValue(String input) {
        if (Integer.parseInt(input) != Game.restartGame && Integer.parseInt(input) != Game.finishGame) {
            throw new IllegalArgumentException("잘못된 수를 입력하셨습니다.");
        }
    }

    private int generateStrike(List<Integer> input) {
        int strike = 0;
        for (int i = 0; i < Game.numberCount; i++) {
            if (input.get(i).equals(answer.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int generateBallNothing(List<Integer> input) {
        List<Integer> distinctInput = new ArrayList<>(new LinkedHashSet<>(input));

        int count = 0;
        for (Integer element : distinctInput) {
            if (answer.contains(element)) {
                count++;
            }
        }
        return count;
    }
}
