package baseball;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 클래스 별로 초기화
        OutputView view = new OutputView();
        GameData gameData = init();
        BaseballManageController controller = new BaseballManageController(gameData, view);

        do {
            //시작문구 출력
            controller.printStart();
            //컴퓨터 랜덤숫자 3자리 생성
            controller.generateComNums();

            do {
                //플레이어 숫자 입력 요청 메시지 출력 및 메시지 입력 받기(예외처리(3자리수 이외의 숫자, 숫자가 아닌 경우))
                controller.printRequirePlayerInput();
                controller.setPlayerNumbers(controller.playerNumsInput());

                //컴퓨터 랜덤 3자리 숫자와 플레이어 3자리 숫자 비교하여 볼, 스트라이크 개수 추출
                controller.countBall(controller.getComputerNumbers(), controller.getPlayerNumbers());
                controller.countStrike(controller.getComputerNumbers(), controller.getPlayerNumbers());

                //추출된 볼, 스트라이크 개수에 따라 출력 함수 호출
                controller.printResult(controller.getBallCnt(), controller.getStrikeCnt());

            } while (controller.getStrikeCnt() != 3);

                //3스트라이크일 경우 게임종료 메시지 출력
                controller.printEndgame();
                //게임 재시작 여부 확인 메시지 출력
                controller.printAskRestart();
                //게임 재시작 진행을 위한 값 입력 받기(예외처리(1,2 이외의 값 입력 시 IllegalArgumentsException))
                controller.restartInput();

            if (controller.getGameRepetition().equals("2")) {
                break;
            }

        } while (controller.getGameRepetition().equals("1"));

    }

    private static GameData init() {
        GameData gameData = new GameData();

        gameData.setGameRepetition("1");
        gameData.setStrikeCnt(0);
        gameData.setBallCnt(0);
        gameData.setComputerNumbers(new ArrayList<>());

        return gameData;
    }

}
