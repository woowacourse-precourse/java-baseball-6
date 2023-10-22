package baseball;

import camp.nextstep.edu.missionutils.Randoms; //랜덤 값 생성
import java.util.ArrayList;
import java.util.List;

public class Comparison {

    static private List<Integer> computer;
    static private boolean over;
    Comparison() {
        over = false;
        computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
    }

    static int countStrike(List<Integer> list1, List<Integer> list2) {
        int count = 0;
        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                count++;
            }
        }
        return count;
    }

    static int countBall(List<Integer> list1, List<Integer> list2) {
        List<Integer> tempList1 = new ArrayList<>(list1);

        int sameCount = countStrike(list1, list2);

        tempList1.removeAll(list2);

        int count = list1.size() - tempList1.size() - sameCount;
        return count;
    }

    static boolean isOver () {
        return over;
    }

    static void compare (List<Integer> player) {
        int strike;
        int ball;

        strike = countStrike(computer, player);
        ball = countBall(computer, player);

        if (strike == 3) {
            System.out.printf("%d스트라이크%n", strike);
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            over = true;
        } else if (strike == 0 && ball == 0){
            System.out.println("낫싱");
        } else if (strike == 0) {
            System.out.printf("%d볼%n", ball);
        } else if (ball == 0) {
            System.out.printf("%d스트라이크%n", strike);
        } else {
            System.out.printf("%d볼 %d스트라이크%n", ball, strike);
        }
    }
}