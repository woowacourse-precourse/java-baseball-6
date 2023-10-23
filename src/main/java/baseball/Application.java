package baseball;

import baseball.gamemanager.GameManager;
import baseball.result.BallCountResult;
import baseball.ui.ConsoleDisplayFactory;
import baseball.ui.GameRestartChoiceDisplay;
import baseball.ui.GameStartDisplay;
import baseball.ui.PrintMessage;
import baseball.ui.PrintResultMessage;

public class Application {
  public static void main(String[] args) {
    // TODO: 프로그램 구현
    /**
     * 프로그램 흐름도
     * 0. 게임 초기화
     * 1. 유저에게 n자리 숫자 입력 받기
     * 2. 숫자 검증
     * 2-1. 입력 포멧이 틀린 경우 예외 처리 및 프로그램 종료
     * 2-1-1. 숫자 범위를 벗어난 경우 예외 처리 및 프로그램 종료
     * 2-1-2. 반복되는 숫자가 포함되는 경우 예외 처리 및 프로그램 종료
     * 2-1-3. 숫자 0이 포함되는 경우 예외처리 및 프로그램 종료
     * 3. n자리 랜덤 숫자 생성
     * 3-1. 반복되는 숫자가 포함되는 경우 3번 단계로 이동
     * 3-2. 숫자 0이 포함되는 경우 3번 단계로 이동
     * 4. 유저가 입력한 숫자와 랜점 생성된 숫자를 비교
     * 4-1. 숫자는 일치하지만 위치가 다르면 볼
     * 4-2. 숫자와 위치 모두 맞으면 스트라이크
     * 4-3. 그 외에는 낫싱
     * 5. 검증 내용 출력
     * 5-1. 정답이 아닌경우 재입력 요청을 위해 1번 2번 단계 진행 후 3번 단계는 건너뛰고 4번 단계로 이동한다
     * 5-2. 정답인 경우 새로 시작 여부 확인
     * 5-2-1. 재시작한다면 0번 단계로 이동
     * 5-2-2. 종료한다면 프로그램 종료
     */
    

    GameManager gameManager = new GameManager();

    gameManager.start();

    PrintMessage start = ConsoleDisplayFactory.requestInput();
    PrintResultMessage resultDrawer = ConsoleDisplayFactory.result();
    PrintResultMessage endDrawer = ConsoleDisplayFactory.end();
    PrintMessage restartDrawer = ConsoleDisplayFactory.restartDrawer();

    while(true) {
      start.print(GameStartDisplay.NUMBER_INPUT_MESSAGE);
      gameManager.requestUserInput();

      BallCountResult ballCountResult = gameManager.calculateResult();
      resultDrawer.print(ballCountResult);

      if (!gameManager.isThreeStrike()) {
        continue;
      }

      endDrawer.print(ballCountResult); //모든 숫자를 맞추었다면 결과 및 메세지 출력
      restartDrawer.print(GameRestartChoiceDisplay.RESTART_MESSAGE); //재시작, 종료 여부 확인
      if (gameManager.requestGameRestartChoice() == 2) {
        break;
      }

      gameManager.restart();
    }

  }

}
