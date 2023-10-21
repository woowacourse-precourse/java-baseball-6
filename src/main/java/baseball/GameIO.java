package baseball;

public class GameIO {

    public static void gameResultPrint(int strikeCount, int ballCount) {
        //결과값 출력
        if (strikeCount + ballCount == 0) {
            System.out.println("낫싱");
            return;
        }

        String result = "";
        if (ballCount > 0) {
            result = ballCount + "볼 ";
        }
        if (strikeCount > 0) {
            result += strikeCount + "스트라이크";
        }

        System.out.println(result);
    }

    static void gameRestartPrint() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
                + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

}
