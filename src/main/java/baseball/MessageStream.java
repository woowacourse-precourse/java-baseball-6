package baseball;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class MessageStream {
    public static void printStartMessage() {
        String startMessage = "숫자 야구 게임을 시작합니다.\n";
        System.out.print(startMessage);
    }

    public static void printInputMessage() {
        String inputMessage = "숫자를 입력해주세요 : ";
        System.out.print(inputMessage);
    }

    public static void printResultMessage(int ball, int strike) {
        String ballMessage = "볼", strikeMessage = "스트라이크", finalMessage = "";
        if (ball > 0) {
            finalMessage = ball + ballMessage;
        }
        if (strike > 0) {
            finalMessage = strike + strikeMessage;
        }
        System.out.print(finalMessage + "\n");
        if (strike == 3) {
            printEndMessage();
        }
    }

    public static void printEndMessage() {
        String endMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n";
        System.out.print(endMessage);
    }

    public static void restartMessage() {
        String restartMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n";
        System.out.print(restartMessage);
    }

    public static String input() {
        return readLine();
    }

    public static List<Integer> predictionInput() {
        return convertThreeNumericStringToIntegerList(readLine());
    }

    public static List<Integer> convertThreeNumericStringToIntegerList(String str) {
        return IntStream.range(0, str.length())
                .map(i -> Integer.parseInt(str.substring(i, i + 1)))
                .boxed()
                .collect(Collectors.toList());
    }
}
