package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean replay = true;
        boolean isGameEnd;

        while (replay) {
            List<Integer> randomNumbers = GameUtil.makeRandomNumbers();
            isGameEnd = false;

            while (!isGameEnd) {
                // 3자리 숫자 입력받기
                System.out.print("숫자를 입력해주세요 : ");
                String input = Console.readLine();
                Validate.validateInput(input);

                // 입력받은 숫자 한자씩 구하기
                String[] inputSplit = input.split("");
                Validate.checkDuplication(inputSplit);

                int strike = 0; // 스트라이크 개수
                int ball = 0; // 볼 개수

                // 입력받은 숫자와 랜덤 숫자 3자리를 한자리씩 비교하며 스트라이크, 볼, 낫싱 체크하기
                for (int i = 0; i < inputSplit.length; i++) {
                    if (String.valueOf(randomNumbers.get(i)).equals(inputSplit[i])) {
                        strike++;
                    } else if (randomNumbers.toString().contains(inputSplit[i])) {
                        ball++;
                    }
                }

                // ball, strike 각 개수 출력
                GameUtil.printResult(ball, strike);
                isGameEnd = GameUtil.isEnd(ball, strike);

                //결과 출력후 계속 진행해야할 경우 true, 멈춰야하는 경우 false 반환
                if (isGameEnd && !Replay.askReplay()) {
                    return;
                }
            }
        }
    }
}
