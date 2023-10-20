package baseball.utils;

import java.util.List;

/*
 * true면 게임 종료, false면 숫자 입력 창으로 돌아가기
 */
public class ResultPrinter {
    public static boolean printHint(List<Integer> inputList) {
        Integer countOfStrike = inputList.get(0);
        Integer countOfBall = inputList.get(1);

        if (countOfStrike == 3) {
            System.out.println("3스트라이크");
            BaseballGameNoticeUtil.noticePlayerWin();
            return true;
        }

        if (countOfStrike == 0 && countOfBall == 0) {
            System.out.println("낫싱");
            return false;
        }

        strikeAndBall(countOfBall, countOfStrike);
        return false;
    }

    public static void strikeAndBall(Integer countOfBall, Integer countOfStrike) {
        String strikeAndBall = "";

        if (countOfBall != 0) {
            strikeAndBall += String.format("%d볼 ", countOfBall);
        }
        if (countOfStrike != 0) {
            strikeAndBall += String.format("%d스트라이크", countOfStrike);
        }

        System.out.println(strikeAndBall);
    }
}
