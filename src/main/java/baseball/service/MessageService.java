package baseball.service;

public class MessageService {

    private static final int RESTART_GAME_NUMBER = 1;
    private static final int END_GAME_NUMBER = 2;
    private static final int BASEBALL_NUMBERS_SIZE = 3;

    private static final String START_GAME_MASSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String BALLS_MESSAGE = "볼";
    private static final String STRIKES_MESSAGE = "스트라이크";


    public void startGame() {
        System.out.println(START_GAME_MASSAGE);
    }

    public void inputPlayerNumber() {
        System.out.print(INPUT_NUMBER_MESSAGE);
    }

    public void printGameResult(int balls, int strikes) {
        StringBuilder sb = new StringBuilder();

        if (balls == 0 && strikes == 0) {
            sb.append(NOTHING_MESSAGE);
        }
        if (balls > 0) {
            sb.append(String.format("%d%s ", balls, BALLS_MESSAGE));
        }
        if (strikes > 0) {
            sb.append(String.format("%d%s", strikes, STRIKES_MESSAGE));
        }

        String result = sb.toString().trim();
        System.out.println(result);
    }

    public void announceThreeStrikes() {
        System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료%n", BASEBALL_NUMBERS_SIZE);
        System.out.printf("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.%n", RESTART_GAME_NUMBER, END_GAME_NUMBER);
    }
}
