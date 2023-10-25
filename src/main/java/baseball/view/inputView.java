package baseball.view;

public class inputView {
    private final String startText = "숫자 야구 게임을 시작합니다.";
    private final String inputText = "숫자를 입력해주세요 : ";
    private final String strikeText = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private final String conditionText = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";



    public void start() {
        System.out.println(startText);
    }
    public void inputText() {
        System.out.print(inputText);
    }

    public void StrikeText() {
        System.out.println(strikeText);
    }

    public void conditionText() {
        System.out.println(conditionText);
    }


}
