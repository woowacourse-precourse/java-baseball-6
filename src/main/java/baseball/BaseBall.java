package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Objects;

public class BaseBall {
    public static void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        ComInt comInt = new ComInt();
        gameRun(comInt);
    }

    private static void gameRun(ComInt comInt) {
        while (true) {
            StrikeAndBall judge = getStrikeAndBall(comInt);
            if (judge.getStrike() == 3) {
                comInt = strikeOut();
                if (comInt == null) {
                    break;
                }
            }
        }
    }

    private static ComInt strikeOut() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return restart(Integer.parseInt(readLine()));
    }

    private static StrikeAndBall getStrikeAndBall(ComInt comInt) {
        System.out.print("숫자를 입력해주세요 : ");

        String input = readLine();
        Balls balls = new Balls(input);
        Round round = new Round();
        StrikeAndBall judge = round.judge(balls.getMyInt(), comInt);

        System.out.println(judged(judge));
        return judge;
    }

    private static ComInt restart(Integer i) {
        switch (i) {
            case 1 -> {
                return new ComInt();
            }
            case 2 -> {
                return null;
            }
        }
        throw new IllegalArgumentException();
    }


    private static String judged(StrikeAndBall judge) {
        int ball = judge.getBall();
        int strike = judge.getStrike();
        String ballStrikeString = getBallStrikeString(ball, strike);
        return Objects.requireNonNullElse(ballStrikeString, "낫싱");
    }

    private static String getBallStrikeString(int ball, int strike) {
        if (ball > 0 && strike > 0) {
            return ball + "볼 " + strike + "스트라이크";
        }
        if (ball > 0) {
            return ball + "볼";
        }
        if (strike > 0) {
            return strike + "스트라이크";
        }
        return null;
    }
}
