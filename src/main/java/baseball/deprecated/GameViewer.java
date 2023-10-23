package baseball.deprecated;

import camp.nextstep.edu.missionutils.Console;

public class GameViewer {
    private static Console console;

    private String tmp;

    public static void startGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }


    public String getUserGuess() {
        System.out.println("숫자를 입력해주세요 : ");
        tmp = console.readLine();

        return tmp;
    }

    public void displayGuessResult(int strike, int ball){
            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
            } else if (ball >= 1 && strike == 0) {
                System.out.println(ball + "볼");
            } else if (ball == 0 && strike >= 0) {
                System.out.println(strike + "스트라이크");
            } else {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            }
    }

    public boolean hasNewGameMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 \n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        tmp = console.readLine();
        if (tmp.equals("2")){
            // Exit() 호출 없이 종료시키기
            System.out.println("게임 종료");
            console.close();
            return false;
        }else if(tmp.equals("1")){
            // Game 새로 시작하기
            return true;
        }else{
            throw new IllegalArgumentException("1 혹은 2를 입력하셔야 합니다.");
        }
    }
}

