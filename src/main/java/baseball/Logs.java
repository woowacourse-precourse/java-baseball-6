package baseball;

public class Logs {
    private Logs() {

    }

    public static void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void result(int[] gameResult) {
        if (gameResult[0] == 0 && gameResult[1] == 0) {
            System.out.println("낫싱");
        } else if (gameResult[0] == 0) {
            System.out.println(gameResult[1] + "스트라이크");
        } else if (gameResult[1] == 0) {
            System.out.println(gameResult[0] + "볼");
        } else {
            System.out.println(gameResult[0] + "볼 " + gameResult[1] + "스트라이크");
        }
    }

    public static void end(int count) {
        System.out.println(count + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void checkTermination() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    
    public static void terminate() {
        System.out.println("게임 종료");
    }
}
