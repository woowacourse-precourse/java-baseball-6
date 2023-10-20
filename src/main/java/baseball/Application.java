package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 1번 선택 후 다시 시작하면 플레이어 숫자와 컴퓨터 숫자의 계산 결과가 일치하지 않음.
        BaseBallGameUI baseBallGameUI = new BaseBallGameUI();
        baseBallGameUI.startGame();
    }
}
