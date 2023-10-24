package baseball.view;

public class Message {

    public static Message instance;
    private Message() {};
    public static Message getInstance() {
        if (instance == null)
            instance = new Message();

        return instance;
    }

    public void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public void printBallCount(int ball, int strike) {
        if (ball == 0 && strike == 0)
            System.out.println("낫싱");
        else if (ball == 0)
            System.out.printf(String.format("%d스트라이크\n", strike));
        else if (strike == 0)
            System.out.printf(String.format("%d볼\n", ball));
        else
            System.out.printf(String.format("%d볼 %d스트라이크\n", ball, strike));
    }

    public void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public void printRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }


}