package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Map;

public class GameController {

  private NumberController numberController;
  private ExceptionController exceptionController;

  public GameController(NumberController numberController,
      ExceptionController exceptionController) {
    this.numberController = numberController;
    this.exceptionController = exceptionController;
  }

  public void gameStart() {
    List<Integer> resultNumList = numberController.generateComputerNumberList();

    Integer gameProgressNumber = 0;
    Integer strike = 0;
    Integer ball = 0;

    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      System.out.print("숫자를 입력해주세요 : ");
      String input = Console.readLine();
      Integer inputNum = Integer.parseInt(input);
      exceptionController.validateThreeDigitNumber(inputNum);
      List<Integer> inputNumList = numberController.splitter(inputNum);

      Map<String, Integer> report = numberController.compareNumberList(resultNumList, inputNumList);
      strike = report.get("strike");
      ball = report.get("ball");

      if(strike == 3) {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        gameProgressNumber = Integer.parseInt(Console.readLine());
        exceptionController.validateGameProgressNumber(gameProgressNumber);

        if(gameProgressNumber == 1) {
          resultNumList = numberController.generateComputerNumberList();

          continue;
        }
        System.out.println("게임 종료");
        break;
      }
      else if(strike == 0 && ball == 0) {
        System.out.println("낫싱");
      }
      else if(strike != 0 && ball != 0) {
        System.out.println(ball + "볼" + " " + strike + "스트라이크");
      }
      else if(strike != 0 && ball == 0) {
        System.out.println(strike + "스트라이크");
      }
      else if(strike == 0 && ball != 0) {
        System.out.println(ball + "볼");
      }

    }
  }
}
