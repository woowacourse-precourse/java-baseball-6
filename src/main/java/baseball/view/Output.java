package baseball.view;

public class Output {
    public static void printGameResult(String result) {
        System.out.println(result);
    }

    public static void noticeWin() {
        System.out.println(GuideMessage.GAME_WIN);
    }
}
