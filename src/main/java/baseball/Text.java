package baseball;

public class Text {
    public void start() {
        System.out.print("숫자 야구 게임을 시작합니다.\n");
    }

    public void inputNum() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void win() {
        System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n");
    }

    public void restartOrEnd() {
        System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
    }
}
