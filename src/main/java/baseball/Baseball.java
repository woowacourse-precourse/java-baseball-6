package baseball;

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
        return 0;
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
