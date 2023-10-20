package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Baseball {
    //랜덤값 생성
    private static List<Integer> generateValue() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
    //사용자 입력 받음
    void playBaseball() {
        List<Integer> computer = generateValue();
        int strike = 0;
        int ball = 0;
        while (strike != 3) {
            System.out.println("숫자를 입력해주세요 : ");
            String user = Console.readLine();
            handleException(user);
            strike = 0;
            ball = 0;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (computer.get(i) == Integer.parseInt(String.valueOf(user.charAt(j)))) {
                        if (i == j) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            if (countingBall(strike, ball)) {
                break;
            }
        }
    }

    //스트라이크, 볼 처리
    boolean countingBall(int strike, int ball) {
        if (strike == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞추셨습니다! 게임 종료");
            return true;
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        }
        return false;
    }

    //사용자의 잘못된 입력 IllegalArgumentException 처리
    void handleException(String user) {
        if (user.length() != 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isDigit(user.charAt(i))) {
                throw new IllegalArgumentException();
            }
        }
    }



}
