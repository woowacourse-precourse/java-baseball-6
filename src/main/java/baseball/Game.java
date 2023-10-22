package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.StringJoiner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.IntStream;

public class Game {

  private static final int NUMBER_LENGTH = 3;
  private static final String STRIKE = "스트라이크";
  private static final String BALL = "볼";
  private static final String NOTHING = "낫싱";
  private static final String INPUT_RESTART = "1";
  private static final String INPUT_QUIT = "2";
  private static final String OUTPUT_SUCCESS = "3개의 숫자를 모두 맞췄습니다 게임 종료";
  private static final String OUTPUT_RESTART = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
  private final Computer computer = new Computer();
  private final User user = new User();
  public String restartOrQuitInput;
  public List<String> inputArrList;
  public String quitInput;
  private boolean quit = false;
  private int randomNumber;
  private int userNumber;
  private int strike;
  private int ball;

  public Game() {

  }

  public void setRestartOrQuitInput(String input) {
    this.restartOrQuitInput = input;
    getValidation();
  }

  public void play() {
    System.out.println("숫자 야구 게임을 시작합니다.");
    initializeRandomNumber();
    while (!quit) {
      initializeUserNumber();
      initializeBallCount();
      var result = calculateResult(randomNumber, userNumber);
      System.out.println(result);
      int strikes = getStrikeCountFromResult(result);
      if (gameOver(strikes)) {
        System.out.println(OUTPUT_SUCCESS);
        System.out.println(OUTPUT_RESTART);
        setQuitInput();
        handleQuit();
        handleRestart();
      }
    }
  }

  private void handleRestart() {
    if (quitInput.equals(INPUT_RESTART)) {
      initializeRandomNumber();
    }
  }

  private void handleQuit() {
    if (quitInput.equals(INPUT_QUIT)) {
      quit = true;
    }
  }

  private void setQuitInput() {
    quitInput = Console.readLine();
    getValidation();
  }

  private void initializeBallCount() {
    strike = 0;
    ball = 0;
  }

  private void initializeUserNumber() {
    user.setUserNumber();
    userNumber = user.getUserNumber();
  }

  private void initializeRandomNumber() {
    computer.setRandomNumber();
    randomNumber = computer.getRandomNumber();
  }

  private void getValidation() {
    // validation
    String[] inputArr = {"1", "2"};
    inputArrList = Arrays.asList(inputArr);
    boolean inputValidation = inputArrList.contains(quitInput);
    if (!inputValidation) {
      throw new IllegalArgumentException();
    }
  }

  private int getStrikeCountFromResult(String result) {
    Matcher matcher = Pattern.compile("\\d+").matcher(result);
    if (matcher.find()) {
      return Integer.parseInt(matcher.group());
    }
    return 0;
  }

  private boolean gameOver(int strike) {
    return strike == NUMBER_LENGTH;
  }

  private String calculateResult(int randomNumber, int userNumber) {
    return strikeAndBall(String.valueOf(randomNumber), String.valueOf(userNumber));
  }

  private String strikeAndBall(String randomNumber, String userNumber) {
    strike = getStrikeCount(randomNumber, userNumber);
    ball = getBallCount(randomNumber, userNumber);

    return formatResult(strike, ball);
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
    strike = (int) IntStream.range(0, NUMBER_LENGTH)
        .filter(i -> randomNumber.charAt(i) == userNumber.charAt(i))
        .count();
    return strike;
  }

  public int getBallCount(String randomNumber, String userNumber) {
    ball = (int) IntStream.range(0, randomNumber.length())
        .filter(i -> IntStream.range(0, userNumber.length())
            .anyMatch(k -> randomNumber.charAt(i) == userNumber.charAt(k) && i != k))
        .count();
    return ball;
  }

  public String publicCalculateResult(String randomNumber, String userNumber) {
    return strikeAndBall(randomNumber, userNumber);
  }
}
