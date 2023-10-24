package baseball.service;

public class OutputView {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    //숫자 야구 게임 시작 메시지 출력
    public void showStartMessage(){
        System.out.println(START_MESSAGE);
    }

    //게임종료 메시지
    public void endMessage(){
        System.out.println(END_MESSAGE);
    }

    //힌트 메시지 출력
    public void showHintMessage(String hintMessage){
        System.out.println(hintMessage);
    }
}
