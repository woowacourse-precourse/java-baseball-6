package baseball.view;

public class Messages {
    public void printInitiateGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printBallsAndStrikesCount(int ball, int strikes) {
        System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
    }


    public void printBallsCount(int balls) {
        System.out.printf("%d볼\n", balls);
    }

    public void printStrikesCount(int strikes) {
        System.out.printf("%d스트라이크\n", strikes);
    }

    public void printNothing() {
        System.out.println("낫싱");
    }

    public void printEndGameMessage() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
}
