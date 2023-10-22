package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Computer {
    public Computer() {}


    // computer randomNumber List
    public List<Integer> getRandomNumber() {
        List<Integer> randomNumberList = new ArrayList<>();

        while (randomNumberList.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!randomNumberList.contains(randomNumber)) {
                randomNumberList.add(randomNumber);
            }
        }
        return randomNumberList;
    }

    public String compareNumber(List computer, List player) {
        int ballCount = 0, strikeCount = 0;
        if (computer.containsAll(player)) { // 포함 숫자 3개 맞힐 때
            for (int i = 0; i < computer.size(); i++) {
                if (computer.get(i) == player.get(i)) { // 스트라이크 여부
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        } else { // 포함 숫자 2 ~ 0개 맞힐 때
            for (int i = 0; i < player.size(); i++) {
                if (computer.contains(player.get(i))) { // 위치 비교
                    ballCount++;
                    if (computer.get(i) == player.get(i)) {
                        ballCount--;
                        strikeCount++;
                    }
                }
            }
            if (ballCount == 0 && strikeCount == 0) {
                return "낫싱";
            }
        }
        if (ballCount == 0) {
            return strikeCount + "스트라이크";
        } else if (strikeCount == 0) {
            return ballCount + "볼";
        } else {
            return ballCount + "볼" + " " + strikeCount + "스트라이크";
        }
    }
}
