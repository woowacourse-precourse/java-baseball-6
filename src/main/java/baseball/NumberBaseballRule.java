package baseball;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberBaseballRule {

  /**
   * Returns strike based on user input and computer generated answer.
   *
   * @param input  the user input
   * @param answer the computer made answer
   * @return the integer count of strike
   */
  public static int countStrike(String input, String answer) {
    int strike = 0;
    for (int i = 0; i < 3; i++) {
      if (input.charAt(i) == answer.charAt(i)) {
        strike++;
      }
    }
    return strike;
  }

  /**
   * Returns ball based on user input and computer generated answer.
   *
   * @param input  the user input
   * @param answer the computer made answer
   * @return the integer count of ball
   */

  public static int countBall(String input, String answer) {
    Set<Character> answerSet = createAnswerSet(answer);
    return (int) IntStream.range(0, input.length())
        .filter(i -> answerSet.contains(input.charAt(i)) && input.charAt(i) != answer.charAt(i))
        .count();
  }

  /**
   * Returns set character of user input
   *
   * @param answer the user input
   * @return the character set of user input
   */
  private static Set<Character> createAnswerSet(String answer) {
    return answer.chars().mapToObj(c -> (char) c).collect(Collectors.toSet());
  }

}
