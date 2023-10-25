package baseball.view;

public class Messages {
    public static void printInitiateGameMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMessage() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printBallsAndStrikesCount(int balls, int strikes) {
        System.out.printf("%d볼 %d스트라이크\n", balls, strikes);
    }


    public static void printBallsCount(int balls) {
        System.out.printf("%d볼\n", balls);
    }

    public static void printStrikesCount(int strikes) {
        System.out.printf("%d스트라이크\n", strikes);
    }

    public static void printNothing() {
        System.out.println("낫싱");
    }

    public static void printEndGameMessage() {
        System.out.println("숫자 야구 게임을 종료합니다.");
    }
}
