package baseball.controller;

import baseball.model.Computer;
import baseball.model.Player;
import baseball.model.validator.Validator;
import baseball.view.Input;
import baseball.view.Output;

public class BaseballGame {
    private final Computer computer; // 하나로 정해놨기 때문에 상수로 함
    private static Player player; // 내가 입력하면서 볼, 스트라이크 여부 진행
    private final Validator validator;

    public BaseballGame() {
        computer = new Computer();
        validator = new Validator();
    }

    // 게임 시작
    public void gameStart() {
        do {
            getNumberFromPlayer();
            printCnt(getNumberCompare());
        }
        while (!restart());
    }

    public void getNumberFromPlayer() {
        player = new Player(Input.gameStart()); // 숫자를 입력하세요
        player.getPlayerNumber();
    }

    //카운트 한 것 비교
    public int[] getNumberCompare() {
        //computer가 null
        return validator.getNumberCompare(player.getPlayerNumber(), computer.getComputerNumber());
    }

    //count한 것 출력
    public static void printCnt(int[] count) {
        printBallCnt(count);
        printStrikeCnt(count);
        printNothing(count);
    }

    //count[0] -> ballCnt, count[1] -> strikeCnt
    //strike 카운트
    public static void printStrikeCnt(int[] count) {
        if (count[1] != 0) {
            Output.printCount(count[1]);
            Output.printStrike();
        }
    }

    //ball 카운트
    public static void printBallCnt(int[] count) {
        if (count[0] != 0) { // 볼이 있는 경우
            if (count[1] != 0) { // 스트라이크도 있는 경우
                Output.printCount(count[0]);
                Output.printBallAndStrike();
            } else { // 볼만 있는 경우
                Output.printCount(count[0]);
                Output.printBall();
            }
        }
    }

    //낫싱
    public static void printNothing(int[] count) {
        if (count[0] == 0 && count[1] == 0) {
            Output.printNothing();
        }
    }

    public boolean restart() {
        // 3스트라이크가 나오면 게임 끝냄(true) 즉 false면 계속 진행
        if (validator.threeStrike()) {
            Output.printGameFinish();
            return true;
        }
        return false;
    }
}
