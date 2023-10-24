package baseball.Model;

import camp.nextstep.edu.missionutils.Randoms;

public class Computer {
    private int[] answer;
    private boolean[] pickedMap;

    public Computer() {
        makeAnswer();
    }

    private void makeAnswer() {
        // 정답에 선택 된 값의 상태 Map 
        pickedMap = new boolean[10];
        answer = new int[3];

        for(int i = 0; i < 10; ++i)
            pickedMap[i] = false;
        for(int i = 0; i < 3;) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!pickedMap[randomNumber]) {
                pickedMap[randomNumber] = true;
                answer[i++] = randomNumber;
            }
        }
    }

    public int[] getAnswer() {
        // 외부에서 변경 방지
        return answer.clone();
    }

    public boolean[] getPickedMap() {
        return pickedMap.clone();
    }
}
