package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class OutPut {
    public void gameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    
    public void resultMessage(int ball, int strike){
        if (ball > 0 && strike == 0) {
            System.out.println(ball + "볼");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        if (strike > 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
    }

    public void GameOverMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public boolean promptForGameRestart() {
        String answer = Console.readLine();
        if(answer.equals("1")) {
            return true;
        }
        if (answer.equals("2")) {
            return false;
        }
        throw new IllegalArgumentException("1과 2만 입력 가능합니다.");
    }
}
