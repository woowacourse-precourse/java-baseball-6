package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.stream.IntStream;

public class Game {

  private static final int NUMBER_LENGTH = 3;
  private static final String STRIKE = "스트라이크";
  private static final String BALL = "볼";
  private final RandomNumber computer = new RandomNumber();
  private final UserNumber user = new UserNumber();

  public Game() {

  }

  public void play() {
    int randomNumber = computer.getRandomNumber();

    while (true) {
      var input = Console.readLine();
      user.setUserNumber(input);
      var result = calculateResult(randomNumber, user.getUserNumber());
      if (gameOver(Integer.parseInt(result))) {
        break;
      }
    }
  }

  private boolean gameOver(int strike) {
    System.out.println(strike + STRIKE);
    return strike == NUMBER_LENGTH;
  }

  private String calculateResult(int randomNumber, int userNumber) {
    return strikeAndBall(String.valueOf(randomNumber), String.valueOf(userNumber));
  }

  private String strikeAndBall(String randomNumber, String userNumber) {

    int strikeCount = getStrikeCount(randomNumber, userNumber);
    int ballCount = getBallCount(randomNumber, userNumber);

    return formatResult(strikeCount, ballCount);
  }

  private String formatResult(int strike, int ball) {
    return String.format("%d%s %d%s", ball, BALL, strike, STRIKE);
  }

  public int getStrikeCount(String randomNumber, String userNumber) {
    return (int) IntStream.range(0, NUMBER_LENGTH)
        .filter(i -> randomNumber.charAt(i) == userNumber.charAt(i))
        .count();
  }

  public int getBallCount(String randomNumber, String userNumber) {
    return (int) IntStream.range(0, randomNumber.length())
        .filter(i -> IntStream.range(0, userNumber.length())
            .anyMatch(k -> randomNumber.charAt(i) == userNumber.charAt(k) && i != k))
        .count();
  }

  // strike 메소드를 public으로 노출시키기 위해 추가한 메소드
  public String publicCalculateResult(String randomNumber, String userNumber) {
    return strikeAndBall(randomNumber, userNumber);
  }
}
