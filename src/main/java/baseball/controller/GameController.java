package baseball.controller;

import baseball.entity.Game;
import baseball.entity.Input;
import baseball.entity.Player;
import baseball.entity.Result;

import static baseball.controller.OutputController.*;
import static baseball.controller.OutputController.STRIKE;

public class GameController {

    InputController inputController;
    OutputController outputController;
    Game game;
    Player player;

    //생성자
    public GameController(InputController inputController, OutputController outputController, Game game, Player player) {
        this.inputController = inputController;
        this.outputController = outputController;
        this.game = game;
        this.player = player;
    }

    //각 게임 전 데이터 초기화
    public void before() {
        game.initAnswer();
        outputController.printNoticeln(START);
    }

    //게임 흐름 담고있는 함수
    public void start() {
        before(); //게임 전 데이터 초기화
        boolean gameResult=false;
        while (!gameResult) {   //맞출 때 까지 게임 반복
            gameResult = baseballGame();
        }
        re(); //게임이 끝난 후 재시작 의사 확인
    }

    //게임 메인 로직
    public boolean baseballGame() {
        //사용자 입력 받는 부분
        outputController.printNotice(INPUT);
        Input input = inputController.playerInput(true);
        player.setInputString(input.getInputString());

        //게임 결과 저장
        Result result = game(player, game);

        //결과 출력
        outputController.printResult(result.strike, result.ball);
        if (result.isAnswer) {
            outputController.printNoticeln(ANSWER);
            return true;
        }
        return false;
    }

    //재시작 커맨드
    public void re() {
        outputController.printNoticeln(AFTER);
        Input input = inputController.playerInput(false);
        if (input.getInputString().equals("1") ){
            start();
        }
    }

    //게임 결과 반환
    public Result game(Player player,Game game) {
        return new Result(game.isAnswer(player.getInputString()),game.countStrike(player.getInputString()), game.countBall(player.getInputString()) );
    }
}
