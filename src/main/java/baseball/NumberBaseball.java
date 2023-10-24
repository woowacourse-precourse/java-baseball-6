package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumberBaseball {

    public static final int RESTART_INPUT = 1;
    public static final int EXIT_INPUT = 2;

    public boolean execute() throws IllegalArgumentException {

        System.out.println("숫자 야구 게임을 시작합니다.");

        int[] randomNumber = new int[3];
        // 중복 되지 않는 랜덤(타겟)숫자 생성
        do {
            randomNumber[0] = Randoms.pickNumberInRange(1, 9);
            randomNumber[1] = Randoms.pickNumberInRange(1, 9);
            randomNumber[2] = Randoms.pickNumberInRange(1, 9);
        } while (randomNumber[0] == randomNumber[1] || randomNumber[0] == randomNumber[2]
                || randomNumber[1] == randomNumber[2]);

//        System.out.print(randomNumber[0]);
//        System.out.print(randomNumber[1]);
//        System.out.println(randomNumber[2]);

        while (true) {
            int strike = 0;
            int ball = 0;
            // 게이머(사용자)의 숫자를 입력을 받는다.
            // 3자리 숫자가 아닌 경우, 에러 발생
            System.out.print("숫자를 입력해주세요 : ");
            String gamerInput = Console.readLine();

            if (gamerInput.length() != 3) {
                throw new IllegalArgumentException();
            }

            int[] gamerNumber = new int[3];
            // 입력이 숫자가 아닌 경우, 에러 발생
            try {
                char[] gNArr = gamerInput.toCharArray();
                gamerNumber[0] = Character.getNumericValue(gNArr[0]);
                gamerNumber[1] = Character.getNumericValue(gNArr[1]);
                gamerNumber[2] = Character.getNumericValue(gNArr[2]);
            } catch (Exception e) {
                throw new IllegalArgumentException();
            }
            // 중복된 숫자 입력한 경우, 에러 발생
            if (gamerNumber[0] == gamerNumber[1] || gamerNumber[0] == gamerNumber[2]
                    || gamerNumber[1] == gamerNumber[2]) {
                throw new IllegalArgumentException();
            }
            // 게이머(사용자) 숫자와 랜덤(타겟) 숫자를 비교 하여 볼, 스트라이크 갯수 확인
            for (int i = 0; i < gamerNumber.length; i++) {
                for (int k = 0; k < randomNumber.length; k++) {
                    if (gamerNumber[i] == randomNumber[k]) {
                        if (i == k) {
                            strike++;
                        } else {
                            ball++;
                        }
                    }
                }
            }
            // 볼, 스트라이크 출력
            if (strike == 3) {
                System.out.println(strike + "스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                break;
            }

            if (ball == 0 && strike == 0) {
                System.out.println("낫싱");
                continue;
            }

            String resultMessage = "";
            if (ball > 0) {
                resultMessage += ball + "볼";
            }
            if (strike > 0) {
                if (!resultMessage.isBlank()) {
                    resultMessage += " ";
                }
                resultMessage += strike + "스트라이크";
            }
            System.out.println(resultMessage);

        }

        String Restart = Console.readLine();

        switch (Integer.parseInt(Restart)) {
            case RESTART_INPUT:
                return true;
            case EXIT_INPUT:
                return false;
            default:
                throw new IllegalArgumentException();
        }
    }
}