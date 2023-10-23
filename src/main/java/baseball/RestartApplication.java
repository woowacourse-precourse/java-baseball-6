package baseball;

import camp.nextstep.edu.missionutils.Randoms;

public class RestartApplication {
    public static void main(String[] args) {

        int[] pickedNumber = new int[3];
        int index= 0;
        //1. 서로 다른 임의의 수 3개 선택

        while (index < 3) {
            boolean isDuplicate = false;
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            for (int i = 0; i <= index; i++) {
                if (pickedNumber[i] == randomNumber) {
                    isDuplicate = true;
                    break;
                }
            }
            if(!isDuplicate){
                pickedNumber[index++] = randomNumber;
            }
        }
        for (int i1 : pickedNumber) {
            System.out.println("i1 = " + i1);
        }

    }
}
