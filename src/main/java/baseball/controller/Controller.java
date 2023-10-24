package baseball.controller;

import baseball.utils.Util;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Controller {
    List<Integer> randomIntegerList;

    public void run() {
        startGame();    //재시작 할 때 인사말 안나와야함
        int reGameOrExit = 1;
        while (reGameOrExit == 1) {
            getRandomNum();
            playGame();
            reGameOrExit = endGame();
        }
    }

    private void startGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    private void getRandomNum() {
        randomIntegerList = new ArrayList<>();  // 이렇게 생성할 필요 있나?
        for (int i = 0; i < 3; i++) {
            randomIntegerList.add(Randoms.pickNumberInRange(1, 9));
        }
//        System.out.println(randomIntegerList);
    }

    private void playGame() {
        boolean isThreeStrike = false;
        while (!isThreeStrike) {
            isThreeStrike = compareUserNumWithRandomNum(randomIntegerList, Util.getPlayerNum());
        }
    }


    private boolean compareUserNumWithRandomNum(List<Integer> randomIntegerList, List<Integer> playerIntegerList) {
        int strike = 0;
        int ball = 0;
        boolean threeStrike = false;
        for (int i = 0; i < 3; i++) {
            if (randomIntegerList.get(i).equals(playerIntegerList.get(i))) {
                strike += 1;
            } else if (randomIntegerList.contains(playerIntegerList.get(i))) {
                ball += 1;
            }
        }
        strikeAndBallMessage(strike, ball);
        if (strike == 3) {
            threeStrike = true;
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        return threeStrike;
    }

    private void strikeAndBallMessage(int strike, int ball) {
        if (strike > 0 && ball == 0) {
            System.out.println(strike+"스트라이크");
        } else if (strike == 0 && ball > 0) {
            System.out.println(ball+"볼");
        } else if (strike > 0 && ball > 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else {
            System.out.println("낫싱");
        }
    }

    private int endGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return Util.getReGameOrExitNum();
    }

}
