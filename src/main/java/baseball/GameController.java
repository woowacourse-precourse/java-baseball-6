package baseball;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GameController {

  private NumberController numberController;

  public GameController(NumberController numberController) {
    this.numberController = numberController;
  }

  public void gameStart() {
    List<Integer> resultNumList = numberController.generate(); //정답숫자리스트

    Integer gameStatusNumber = 0; // 게임진행 상태 숫자
    Integer strike = 0;
    Integer ball = 0;

    System.out.println("숫자 야구 게임을 시작합니다.");

    while (true) {
      System.out.print("숫자를 입력해주세요 : ");

      Scanner scanner = new Scanner(System.in);
      int inputNum = scanner.nextInt();
      List<Integer> inputNumList = numberController.splitter(inputNum);

      Map<String, Integer> report = numberController.compareNumberList(resultNumList, inputNumList);
      strike = report.get("strike");
      ball = report.get("ball");

      if(strike == 3) {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        while (true) {
          System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
          gameStatusNumber = scanner.nextInt();

          if(gameStatusNumber != 1 && gameStatusNumber != 2) {
            System.out.println("잘못된 숫자를 입력하셨습니다.");
            continue;
          }
          break;
        }

        if(gameStatusNumber == 1) {
          resultNumList = numberController.generate(); //정답숫자리스트

          continue;
        }
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
