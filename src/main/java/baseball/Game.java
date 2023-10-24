package baseball;

import java.util.List;

public class Game {
    GameStartView gameStart = new GameStartView();
    GamePlayView gamePlay = new GamePlayView();
    GameEndView gameEnd = new GameEndView();
    Computer computer = new Computer();
    Player player = new Player();
    List<Integer> answer;
    String playerInput;
    List<Character> playerInputList;
    List<Integer> playerInputIntegerList;
    Referee referee = new Referee();
    boolean toRegameOrNot = false;
    String toRegameOrNotString;

    public void play() {
        // 게임 시작 문구 출력
        gameStart.run();

        // do-while
        do {
            // 컴퓨터 정답 생성
            answer = computer.createAnswer();
            String judgement = "";
            while (!judgement.equals("3스트라이크")) {
                // 입력 요청 문구 출력
                gamePlay.run();
                // 플레이어 입력값 받기
                playerInput = gamePlay.receiveInputFromPlayer();
                // 플레이어 입력값 Char List로 변경
                playerInputList = player.convertStringToCharList(playerInput);
                // 플레이어 입력값 유효성 검사
                Validators.validatePlayerInput(playerInputList);
                // 플레이어 입력값 Char List에서 Integer List로 변경
                playerInputIntegerList = player.convertCharToIntegerList(playerInputList);
                // 판정 실시
                judgement = referee.judge(answer, playerInputIntegerList);
                gamePlay.printJudgement(judgement);
            }
            // 게임 종료 문구 출력
            gameEnd.printGameEndingMessage();
            // 재시작 혹은 최종 종료 문구 출력
            gameEnd.printAskingRegameIntentionMessage();
            // 플레이어 입력값 받기
            toRegameOrNotString = gamePlay.receiveInputFromPlayer();
            Validators.validateOneTwo(toRegameOrNotString);
            toRegameOrNot = gameEnd.checkWhetherToRegameOrNot(toRegameOrNotString);
        } while (toRegameOrNot);
    }
}
