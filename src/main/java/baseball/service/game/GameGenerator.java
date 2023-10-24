package baseball.service.game;

import baseball.domain.answer.Answer;
import baseball.domain.number.Number;
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GameGenerator {

    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static void baseBallGame(Answer answer) {
        String result = "";
        while (!result.equals(3 + STRIKE)) {
            Number inputNumber = new Number(Console.readLine());
            System.out.println(answer.toIntList());
            result = GameGenerator.compare(inputNumber.toIntList(), answer.toIntList());
            System.out.println(result);
        }
    }

    public static String compare(List<Integer> number1, List<Integer> number2) {
        String ballResult = ball(number1, number2);
        String strikeResult = strike(number1, number2);
        String nothingResult = nothing(number1, number2);

        return Stream.of(ballResult, strikeResult, nothingResult)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.joining(" "));
    }

    private static String strike(List<Integer> number1, List<Integer> number2) {
        long count = 0L;
        // 같은 인덱스에 같은 값
        count = IntStream.range(0, number1.size())
                .filter(n -> number1.get(n).equals(number2.get(n)))
                .count();

        return count == 0 ? "" : count + STRIKE;
    }

    private static String ball(List<Integer> number1, List<Integer> number2) {
        long count = 0L;
        // 인덱스가 같지않고 같은 요소가 들어있는

        for (int i = 0; i < number1.size(); i++) {
            if (!number2.get(i).equals(number1.get(i)) && number2.contains(number1.get(i))) {
                ++count;
            }
        }

        return count == 0 ? "" : count + BALL;
    }

    private static String nothing(List<Integer> number1, List<Integer> number2) {
        // 아에 같은 요소를 갖고있지 않은 경우
        return (number1.stream().noneMatch(number2::contains)) ? NOTHING : "";
    }

    public static String gameStartLog() {
        return "숫자 야구 게임을 시작합니다.\n" + "숫자를 입력해주세요. : ";
    }

    public static String gameEndLog() {
        return "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    }
}
