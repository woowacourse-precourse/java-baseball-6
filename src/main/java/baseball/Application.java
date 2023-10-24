package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        int ball = 0;
        int strike = 0;
        int restart = 0;

        // 게임 시작
        System.out.println("숫자 야구 게임을 시작합니다.");

        // 컴퓨터 임의 숫자 생성
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        // 사용자 입력
        String input = new String();

        try {
            input = Console.readLine();
            int inputNum = Integer.parseInt(input);
            int inputNum1 = inputNum / 100;
            int inputNum2 = inputNum % 100 / 10;
            int inputNum3 = inputNum % 10;
        }

        List<Integer> user = new ArrayList<>(Arrays.asList(inputNum1, inputNum2, inputNum3));

        for (int i = 0; i < computer.size(); i++) {
            for (int j = 0; j < user.size(); j++) {
                if (computer.get(i) == user.get(i)) {
                    strike++;
                } else if (computer.get(i) == user.get(j)) {
                    ball++;
                } else continue;
            }
        }

    }

    List<Integer> parseInput(String input) throws IllegalArgumentException {
        int inputNum = Integer.parseInt(input);
    }
}