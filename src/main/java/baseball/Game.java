package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    List<Integer> computerNum;

    private boolean isWin;

    public boolean isWin() {
        return isWin;
    }

    public void init() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        computerNum = new ArrayList<>();

        while (computerNum.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNum.contains(randomNumber)) {
                computerNum.add(randomNumber);
            }
        }
    }

    public void validation(String input) {
        int number;

        try {
            number = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
        }

        if (123 <= number && number <= 987) {
            int[] digits = new int[3];
            digits[0] = number % 10;
            digits[1] = (number / 10) % 10;
            digits[2] = number / 100;

            if (!(digits[0] != digits[1] && digits[1] != digits[2] && digits[0] != digits[2])) {
                throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
            }

        } else {
            throw new IllegalArgumentException("1~9로 이루어진 서로 다른 세자리 숫자를 입력해야 합니다. 게임이 종료됩니다.");
        }
    }

    public List<Integer> getComputerNum() {
        return computerNum;
    }

    public List<Integer> userNumber(String input) {
        List<Integer> userNum = new ArrayList<>();
        for (int i = 0; i < input.length(); i++) {
            userNum.add(input.charAt(i) - '0');
        }

        return userNum;
    }

    public String check(List<Integer> computerNum, List<Integer> userNum) {
        int strike = 0;
        int ball = 0;

        for (int i = 0; i < 3; i++) {
            if (computerNum.get(i).equals(userNum.get(i))) {
                strike++;
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (computerNum.get(i).equals(userNum.get(j))) {
                    if (i != j) {
                        ball++;
                    }
                }
            }
        }

        if (strike == 0 && ball == 0) {
            return "낫싱";
        }

        StringBuilder sb = new StringBuilder();
        if (ball != 0) {
            sb.append(ball).append("볼 ");
        }
        if (strike != 0) {
            sb.append(strike).append("스트라이크");
        }

        if (strike == 3) {
            isWin = true;
        }

        return sb.toString();
    }


}
