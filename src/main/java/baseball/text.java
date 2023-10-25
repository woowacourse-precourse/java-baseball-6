package baseball;

public class text {
    private void start() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    private void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    private void win() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private void restartOrEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
