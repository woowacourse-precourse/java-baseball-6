package baseball.view;

import baseball.model.GameResult;

public class View {
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";

    public static void gameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void gameInput() {
        System.out.println("숫자를 입력해주세요. : ");
    }

    public static void gameResult(GameResult gameResult) {
        String dynamicResult = getDynamicGameResult(gameResult);
        System.out.println(dynamicResult);
    }

    private static String getDynamicGameResult(GameResult gameResult) {
        String result = "";
        Integer ballCount = gameResult.getBallCount();
        Integer strikeCount = gameResult.getStrikeCount();

        if (ballCount == 0 && strikeCount == 0) {
            return NOTHING;
        }
        if (ballCount != 0) {
            result += ballCount + BALL + " ";
        }
        if (strikeCount != 0) {
            result += strikeCount + STRIKE;
        }
        return result;
    }

    public static void gameEnd(int gameSize) {
        System.out.println(gameSize + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
