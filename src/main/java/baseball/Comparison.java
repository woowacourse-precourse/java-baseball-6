package baseball;

import java.util.ArrayList;
import java.util.List;

public class Comparison {

    static private boolean over;

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

        return list1.size() - tempList1.size() - sameCount;
    }

    static boolean isOver () {
        return over;
    }

    static void compare (Input computer, Input player) { //if문이 너무 많아 코드가 이쁘지 않다. 이를 줄일 수 있는 리팩토링은 무엇일까?
        int strike;
        int ball;

        strike = countStrike(computer.getNumber(), player.getNumber()); //좋은 객체지향은 getter 사용을 지양한다고 한다. 어떤 식으로 리팩토링 해야할까...
        ball = countBall(computer.getNumber(), player.getNumber());
        over = false;

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