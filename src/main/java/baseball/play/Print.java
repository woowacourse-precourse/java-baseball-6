package baseball.play;

import baseball.model.Hint;

public class Print {

    public final static String BALL = "볼";
    public final static String STRIKE = "스트라이크";
    public final static String NOTHING = "낫싱";

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printWantToRestartOrEnd() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static boolean printResult(Hint hint) {
        if (hint.isThreeStrike()) {
            System.out.println(hint.getStrike() + STRIKE);
            return true;
        }

        if (hint.isNothing()) {
            System.out.println(NOTHING);
        } else if (hint.isBallZero()) {
            System.out.println(hint.getStrike() + STRIKE);
        } else if (hint.isStrikeZero())
            System.out.println(hint.getBall() + BALL);
        else {
            System.out.println(hint.getBall() + BALL + " " + hint.getStrike() + STRIKE);
        }

        return false;
    }
}
