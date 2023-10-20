package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;


public class Application {

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            if (playGame()) {
                continue;
            } else {
                break;
            }
        }
    }

    private static boolean playGame() {
        boolean again = false;

        ArrayList<Integer> computer = getRandomInt();
        //System.out.println(computer);

        // TODO : 사용자 입력 및 계산 로직 구현

        return again;
    }

    private static ArrayList<Integer> getRandomInt() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
