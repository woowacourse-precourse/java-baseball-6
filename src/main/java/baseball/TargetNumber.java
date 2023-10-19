package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class TargetNumber {
    private int[] number = new int[3];

    private TargetNumber() {
        boolean[] duplicationCheck = new boolean[10];
        for (int i = 0; i < 3; i++) {
            int value = Randoms.pickNumberInRange(1, 9);
            while (duplicationCheck[value]) value = Randoms.pickNumberInRange(1, 9);
            duplicationCheck[value] = true;
            number[i] = value;
        }
    }
    /*
    TargetNumber 객체를 생성하는 정적 팩토리 메서드.
     */
    public static TargetNumber generate() { return new TargetNumber(); }

    /*
    TargetNumber 객체가
    특정 숫자 num을 특정 위치 idx에 갖고 있는지 물어보는 메서드.
    반환 값은 길이가 2인 boolean 타입 배열이다.
    0 번째 원소는 숫자가 있는지 여부를 말하고,
    1 번째 원소는 숫자가 있다면 위치도 맞는지 여부를 말한다.
     */
    public boolean[] has(int num, int idx) {
        boolean[] check = new boolean[2];
        for (int i = 0; i < 3; i++) {
            if (number[i] == num) {
                if (i == idx) check[1] = true;
                check[0] = true;
                break;
            }
        }
        return check;
    }
}
