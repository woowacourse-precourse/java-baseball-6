package baseball.view;

import java.util.Map;

public class OutputView {
    private InputView inputView = new InputView();
    
    public InputView getInputView() {
        return inputView;
    }
    // OUTPUT
    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printInputMessage(String input) {
        System.out.println(input);
    }

    public void printResultMessage(String result) {
        System.out.println(result);
    }

    public void printGameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printContinueOrQuitMessage(Map<String, String> map) {
        System.out.println("게임을 새로 시작하려면 " + map.get("continueInput") + ",종료하려면 " + map.get("quitInput") + "를 입력하세요.");
    }

    public void printQuitMessage() {
        System.out.println("게임을 종료합니다");
    }

}
