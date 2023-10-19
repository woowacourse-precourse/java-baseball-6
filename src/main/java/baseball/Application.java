package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.Arrays;

public class Application {
    static boolean checkContains(int[] arr, int inputNum) {
        for (int n : arr) {
            if (n == inputNum) return true;
        }
        return false;
    }

    static int[] strToArr(String str) {
        int[] resultArr = new int[str.length()];

        if(str.length() > 3) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i<str.length(); i++){
            resultArr[i] = str.toCharArray()[i] - '0';
            if (resultArr[i] == 0 && resultArr[i] > 9) {
                throw new IllegalArgumentException();
            }
        }

        return resultArr;
    }

    static int[] generateComNums() {
        int[] comNums = new int[3];
        for (int i = 0; i<3; i++) {
            int randomNum;
            do {
                randomNum = Randoms.pickNumberInRange(1, 9);
            }while(checkContains(comNums, randomNum));
            comNums[i] = randomNum;
        }
        return comNums;
    }

    public static void main(String[] args) {
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean onPlaying = true;

        while(onPlaying) {
            // 컴퓨터 숫자 초기화
            int[] comNums = generateComNums();

//            System.out.println(Arrays.toString(comNums));
            boolean onPlaying2 = true;

            while(onPlaying2) {
                System.out.print("숫자를 입력해주세요 : ");
                String temp = Console.readLine();

                int[] inputArr = strToArr(temp);

                int strike = 0;
                int ball = 0;

                for (int i = 0; i < comNums.length; i++) {
                    if(comNums[i] == inputArr[i]) {
                        strike++;
                    }else if (checkContains(comNums, inputArr[i])) {
                        ball++;
                    }
                }

                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    int inputStr = Integer.parseInt(Console.readLine());
                    if (inputStr == 1) {
                        onPlaying = true;
                    }else if (inputStr == 2) {
                        onPlaying = false;
                    }else {
                        throw new IllegalArgumentException();
                    }
                    onPlaying2 = false;
                }else if ((strike > 0 && strike < 3) || (ball > 0 && ball <= 3)){
                    System.out.println((strike > 0? strike + "스트라이크" : "") + (ball > 0 ? ball + "볼" : ""));
                }else {
                    System.out.println("낫싱");
                }
            }
        }
    }
}
