package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {

  // private static final String GAME_START = "숫자 야구 게임을 시작합니다.";
  private static final String INPUT_REQUEST = "숫자를 입력해주세요 : ";
  private static final String GAME_OVER = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

  public List<Integer> playerNumber() {
    System.out.println(INPUT_REQUEST);
    String input = Console.readLine();
    this.playerNumException(input);
    List<Integer> player = new ArrayList<>();
    for (char c : input.toCharArray()) {

      player.add(Character.getNumericValue(c));
    }
    return player;
  }

  public void playerNumException(String input) {
    if (input.isEmpty()) {
      throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
    } else if (!input.chars().allMatch(Character::isDigit)) {
      throw new IllegalArgumentException("숫자 이외의 문자가 포함되어 있습니다.");
    } else if (input.contains("0")) {
      throw new IllegalArgumentException("0이 포함되어 있습니다.");
    } else if (input.length() != 3) {
      throw new IllegalArgumentException("숫자가 3자리가 아닙니다.");
    }
  }

  public String getGameOver() {
    System.out.println(GAME_OVER);
    return Console.readLine();
  }
}
