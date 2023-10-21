package baseball.util;

import java.util.Arrays;

public class Array {
    public static int[] makeRandom() {
        int[] numbers = new int[3];
        int index = 0;
        while(index < 3) {
            int randomNumber = camp.nextstep.edu.missionutils.Randoms.pickNumberInRange(1, 9);
            boolean isDuplicated = false;
            for(int i = 0; i < numbers.length; i++) {
                if(randomNumber == numbers[i]) {
                    isDuplicated = true;
                }
            }
            if(!isDuplicated) {
                numbers[index] = randomNumber;
                index++;
            }
        }
        return numbers;
    }

    public static int[] checkNumbers (int[] computerNum, int[] inputNum) {
        //resultArr[0] = 볼 수, resultArr[1] = 스트라이크 수
        int[] resultArr = new int[2];
        for(int i = 0; i < computerNum.length; i++) {
            for(int j = 0; j < inputNum.length; j++) {
                if(computerNum[i] == inputNum[j]) {
                    if(i == j) {
                        resultArr[1] += 1;
                    } else {
                        resultArr[0] += 1;
                    }
                }
            }
        }
        return resultArr;
    }

    public static int[] strToArr (String str) {
        int[] result = new int[str.length()];
        for(int i = 0; i < result.length; i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        return result;
    }
}
