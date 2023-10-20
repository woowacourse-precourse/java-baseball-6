package baseball.util.message;

import baseball.dto.Result;

public class PrintMessage {
    public static void inputPleaseMessage(){
        System.out.print("숫자를 입력해주세요 : ");
    }
    public static void startGameMessage(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void congratulationMessage(){
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
    public static void allBallResultMessage(Result result){
        System.out.printf("%d볼\n", result.getBallCount());
    }
    public static void allStrikeResultMessage(Result result){
        System.out.printf("%d스트라이크\n", result.getStrikeCount());
    }
    public static void ballAndStrikeMessage(Result result){
        System.out.printf("%d볼 %d스트라이크\n",result.getBallCount(),result.getStrikeCount());
    }
    public static void nothingCheckMessage(Result result){
        System.out.println("낫싱");
    }
}
