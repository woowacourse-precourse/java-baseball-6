package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class BaseBall {
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        List<Integer> comInt = makeComInt(new ArrayList<>());
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");

            String input = readLine();
            Balls balls = new Balls(input);

            Round round = new Round();

            Round.StrikeAndBall judge = round.judge(balls.getMyInt(), comInt);

            System.out.println(judged(judge));

            if (judge.getStrike() == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                Integer restart = Integer.parseInt(readLine());
                if (restart == 1) {
                    comInt = makeComInt(new ArrayList<>());
                } else if (restart == 2) {
                    break;
                } else {
                    throw new IllegalArgumentException();
                }
            }
        }
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
        if (judge.getBall() > 0 && judge.getStrike() > 0) {
            return judge.getBall() + "볼 " + judge.getStrike() + "스트라이크";
        } else if (judge.getBall() > 0) {
            return judge.getBall() + "볼";
        } else if (judge.getStrike() > 0) {
            return judge.getStrike() + "스트라이크";
        } else {
            return "낫싱";
        }

    }
}
