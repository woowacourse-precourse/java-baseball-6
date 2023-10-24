package baseball;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBaseballRule {

  public static int countStrike(String input, String answer) {
    int strike = 0;
    for (int i = 0; i < 3; i++) {
      if (input.charAt(i) == answer.charAt(i)) {
        strike++;
      }
    }
    return strike;
  }

  public static int countBall(String input, String answer) {
    Set<Character> answerSet = createAnswerSet(answer);
    return (int) IntStream.range(0, input.length())
        .filter(i -> answerSet.contains(input.charAt(i)) && input.charAt(i) != answer.charAt(i))
        .count();
  }


  private static Set<Character> createAnswerSet(String answer) {
    return answer.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
  }

}
