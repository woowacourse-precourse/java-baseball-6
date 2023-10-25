package baseball.view;

public class BaseballGameView {
    public void displayStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다."); // 게임 시작 메시지를 콘솔에 출력
    }

    public void displayGuessMessage() {
        System.out.print("숫자를 입력해주세요 : "); // 숫자 입력 요청 메시지를 콘솔에 출력
    }

    public void displayGameWonMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료"); // 게임 승리 메시지를 콘솔에 출력
    }

    public void displayRestartOrExitMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."); // 게임 재시작 또는 종료 선택 메시지를 콘솔에 출력
    }

    public void displayErrorMessage(String message) {
        System.out.println(message); // 오류 메시지를 콘솔에 출력
    }
}
