package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class BaseballGame {
  private BallNumber ballNumber;
  private UserNumber userNumber;
  private ScoreDTO scoreDTO;

  private String userInput;

  public BaseballGame() {

  }

  public void startGame() {
    ballNumber = new BallNumber();
    userNumber = new UserNumber();
    while (true) {
      userNumber.inputUser();
      scoreDTO = new ScoreDTO();
      gameComputerUserCompare(ballNumber.getComputer(), userNumber.getUser());
      resultPrint();
      if (finishGame()) {
        return;
      }
    }

  }

  private void gameComputerUserCompare(List<Integer> computer, List<Integer> user) {
    for (int i = 0; i < computer.size(); i++) {
      for (int j = 0; j < user.size(); j++) {
        strikeCompare(computer, user, i, j);
        ballCompare(computer, user, i, j);
      }
    }
  }

  private void strikeCompare(List<Integer> computer, List<Integer> user, Integer computerIdx, Integer userIdx) {
    if (computer.get(computerIdx).equals(user.get(userIdx)) && computerIdx.equals(userIdx)) {
      scoreDTO.addStrike();
    }
  }

  private void ballCompare(List<Integer> computer, List<Integer> user, Integer computerIdx, Integer userIdx) {
    if (computer.get(computerIdx).equals(user.get(userIdx)) && !computerIdx.equals(userIdx)) {
      scoreDTO.addBall();
    }
  }

  private void resultPrint() {
    int ball = scoreDTO.getBall();
    int strike = scoreDTO.getStrike();
    if (ball > 0 && strike > 0) {
      System.out.println(ball + "볼 " + strike + "스트라이크");
    }
    if (ball > 0 && strike == 0) {
      System.out.println(ball + "볼");
    }
    if (strike > 0 && ball == 0) {
      System.out.println(strike + "스트라이크");
    }
    if (strike == 0 && ball == 0) {
      System.out.println("낫싱");
    }
  }

  private boolean finishGame() {
    if (scoreDTO.getStrike() == 3) {
      System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
      return true;
    }
    return false;
  }

  public boolean reStartGame() {
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    userInput = Console.readLine();
    validateInputLength(userInput);
    validateInputInt(userInput);
    if (userInput.equals("1")) {
      return true;
    }
    return false;
  }

  private void validateInputLength(String userInput) {
    if (userInput.length() != 1) {
      throw new IllegalArgumentException("1자리를 입력해주세요.");
    }
  }

  private void validateInputInt(String userInput) {
    try {
      int i = Integer.parseInt(userInput);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("숫자를 입력해주세요.");
    }
  }
}
