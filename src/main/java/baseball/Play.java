package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Play {

  List<Integer> randomNumbers = new ArrayList<>();


  public int play() {
    Computer computer = new Computer();
    Referee referee = new Referee();
    int gameStatus;

    referee.startGameMessage();
    randomNumbers = computer.getRandomNumbers();
    referee.setGivenNumbers(randomNumbers);
    do {
      System.out.print("숫자를 입력해주세요 : ");
      String input = Console.readLine();
      gameStatus = referee.determine(input);
    } while (gameStatus == 1);
    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    String restart = Console.readLine();
    return Integer.parseInt(restart);
  }
}
