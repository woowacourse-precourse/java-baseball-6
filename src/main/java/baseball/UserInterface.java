package baseball;

/**
 * 게임에 사용되는 각종 메시지 모음
 */
public class UserInterface {
    public void startMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void pleaseEnterNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void strikeMessage(int bulls) {
        System.out.print(bulls + "스트라이크 ");
    }

    public void ballMessage(int cows) {
        System.out.print(cows + "볼 ");
    }

    public void nothingMessage() {
        System.out.print("낫싱");
    }

    public void gameEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void restartOrShutdownMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
