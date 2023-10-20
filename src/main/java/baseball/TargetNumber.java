package baseball;

import camp.nextstep.edu.missionutils.Randoms;

class TargetNumber {
    private int[] number = new int[3];

    private TargetNumber() {
        number = this.getRandomNumber();
    }
    private TargetNumber(int a, int b, int c) {
        this.number[0] = a;
        this.number[1] = b;
        this.number[2] = c;
    }
    /*
    TargetNumber 객체를 생성하는 정적 팩토리 메서드.
     */
    public static TargetNumber generate(int a, int b, int c) {
        if (isValidNumber(a) && isValidNumber(b) && isValidNumber(c)) return new TargetNumber(a, b, c);
        return new TargetNumber();
    }

    /*
    TargetNumber 객체가
    특정 숫자 num을 특정 위치 idx에 갖고 있는지 물어보는 메서드.
    반환 값은 길이가 2인 boolean 타입 배열이다.
    0 번째 원소는 숫자가 있는지 여부를 말하고,
    1 번째 원소는 숫자가 있다면 위치도 맞는지 여부를 말한다.
     */
    public boolean[] has(int num, int idx) {
        boolean[] check = new boolean[2];

        if (!isValidNumber(num) || !isValidIndex(idx)) return check;

        for (int i = 0; i < 3; i++) {
            if (number[i] == num) {
                if (i == idx) check[1] = true;
                check[0] = true;
                break;
            }
        }
        return check;
    }

    public int[] getRandomNumber() {
        boolean[] duplicationCheck = new boolean[10];
        int[] answer = new int[3];
        for (int i = 0; i < 3; i++) {
            int value = Randoms.pickNumberInRange(1, 9);
            while (duplicationCheck[value]) value = Randoms.pickNumberInRange(1, 9);
            duplicationCheck[value] = true;
            answer[i] = value;
        }
        return answer;
    }

    private static boolean isValidNumber(int i) {
        return i >= 1 && i <= 9;
    }

    private static boolean isValidIndex(int i) {
        return i >= 0 && i <= 2;
    }
}
