package baseball;

public class Notification {
    public static void notifySuccessResult(int[] strikeBallArray) {
        System.out.println(strikeBallArray[0] + "스트라이크");
        System.out.println(strikeBallArray[0] + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return;
    }

    public static void notifyFailResult(int[] strikeBallArray) {
        if (strikeBallArray[0] == 0 && strikeBallArray[1] == 0) {
            System.out.println("낫싱");
        }

        if (strikeBallArray[0] == 0 && strikeBallArray[1] != 0) {
            System.out.println(strikeBallArray[1] + "볼");
        }

        if (strikeBallArray[0] != 0 && strikeBallArray[1] == 0) {
            System.out.println(strikeBallArray[0] + "스트라이크");
        }

        if (strikeBallArray[0] != 0 && strikeBallArray[1] != 0) {
            System.out.println(strikeBallArray[1] + "볼 " + strikeBallArray[0] + "스트라이크");
        }
    }

    public static void notifyGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
}
