package baseball.core;

import java.util.List;

public class Core {
    public int countStrike(List<Integer> computerNumbers, List<Integer> playerNumbers) {
        System.out.println("스트라이크 확인 합시다!!");
        int size = playerNumbers.size();
        int count = 0;
        for (int index = 0; index < size; index++) {
            if (isStrike(computerNumbers, playerNumbers, index)) {
                count++;
            }
        }
        return count;
    }

    private boolean isStrike(List<Integer> computerNumbers, List<Integer> playerNumbers, int index) {
        return computerNumbers.get(index).equals(playerNumbers.get(index));
    }
}
