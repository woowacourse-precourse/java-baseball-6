package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public List<Integer> generateNumber() { //주어진 API를 활용해 3개의 랜덤 숫자를 생성한다.
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    public int countStrike(List<Integer> computer, List<Integer> player) { //스트라이크 개수 세는 기능
        int strike = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.get(i) == player.get(i)) {
                strike += 1;
            }
        }
        return strike;
    }

    public int countOverlap(List<Integer> computer, List<Integer> player) { //위치 상관없이 겹치는 숫자 세는 기능
        int result = 0;
        for (int i = 0; i < player.size(); i++) {
            if (computer.contains(player.get(i))) {
                result += 1;
            }
        }
        return result;
    }

    public int countBall(List<Integer> computer, List<Integer> player) { //볼 개수 세는 기능
        int overlap = countOverlap(computer, player);
        int strike = countStrike(computer, player);
        return overlap - strike;
    }

    public void printResult(List<Integer> computer, List<Integer> player) { //결과 출력
        int ball = countBall(computer, player);
        int strike = countStrike(computer, player);

        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
            return;
        }
        if (strike > 0 && ball > 0) {
            System.out.printf("%d볼 %d스트라이크\n", ball, strike);
            return;
        }
        if (strike > 0) {
            System.out.printf("%d스트라이크\n", strike);
            return;
        }
        if (ball > 0) {
            System.out.printf("%d볼\n", ball);
        }
    }

    public void run() { //랜덤 숫자 생성 및 정답 확인
        List<Integer> computer = generateNumber();
        Player p = new Player();
        int result = 0;
        while (result != 3) {
            List<Integer> player = p.player();
            printResult(computer, player);
            result = countStrike(computer, player);
        }
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

}
