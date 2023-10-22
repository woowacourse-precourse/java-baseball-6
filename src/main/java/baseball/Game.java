package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.stream.IntStream;

public class Game {

  private static final int NUMBER_LENGTH = 3;
  private static final String STRIKE = "스트라이크";
  private static final String BALL = "볼";
  private static final String NOTHING = "낫싱";
  private static final String INPUT_RESTART = "1";
  private static final String INPUT_QUIT = "2";
  private static final String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞췄습니다 게임종료";
  private static final String OUTPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  private final Computer computer = new Computer();
  private final User user = new User();
  private boolean quit = false;
  public String restartOrQuitInput;
  public List<String> inputArrList;


  public Game() {

  }

  public void setRestartOrQuitInput(String input) {
    this.restartOrQuitInput = input;
    getValidation();
  }

  public void play() {
    System.out.println("숫자 야구 게임을 시작합니다.");

    while (!quit) {
      int randomNumber = computer.getRandomNumber();
      System.out.println(randomNumber);
      var input = Console.readLine();
      user.setUserNumber(input);
      var result = calculateResult(randomNumber, user.getUserNumber());
      System.out.println(result);

      int strikes = getStrikeCountFromResult(result);
      if (gameOver(strikes)) {
        System.out.println(OUTPUT_SUCCESS);
        System.out.println(OUTPUT_RESTART);
        getValidation();
        input = Console.readLine();
        if (INPUT_RESTART.equals(input.trim())) {
          System.out.println("새 게임을 시작합니다.");
        } else if (INPUT_QUIT.equals(input.trim())) {
          quit = true;
          break;
        } else {
          user.setUserNumber(input);
        }
      }

    }
  }

  private void getValidation() {
    // validation
    String[] inputArr = {"1", "2"};
    inputArrList = Arrays.asList(inputArr);
    boolean inputValidation = inputArrList.contains(restartOrQuitInput);
    if (!inputValidation) {
      throw new IllegalArgumentException();
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
