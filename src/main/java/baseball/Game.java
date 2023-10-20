package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Game {

  private static final int NUMBER_LENGTH = 3;
  private static final String STRIKE = "스트라이크";
  private static final String BALL = "볼";
  private static final String NOTHING = "낫싱";
  private final RandomNumber computer = new RandomNumber();
  private final UserNumber user = new UserNumber();
  private boolean quit = false;

  public Game() {

  }

  public void play() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    while (!quit) {
      RandomNumber computer = new RandomNumber();
      int randomNumber = computer.getRandomNumber();
      System.out.println(randomNumber);
      var input = Console.readLine();
      user.setUserNumber(input);
      var result = calculateResult(randomNumber, user.getUserNumber());
      System.out.println(result);

      int strikes = getStrikeCountFromResult(result);
      if (gameOver(strikes)) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        input = Console.readLine();
        if ("1".equals(input.trim())) {
          System.out.println("새 게임을 시작합니다.");
          continue;
        } else if ("2".equals(input.trim())) {
          quit = true;
          break;
        } else {
          user.setUserNumber(input);
        }
      }

    }
  }


  private int getStrikeCountFromResult(String result) {
    if (result.contains(STRIKE)) {
      String[] parts = result.split(STRIKE);
      return Integer.parseInt(parts[0].trim());
    } else {
      return 0;
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
    if (isNothing(strike, ball)) {
      return NOTHING;
    }

    StringJoiner result = new StringJoiner(" ");
    formatBall(ball).ifPresent(result::add);
    formatStrike(strike).ifPresent(result::add);

    return result.toString();
  }

  private boolean isNothing(int strike, int ball) {
    return isZero(strike) && isZero(ball);
  }

  private boolean isZero(int number) {
    return Optional.of(number)
        .filter(n -> n == 0)
        .isPresent();
  }

  private Optional<String> formatBall(int ball) {
    return Optional.of(ball)
        .filter(b -> b > 0)
        .map(b -> b + BALL);
  }

  private Optional<String> formatStrike(int strike) {
    return Optional.of(strike)
        .filter(s -> s > 0)
        .map(s -> s + STRIKE);
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
