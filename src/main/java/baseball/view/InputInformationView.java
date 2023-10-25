package baseball.view;

public class InputInformationView {
    private static final String numberInput = "숫자를 입력해주세요 : ";
    private static final String reState = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    // "숫자를 입력해주세요 : " 문장을 출력하는 메서드.
    public void numberInputGuide() {
        System.out.print(numberInput);
    }
}
