package baseball;

import java.util.Set;
import java.util.stream.Collectors;

public class NumberBaseball {

  public static String baseballGame(String input, String answer) {
    Set<Character> answerSet = createAnswerSet(answer);
    int strike = countStrike(input, answer);
    int ball = countBall(input, answerSet, strike);

    return generateResultMessage(strike, ball);
  }

  private static int countStrike(String input, String answer) {
    int strike = 0;
    for (int i = 0; i < 3; i++) {
      if (input.charAt(i) == answer.charAt(i)) {
        strike++;
      }
    }
    return strike;
  }

  private static int countBall(String input, Set<Character> answerSet, int strike) {
    int ball = 0;
    for (char c : input.toCharArray()) {
      if (answerSet.contains(c)) {
        ball++;
      }
    }
    return ball - strike;
  }

  public static String generateResultMessage(int strike, int ball) {
    if (strike == 0 && ball == 0) {
      return "낫싱";
    } else if (strike == 0) {
      return ball + "볼";
    } else if (ball == 0) {
      return strike + "스트라이크";
    } else {
      return ball + "볼 " + strike + "스트라이크";
    }
  }

  private static Set<Character> createAnswerSet(String answer) {
    return answer.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
  }


}
