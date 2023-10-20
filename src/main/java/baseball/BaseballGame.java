package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final int gameFew;

    public BaseballGame(int gameFew) {
        this.gameFew = gameFew;
    }

    public boolean startGame() {

        List<String> gameSuccessKey = randomNumberGenerator(); //정답 배열
        System.out.println("숫자 야구 게임을 시작합니다.");

        //게임 시작
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputNumber = Console.readLine().split("");

            if (gameValidator(inputNumber)) {
                throw new IllegalArgumentException();
            }

            int strike = 0;
            int ball = 0;

            for (int i = 0; i < gameFew; i++) {
                if (gameSuccessKey.get(i).equals(inputNumber[i])) {
                    strike++;
                    continue;
                }
                if (gameSuccessKey.contains(inputNumber[i])) {
                    ball++;
                }
            }

            //정답
            if (strike == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String inputEnd = Console.readLine();
                return gameValidator(inputEnd);
            }

            //볼, 스트라이크에 따른 출력
            gameOutput(strike, ball);

        }

    }

    private boolean gameValidator(String inputNumber) {

        if (inputNumber.equals("1")) {
            return true;
        }

        if (inputNumber.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException();
    }

    private boolean gameValidator(String[] inputNumber) {

        List<Integer> inputNumberList = new ArrayList<>();

        //숫자 gameFew 만큼 써놨는지 확인
        if (inputNumber.length != gameFew) {
            return true;
        }

        //숫자만 입력했는지 확인
        for (String number : inputNumber) {
            try {
                inputNumberList.add(Integer.parseInt(number));
            } catch (NumberFormatException e) {
                return true;
            }
        }

        //숫자에 0이 있는지 확인
        if (inputNumberList.contains(0)) return true;

        //똑같지 않은 숫자를 입력했는지 확인
        for (int i = 0; i < inputNumberList.size(); i++) {
            for (int j = i + 1; j < inputNumberList.size(); j++) {
                if (inputNumberList.get(i).equals(inputNumberList.get(j))) {
                    return true; // 중복된 숫자가 입력됨
                }
            }
        }

        return false;
    }

    private List<String> randomNumberGenerator() {

        ArrayList<String> gameSuccessKey = new ArrayList<>(); //정답 배열
        gameSuccessKey.add(String.valueOf(Randoms.pickNumberInRange(1, 9))); //1번째는 겹치는것이 없기 때문에, 미리 값을 넣어 놨습니다.

        while (gameSuccessKey.size() < gameFew) {
            String randomKey = String.valueOf(Randoms.pickNumberInRange(1, 9));

            if (!gameSuccessKey.contains(randomKey)) {
                gameSuccessKey.add(randomKey);
            }

        }

        return gameSuccessKey;
    }

    private void gameOutput(int strike, int ball) {

        //볼, 스트라이크에 따른 출력
        if (strike != 0 && ball != 0) {
            System.out.println(ball + "볼 " + strike + "스트라이크");
        } else if (strike != 0 && ball == 0) {
            System.out.println(strike + "스트라이크");
        } else if (strike == 0 && ball != 0) {
            System.out.println(ball + "볼 ");
        } else {
            System.out.println("낫싱");
        }

    }

}
