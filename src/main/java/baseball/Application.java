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
        printMessage(Message.START_MESSAGE);
        do {
            List<Integer> pickedIntegers = new ArrayList<>();
            while (pickedIntegers.size() < 3) {
                int pickedInteger = Randoms.pickNumberInRange(1, 9);
                if (!pickedIntegers.contains(pickedInteger)) {
                    pickedIntegers.add(pickedInteger);
                }
            }

            int strikeCount = 0;
            int ballCount;
            while (strikeCount < 3) {
                printMessage(Message.INPUT_NUMBER_PROMPT);
                String inputValue = Console.readLine();

                strikeCount = 0;
                ballCount = 0;

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
        Console.close();
    }

    private static void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    private static void printScoreBoardMessage(int strikeCount, int ballCount) {
        if (strikeCount + ballCount == 0) {
            System.out.println(Message.NOTHING.getMessage());
            return;
        }

        String ballMessage = (ballCount != 0) ? ballCount + Message.BALL.getMessage() : "";
        String strikeMessage = (strikeCount != 0) ? strikeCount + Message.STRIKE.getMessage() : "";

        System.out.println((ballMessage + " " + strikeMessage).trim());

    }

    private static void printIfStrikeOut(int strikeCount) {
        if (strikeCount == 3) {
            System.out.println(Message.END_MESSAGE.getMessage());
        }
    }

    private static void askIfContinue() {
        System.out.println(Message.GAME_END_PROMPT.getMessage());

        isGameToBeContinued = !Console.readLine().equals(GameOverSignal.FINISH.getNumber());
    }
}
