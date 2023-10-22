package baseball;

import java.util.Scanner;

public class GameController {


  public void gameStart() {

    while (true) {
      int result = 0; // 정답을 생성하여 주입
      int gameStatusNumber = 0; // 게임진행 상태 숫자

      System.out.println("숫자 야구 게임을 시작합니다.");
      System.out.print("숫자를 입력해주세요 : ");

      Scanner scanner = new Scanner(System.in);
      int input = scanner.nextInt();

      if(result == input) {
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
          continue;
        }
        break;
      }
    }
  }
}
