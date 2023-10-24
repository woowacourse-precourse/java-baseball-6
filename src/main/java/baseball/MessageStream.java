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
        printBallStrikeMessage(ball, strike);
        if (strike == 3) {
            printEndMessage();
        }
    }

    private static void printBallStrikeMessage(int ball, int strike) {
        String nothingMessage = "낫싱", ballMessage = "볼", strikeMessage = "스트라이크";
        if (ball > 0 && strike > 0) {
            System.out.print(ball + ballMessage + " " + strike + strikeMessage + "\n");
        } else if (ball > 0) {
            System.out.print(ball + ballMessage + "\n");
        } else if (strike > 0) {
            System.out.print(strike + strikeMessage + "\n");
        } else {
            System.out.print(nothingMessage + "\n");
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

    public static List<Integer> predictionInput() {
        return convertThreeNumericStringToIntegerList(readLine());
    }

    public static List<Integer> convertThreeNumericStringToIntegerList(String str) {
        validateThreeNumericString(str);
        return IntStream.range(0, str.length())
                .map(i -> Integer.parseInt(str.substring(i, i + 1)))
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateThreeNumericString(String str) {
        if (!str.matches("[1-9]{3}")) {
            throw new IllegalArgumentException();
        }
        if (str.chars().distinct().count() != str.length()) {
            throw new IllegalArgumentException();
        }
    }

    public static String restartInput() {
        String str = readLine();
        validateRestartNumericString(str);
        return str;
    }

    private static void validateRestartNumericString(String str) {
        if (!str.equals("1") && !str.equals("2")) {
            throw new IllegalArgumentException();
        }
    }
}
