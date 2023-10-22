package baseball.view;

import baseball.domain.RoundResult;

public class GameView {
    private static final String GAME_START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String REQUIRE_USER_BASEBALL_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String WIN_ROUND_MESSAGE = "게임 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
    }

    public static void printRequireNumberMessage(){
        System.out.print(REQUIRE_USER_BASEBALL_MESSAGE);
    }

    public static void printRoundResult(RoundResult roundResult){
        if(roundResult.isNothing()){
            System.out.println("낫싱");
        }
        if(roundResult.isOnlyStrike()){
            System.out.println(roundResult.getStrikeCount() + "스트라이크");
        }
        if(roundResult.isOnlyBall()){
            System.out.println(roundResult.getBallCount() + "볼");
        }
        System.out.println(roundResult.getStrikeCount() + "스트라이크 " + roundResult.getBallCount() + "볼");
    }

    public static void printWinMessage(){
        System.out.println(WIN_ROUND_MESSAGE);
    }
}
