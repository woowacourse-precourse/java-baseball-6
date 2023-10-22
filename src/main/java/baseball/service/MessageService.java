package baseball.service;

public class MessageService {

    private static final int RESTART_GAME_NUMBER = 1;
    private static final int END_GAME_NUMBER = 2;

    public void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void inputPlayerNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printGameResult(int balls, int strikes) {
        StringBuilder sb = new StringBuilder();

        if (balls == 0 && strikes == 0) {
            sb.append("낫싱");
        }
        if (balls > 0) {
            sb.append(String.format("%d볼 ", balls));
        }
        if (strikes > 0) {
            sb.append(String.format("%d스트라이크", strikes));
        }

        String result = sb.toString().trim();
        System.out.println(result);
    }

    public void announceThreeStrikes() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n",
                RESTART_GAME_NUMBER, END_GAME_NUMBER);
    }
}
