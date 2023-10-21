package baseball.io;

import baseball.model.Number;

public class Output {
    private static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String ALL_STRIKE_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String USER_CHOICE_MESSAGE= "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";


    public void printStartingMsg(){
        System.out.println(STARTING_MESSAGE);
    }
    public void printResult(int ballCount,int strikeCount){
        if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        }
        if (strikeCount != 0 && ballCount == 0) {
            System.out.println(strikeCount + "스트라이크");
        }
        if (strikeCount == 0 && ballCount != 0) {
            System.out.println(ballCount + "볼");
        }
        if (strikeCount != 0 && ballCount != 0) {
            System.out.println(ballCount + "볼 " + strikeCount + "스트라이크");
        }
        if (strikeCount == Number.getGameSize()) {
            System.out.println(ALL_STRIKE_MESSAGE);
            System.out.println(USER_CHOICE_MESSAGE);
        }
    }
}
