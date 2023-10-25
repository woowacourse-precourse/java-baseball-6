package baseball.game;

public class GameUI {

    public void displayUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void displayStartGame() {
        System.out.println("숫자 야구 게임을 시작합니다");
    }

    public void displayCorrectAnswerMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void displayHint(String hint) {
        System.out.println(hint);
    }

    public void displayExceptionMessage(Exception e) {
        System.out.println(e);
    }
}
