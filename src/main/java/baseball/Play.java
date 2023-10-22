package baseball;

import static baseball.Constants.IN_GAME;
import static baseball.Constants.RE_GAME;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Play {

  List<Integer> randomNumbers = new ArrayList<>();


  public int gameSet() {
    Computer computer = new Computer();
    Player player = new Player();

    Referee referee = new Referee(player);
    int gameStatus;

    referee.startGameMessage();
    randomNumbers = computer.getRandomNumbers();
    referee.setGivenNumbers(randomNumbers);
    do {
      referee.inputGameNumbersMessage();
      if (!player.userInputNumbers(IN_GAME)) {
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
      }
      gameStatus = referee.determine(player);

    }
    while (gameStatus == 1);

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    if (!player.userInputNumbers(RE_GAME)) {
      throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }
    return player.isReGame() ? 1 : 2;
  }
}
