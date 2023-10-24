package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private boolean isProgress = true;

    // 전체 프로세스 실행
    public void startGame(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isProgress) {
            List<Integer> randomNumbers = RandomNumberGenerator.generate();

            String result = "";

            while (!result.equals("3스트라이크")) {
                System.out.print("숫자를 입력해주세요 : ");
                List<Integer> inputNumbers = setInputNumber();
                result = compareNumbers(randomNumbers, inputNumbers);
                System.out.println(result);
            }

            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            int selection = Integer.parseInt(Console.readLine());
            if (selection == 1) {
                isProgress = true;
            }
            if (selection == 2) {
                isProgress = false;
            }
        }

    }

    // 랜덤 숫자와 입력한 숫자를 비교하여 결과 반환
    private String compareNumbers(List<Integer> randomNumbers, List<Integer> inputNumbers) {
        int ball = 0;
        int strike = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randomNumbers.get(i) == inputNumbers.get(j) && i == j) {
                    strike++;
                }
                if (randomNumbers.get(i) == inputNumbers.get(j) && i != j) {
                    ball++;
                }
            }
        }

        String result = "";

        if (strike == 3) {
            return "3스트라이크";
        }
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }
        if (ball != 0) {
            result += ball + "볼 ";
        }
        if (strike != 0) {
            result += strike +"스트라이크 ";
        }

        return result;
    }
}
