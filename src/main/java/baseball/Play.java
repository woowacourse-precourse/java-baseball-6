package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Play {

  List<Integer> randomNumbers = new ArrayList<>();


  public int gameSet() {
    Computer computer = new Computer();
    Referee referee = new Referee();
    Player player = new Player();
    int gameStatus;

    referee.startGameMessage();
    randomNumbers = computer.getRandomNumbers();
    referee.setGivenNumbers(randomNumbers);
    do {
      System.out.print("숫자를 입력해주세요 : ");
      String input = Console.readLine();
      if (!player.validateInput(input)) {
        throw new IllegalArgumentException("입력 형식이 올바르지 않습니다.");
      }
      gameStatus = referee.determine(input);

    }
    while (gameStatus == 1);

    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String restart = Console.readLine();
    return Integer.parseInt(restart);
  }
}
