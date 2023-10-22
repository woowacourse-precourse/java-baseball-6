package baseball.view;

public class SystemMessage {

    public void gameStartMessage() {
        System.out.println("숫자 게임 야구를 시작합니다.");
    }

    public void requestInputData() {
        System.out.print("숫자를 입해주세요 : ");
    }

    public void askRetryMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void inputErrorMessage() {
        System.out.println("입력이 잘못되었습니다. 게임을 종료합니다.");
    }

}
