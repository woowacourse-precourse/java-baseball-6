package baseball;

public class OutputHandler {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printGameStart() {
        printMessage("숫자 야구 게임을 시작합니다.");
    }

    public void printGameEnd() {
        printMessage("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printGameRestart() {
        printMessage("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputPrompt() {
        printMessage("숫자를 입력해주세요 : ");
    }

    public void printHint() {
        // TODO
        printMessage("0볼 0스트라이크");
    }
}
