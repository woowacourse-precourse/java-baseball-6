package baseball.game;

import baseball.Key;
import baseball.object.Hint;

public class Print {

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

    public static boolean printResult() {
        if(Hint.isThreeStrike()) {
            System.out.println(Hint.getStrike() + Key.STRIKE);
            return true;
        }

        if(Hint.isNothing())
            System.out.println(Key.NOTHING);
        else if(Hint.isBallZero())
            System.out.println(Hint.getStrike() + Key.STRIKE);
        else if(Hint.isStrikeZero())
            System.out.println(Hint.getBall() + Key.BALL);
        else
            System.out.println(Hint.getBall() + Key.BALL + " " + Hint.getStrike() + Key.STRIKE);

        return false;
    }
}
