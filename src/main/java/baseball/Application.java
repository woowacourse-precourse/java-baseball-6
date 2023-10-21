package baseball;

import baseball.enums.GameOverSignal;
import baseball.enums.Message;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static boolean isGameToBeContinued = true;

    public static void main(String[] args) {
        playGame();
    }

    private static void playGame() {
        printMessage(Message.START_MESSAGE);
        do {
            List<Integer> pickedIntegers = getRandomIntegers();

            int strikeCount = 0;
            int ballCount;
            while (strikeCount < 3) {
                printMessage(Message.INPUT_NUMBER_PROMPT);
                String inputValue = Console.readLine();

                validateInput(inputValue);

                strikeCount = 0;
                ballCount = 0;
        Console.close();

                for (int i = 0; i < inputValue.length(); i++) {
                    for (int j = 0; j < pickedIntegers.size(); j++) {
                        if (inputValue.charAt(i) == pickedIntegers.get(j).toString().charAt(0) && i == j) {
                            strikeCount++;
                            break;
                        }

                        if (inputValue.charAt(i) == pickedIntegers.get(j).toString().charAt(0)) {
                            ballCount++;
                        }
                    }
                }
                printScoreBoardMessage(strikeCount, ballCount);
                printIfStrikeOut(strikeCount);
            }
            askIfContinue();
        } while (isGameToBeContinued);
    }

    private static void validateInput(String inputValue) {
        if (!inputValue.matches("^[0-9]{3}$")) {
            throw new IllegalArgumentException("숫자 세 자리만 입력해주세요.");
        }
    }

    private static List<Integer> getRandomIntegers() {
        List<Integer> pickedIntegers = new ArrayList<>();
        while (pickedIntegers.size() < 3) {
            int pickedInteger = Randoms.pickNumberInRange(1, 9);
            if (!pickedIntegers.contains(pickedInteger)) {
                pickedIntegers.add(pickedInteger);
            }
        }

        return pickedIntegers;
    }

    private static void printScoreBoardMessage(int strikeCount, int ballCount) {
        if (strikeCount + ballCount == 0) {
            printMessage(Message.NOTHING);
            return;
        }

        String ballMessage = (ballCount != 0) ? ballCount + Message.BALL.getMessage() : "";
        String strikeMessage = (strikeCount != 0) ? strikeCount + Message.STRIKE.getMessage() : "";

        System.out.println((ballMessage + " " + strikeMessage).trim());
    }

    private static void printIfStrikeOut(int strikeCount) {
        if (strikeCount == 3) {
            printMessage(Message.END_MESSAGE);
        }
    }

    private static void askIfContinue() {
        printMessage(Message.GAME_END_PROMPT);

        isGameToBeContinued = !Console.readLine().equals(GameOverSignal.FINISH.getNumber());
    }

    private static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }
}
