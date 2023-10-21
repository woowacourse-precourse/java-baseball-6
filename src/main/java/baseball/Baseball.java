package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    //전체 게임 플레이
    public void play() {
        System.out.println("숫자 야구 게임을 시작합니다.");

        do {
            playOneGame();
        } while (doRestartOrNot());
    }

    //한 게임 플레이
    private void playOneGame() {
        int answer = generateRandomNum();

        while(true) {
            int input = getUserInput();
            boolean isCorrect = getResult(input, answer);

            if(isCorrect)
                break;
        }
    }

    //서로 다른 세자리 랜덤 수 생성
    private int generateRandomNum() {
        int result = 0;
        List<Integer> numList = new ArrayList<>();

        while (numList.size() < 3) {
            int randomNum = Randoms.pickNumberInRange(1, 9);
            if (!numList.contains(randomNum)) {
                numList.add(randomNum);
            }
        }

        for(int i = 0; i < 3; i++) {
            result += numList.get(i) * (Math.pow(10, 2 - i));
        }

        return result;
    }

    //플레이어 입력 받기
    private int getUserInput() {
        System.out.print("숫자를 입력해주세요 : ");
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 input type입니다.");
        }

        if (inputNum < 100 || inputNum >= 1000) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }

        List<Integer> inputDigitArr = getDigitList(inputNum);

        if(inputDigitArr.get(0) == inputDigitArr.get(1) || inputDigitArr.get(1) == inputDigitArr.get(2) || inputDigitArr.get(2) == inputDigitArr.get(0)) {
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        }

        return inputNum;
    }

    //입력에 대한 결과 출력
    private boolean getResult(int input, int answer) {
        int strikeCount = 0;
        int ballCount = 0;

        List<Integer> inputDigitArr = getDigitList(input);
        List<Integer> answerDigitArr = getDigitList(answer);

        for(int index = 0; index < 3; index++) {
            if (inputDigitArr.get(index) == answerDigitArr.get(index)) {
                strikeCount++;
            } else if (answerDigitArr.contains(inputDigitArr.get(index))) {
                ballCount++;
            }
        }

        if(strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return true;
        } else if (strikeCount == 0 && ballCount == 0) {
            System.out.println("낫싱");
        } else {
            if (ballCount != 0) {
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount != 0) {
                System.out.print(strikeCount + "스트라이크");
            }
            System.out.println("");
        }

        return false;
    }

    private List<Integer> getDigitList(int input) {
        List<Integer> result = new ArrayList<>();

        result.add(input / 100);
        result.add((input % 100) / 10);
        result.add(input % 10);

        return result;
    }

    //게임 재시작 여부 처리
    private boolean doRestartOrNot() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String inputStr = Console.readLine();

        switch (inputStr) {
            case "1":
                return true;
            case "2":
                return false;
            default:
                throw new IllegalArgumentException("잘못된 input입니다.");
        }
    }
}
