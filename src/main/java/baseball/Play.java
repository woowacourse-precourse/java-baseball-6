package baseball;

import static baseball.Constants.IN_GAME;
import static baseball.Constants.RE_GAME;

import java.util.ArrayList;
import java.util.List;

public class Play {

  List<Integer> randomNumbers = new ArrayList<>();

  public int gameSet() {
    Computer computer = new Computer();
    Player player = new Player();

    Referee referee = new Referee(player);
    referee.announceGameStart();
    randomNumbers = computer.getRandomNumbers();
    referee.setGivenNumbers(randomNumbers);
    matchInGame(referee, player);
    referee.announceGameRestart();
    if (!player.userInputNumbers(RE_GAME)) {
      throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
    }
    return player.isReGame() ? 1 : 2;
  }

  private static void matchInGame(Referee referee, Player player) {
    int gameStatus;
    while (true) {
      referee.inputGameNumbersMessage();
      if (!player.userInputNumbers(IN_GAME)) {
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
      }
      gameStatus = referee.determine(player);
      if (gameStatus != 1) {
        break;
      }
    }
  }
}
