package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        boolean state = true;
        int[] computerNum = makeRandom();
        int[] strikeBallNums = {1,2,3};

        System.out.println("숫자 야구 게임을 시작합니다.");
        System.out.println(Arrays.toString(computerNum));
        System.out.println(printResult(checkNumbers(computerNum,strikeBallNums)));
    }

    public static int[] makeRandom() {
        int[] numbers = new int[3];
        int index = 0;
        while(index < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
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

    public static String printResult (int[] checkNumbers) {
        String result = "";
        if(checkNumbers[0] != 0 && checkNumbers[1] != 0) {
            result = checkNumbers[1]+"볼 " + checkNumbers[0]+"스트라이크\n";
        } else if (checkNumbers[0] != 0 && checkNumbers[1] == 0) {
            result = checkNumbers[0]+"볼\n";
        } else if (checkNumbers[0] == 0 && checkNumbers[1] != 0) {
            result = checkNumbers[1]+"스트라이크\n";
        } else {
            result = "낫싱\n";
        }
        if(checkNumbers[0] == 3) {
            result+="3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
        }
        return result;
    }

}