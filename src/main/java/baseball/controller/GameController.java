package baseball.controller;

import baseball.model.ComputerNumber;
import baseball.model.GameResultGenerator;
import baseball.model.PlayerChoice;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public static boolean run() {
        //심판관은 한명이어야 하니 static 메서드로 만들었는데 추가 생각 필요 TODO
        ComputerNumber computerNumber = createComputerNumber();
        do {
            play(computerNumber);
        }
        while (play(computerNumber));
        return doRestart();
    }

    /**
     * ComputerNumber 생성
     */
    public static ComputerNumber createComputerNumber() {
        return ComputerNumber.createComputerNumber();
    }

    /**
     * 게임 결과가 3스트라이크 인 경우 : false 리턴
     */
    public static boolean play(ComputerNumber computerNumber) {

        OutputView.printGetInput();  //사용자로부터 값 입력 받는 문구 출력
        String input = InputView.readInput();  //사용자로부터 값을 입력 받기
        PlayerNumber playerNumber = PlayerNumber.createPlayerNumber(input);  //PlayerNumber 객체 생성

        //게임 결과 계산
        GameResultGenerator gameResultGenerator = new GameResultGenerator(computerNumber, playerNumber);

        //게임 결과 출력
        OutputView.printResult(gameResultGenerator.isNothing(), gameResultGenerator.getBallCount(), gameResultGenerator.getStrikeCount());

        //게임 종료 여부 리턴 (종료면 false 리턴)
        return !gameResultGenerator.isThreeStrike();
    }

    /**
     * 게임 종료 시 재시작 or 종료 판단
     * @return 재시작:true, 종료:false
     */
    public static boolean doRestart() {
        OutputView.printEnd();
        String input = InputView.readInput();
        PlayerChoice playerChoice = new PlayerChoice(input);
        return playerChoice.getValue() == 1;
    }
}
