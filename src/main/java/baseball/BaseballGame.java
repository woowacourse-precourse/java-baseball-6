package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {

    private final int gameLength;

    public BaseballGame(int gameLength) {
        this.gameLength = gameLength;
    }

    public boolean startGame() {

        List<String> gameSuccessNumbers = randomNumberGenerator(); //정답 배열
        System.out.println("숫자 야구 게임을 시작합니다.");

        //게임 시작
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String[] inputNumber = Console.readLine().split("");

            if (gameValidator(inputNumber)) {
                throw new IllegalArgumentException();
            }

            int strikes = 0;
            int balls = 0;

            for (int i = 0; i < gameLength; i++) {
                if (gameSuccessNumbers.get(i).equals(inputNumber[i])) {
                    strikes++;
                    continue;
                }
                if (gameSuccessNumbers.contains(inputNumber[i])) {
                    balls++;
                }
            }

            //정답
            if (strikes == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                String inputEnd = Console.readLine();
                return gameValidator(inputEnd);
            }

            //볼, 스트라이크에 따른 출력
            gameOutput(strikes, balls);

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

        //숫자 gameLength 만큼 써놨는지 확인
        if (inputNumber.length != gameLength) {
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

        while (gameSuccessKey.size() < gameLength) {
            String randomKey = String.valueOf(Randoms.pickNumberInRange(1, 9));

            if (!gameSuccessKey.contains(randomKey)) {
                gameSuccessKey.add(randomKey);
            }

        }

        return gameSuccessKey;
    }

    private void gameOutput(int strikes, int balls) {

        //볼, 스트라이크에 따른 출력
        if (strikes != 0 && balls != 0) {
            System.out.println(balls + "볼 " + strikes + "스트라이크");
        } else if (strikes != 0 && balls == 0) {
            System.out.println(strikes + "스트라이크");
        } else if (strikes == 0 && balls != 0) {
            System.out.println(balls + "볼 ");
        } else {
            System.out.println("낫싱");
        }

    }

}
