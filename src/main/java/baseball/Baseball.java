package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Baseball {

    //전체 게임 플레이
    public void play() {
        do {
            playOneGame();
        } while (doRestartOrNot());
    }

    //한 게임 플레이
    private void playOneGame() {
        int answer = generateRandomNum();

        while(true) {
            int input = getUserInput();
            boolean isCorrect = getResult(input);

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
            result += numList.get(i) * (Math.pow(10, i));
        }

        return result;
    }

    //플레이어 입력 받기
    private int getUserInput() {
        int inputNum = 0;
        try {
            inputNum = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 input type입니다.");
        }

        if (inputNum < 100 && inputNum >= 1000) {
            throw new IllegalArgumentException("세자리 수를 입력해주세요.");
        }

        int hundred = inputNum / 100;
        int ten = (inputNum % 100) / 10;
        int one = inputNum % 10;

        if(hundred == ten || ten == one || one == hundred) {
            throw new IllegalArgumentException("서로 다른 세자리 수를 입력해주세요.");
        }

        return inputNum;
    }

    //입력에 대한 결과 출력
    private boolean getResult(int input) {
        return true;
    }

    //게임 재시작 여부 처리
    private boolean doRestartOrNot() {
        return false;
    }
}
