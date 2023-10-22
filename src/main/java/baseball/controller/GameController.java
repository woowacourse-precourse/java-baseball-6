package baseball.controller;

import baseball.Util.MessageUtil;
import baseball.dto.Result;
import baseball.service.GameService;

import java.util.List;

public class GameController {
    private final GameService gameService;
    private final MessageUtil messageUtil;

    public GameController(GameService gameService, MessageUtil messageUtil) {
        this.gameService = gameService;
        this.messageUtil = messageUtil;
    }

    public void play() {
        messageUtil.printStart();

        while (!gameService.isGameEnd()) {
            messageUtil.printInput();

            List<Integer> answer = gameService.createAnswer();
            List<Integer> input = gameService.getInput();

            Result result = gameService.compare(answer, input);
            messageUtil.printResult(result);

            //TODO: 결과가 3 스트라이크인 경우, 재시작 여부 확인
            if (gameService.isWin(result)) {
                //TODO: 승리 문구 출력 및 재시작 여부 확인
                messageUtil.printWin();
                gameService.setGameEnd(); // gameService.isGameEnd를 True로 전환
            }
        }

        Integer command = messageUtil.printAskRestart(); // 1 또는 2가 아닌 경우 예외

        //TODO: 재시작(1)인 경우 게임 재시작, 종료(2)인 경우 게임 종료
        if (command.equals(1)) {
            gameService.init(); // isGameEnd의 값을 false로 재설정
            play();
        }
    }
}
