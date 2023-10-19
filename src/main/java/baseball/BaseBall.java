package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comInt = makeComInt(new ArrayList<>());
        gameRun(comInt);
    }

    private static void gameRun(List<Integer> comInt) {
        while (true) {
            Round.StrikeAndBall judge = getStrikeAndBall(comInt);
            if (judge.getStrike() == 3) {
                comInt = strikeOut(comInt);
                if (comInt == null) break;
            }
        }
    }

    private static List<Integer> strikeOut(List<Integer> comInt) {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        comInt = restart(Integer.parseInt(readLine()), comInt);
        return comInt;
    }

    private static Round.StrikeAndBall getStrikeAndBall(List<Integer> comInt) {
        System.out.print("숫자를 입력해주세요 : ");

        String input = readLine();
        Balls balls = new Balls(input);
        Round round = new Round();
        Round.StrikeAndBall judge = round.judge(balls.getMyInt(), comInt);

        System.out.println(judged(judge));
        return judge;
    }

    private static List<Integer> restart(Integer i, List<Integer> comInt) {
        if (i == 1) {
            return makeComInt(new ArrayList<>());
        }
        if (i == 2) {
            return null;
        }
        throw new IllegalArgumentException();
    }


    private static List<Integer> makeComInt(List<Integer> comInt) {
        while (comInt.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!comInt.contains(randomNumber)) {
                comInt.add(randomNumber);
            }
        }
        return comInt;
    }

    private static String judged(Round.StrikeAndBall judge) {
        int ball = judge.getBall();
        int strike = judge.getStrike();
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball > 0) {
            return ball + "볼";
        }
        if (strike > 0) {
            return strike + "스트라이크";
        }
        return "낫싱";
    }
}
