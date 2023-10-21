package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class NumbersBaseball {
    private int[] answer = new int[3];
    int[] visited;

    public NumbersBaseball() {
    }

    public void start() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        play();
    }

    private void play() {
        BaseballInfo baseballInfo = new BaseballInfo(0, 0);
        generateAnswer();
        while (!baseballInfo.isThreeStrike()) {
            System.out.print("숫자를 입력해주세요 : ");
            String input = Console.readLine();
            validateInput(input);
            baseballInfo = getCompareResultWith(convertToIntArr(input));
            System.out.println(baseballInfo);
            if (baseballInfo.isThreeStrike()) {
                finish();
                return;
            }
        }
    }

    public void finish() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String input = Console.readLine();
        if (input.equals("1")) {
            play();
        }
    }

    private int[] convertToIntArr(String input) {
        int[] inputArr = new int[3];
        for (int i = 0; i < 3; i++) {
            inputArr[i] = Integer.parseInt(input.charAt(i) + "");
        }
        return inputArr;
    }

    private BaseballInfo getCompareResultWith(int[] input) {
        BaseballInfo baseballInfo = new BaseballInfo(0, 0);
        for (int i = 0; i < 3; i++) {
            if (answer[i] == input[i]) {
                baseballInfo.addStrike();
            }
            if (!(answer[i] == input[i]) && answer[input[i]] == 1) {
                baseballInfo.addball();
            }
        }
        return baseballInfo;
    }

    private void generateAnswer() {
        visited = new int[10];
        int randomNum;
        for (int i = 0; i < 3; i++) {
            randomNum = Randoms.pickNumberInRange(1, 9);
            while (visited[randomNum] == 1) {
                randomNum = Randoms.pickNumberInRange(1, 9);
            }
            visited[randomNum] = 1;
            answer[i] = randomNum;
        }
    }

    private boolean validateInput(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력값은 3자리여야 합니다.");
        }
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
        return true;
    }
}
