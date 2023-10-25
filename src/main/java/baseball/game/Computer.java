package baseball.game;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Computer {

    public List<Integer> randomNums;
    public User user;

    public Computer(User user) {

        genNumbers();
        this.user = user;
    }

    public void genNumbers() {

        randomNums = new ArrayList<>();

        while (randomNums.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!randomNums.contains(randomNumber)) {
                randomNums.add(randomNumber);
            }
        }
    }

    public Map<String, Integer> compare(List<Integer> inputList) {

        Map<String, Integer> compareMap = new HashMap<>();

        compareMap.put("strikeCnt", 0);
        compareMap.put("ballCnt", 0);

        for (int i = 0; i < inputList.size(); i++) {

            if (randomNums.contains(inputList.get(i))) {
                if (randomNums.get(i) == inputList.get(i)) {
                    compareMap.replace("strikeCnt", compareMap.get("strikeCnt") + 1);
                } else {
                    compareMap.replace("ballCnt", compareMap.get("ballCnt") + 1);
                }
            }
        }

        return compareMap;
    }

    public boolean showResult(Map<String, Integer> compareMap) {

        Integer strikeCnt = compareMap.get("strikeCnt");
        Integer ballCnt = compareMap.get("ballCnt");

        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0 && ballCnt != 0) {
            System.out.printf("%d볼\n", ballCnt);
        } else if (strikeCnt != 0 && ballCnt == 0) {
            System.out.printf("%d스트라이크\n", strikeCnt);
        } else {
            System.out.printf("%d볼 %d스트라이크\n", ballCnt, strikeCnt);
        }

        if (strikeCnt == 3) {
            return true;
        }

        return false;
    }

    public boolean gameOver() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        String gameOverCode = user.getInput();

        if (gameOverCode.equals("1")) {
            genNumbers();
        } else if (gameOverCode.equals("2")) {
            return false;
        } else {
            throw new IllegalArgumentException("1이나 2만 입력해주세요");
        }

        return true;
    }

}
