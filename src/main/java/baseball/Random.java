package baseball;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Random {
    public int[] number = new int[3];

    public Random() {}
    public int[] createNumber() {
        for(int i = 0; i < 3; i++) {
            while (true) {
                int temp = pickNumberInRange(1, 9);
                // 요구 사항처럼 camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 사용하여 랜덤한 숫자를 생성
                boolean check = false;
                for (int j = 0; j < i; j++) {
                    if (temp == number[j]) {
                        check = true;
                        break;
                    }
                    // 만약 지금까지 생성한 숫자들 중 겹치는 것이 있으면 check를 true로 변경하여 계속 랜덤한 숫자 생성함.
                }
                if (!check) {
                    number[i] = temp;
                    break;
                } // 겹치는 숫자가 없으면 number라는 객체에 데이터를 넣고 다음 숫자를 뽑기 위해 for문으로 돌아감.
            }
        }
        return number;
    }
}
