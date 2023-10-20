package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Game {

  private static final int NUMBER_LENGTH = 3;
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
      if (gameOver(result)) {
        break;
      }
    }
  }

  private boolean gameOver(int strike) {
    System.out.println(strike + " 스트라이크");
    return strike == NUMBER_LENGTH;
  }

  private int calculateResult(int randomNumber, int userNumber) {
    return strike(String.valueOf(randomNumber), String.valueOf(userNumber));
  }

  private int strike(String randomNumber, String userNumber) {
    var strike = 0;
    var randomNumberArr = randomNumber.split("");
    var userNumberArr = userNumber.split("");

    for (var i = 0; i < NUMBER_LENGTH; i++) {
      if (randomNumberArr[i].equals(userNumberArr[i])) {
        strike++;
      }
    }
    return strike;
  }

  // strike 메소드를 public으로 노출시키기 위해 추가한 메소드
  public int publicCalculateResult(String randomNumber, String userNumber) {
    return strike(randomNumber, userNumber);
  }
}
