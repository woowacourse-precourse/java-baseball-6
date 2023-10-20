package baseball;

// 기능 목록(숫자야구)
// #1. 사용자가 숫자를 입력한다.
//    - 이때 서로 다른 숫자이어야 하며 3자리 자릿수만 가능하다.
//    - 새로운 게임을 다시 할땐 1 또는 2만 입력되어야 한다.
//    - 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨후 종료시킨다
// #2. 컴퓨터의 수를 받는다.
//    - 서로 다른 숫자(1~9)를 3번 받는다.
//    - 새로운 게임이 시작되면 새로 번호를 부여받는다.
// #3. 판단(심판)
//    - 같은 자리, 같은 숫자 = 스트라이크
//    - 다른 자리, 같은 숫자 = 볼
//    - (다른 자리, 다른 숫자)*3 = 낫싱


import java.util.Scanner;

public class Application {
    public void checkUserInputException(int[] user) {
        try {
            if (!(user.length == 3))
                throw new IllegalArgumentException("올바르지 않은 숫자의 입력입니다. ");

            for (int i = 0; i < user.length; i++) {
                for (int j = 0; j < user.length; j++) {
                    if (i == j)
                        continue;
                    if (user[i] == user[j]) {
                        throw new IllegalArgumentException("올바르지 않은 숫자의 입력입니다. " + user[j]);
                    }
                }
            }
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException 발생: " + e.getMessage());
            return;
        }
    }

    public void checkUserRegameException(int num) {
        try {
            if (!(num == 1 || num == 2)) {
                throw new IllegalArgumentException("번호를 다시 확인해주세요: " + num);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("IllegalArgumentException 발생: " + e.getMessage());
            return;
        }
    }

    public int[] userInput() {
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        int[] userNumArray = new int[3];
        String userNumber = String.valueOf(userInput);

        for(int i =0; i<userNumber.length();i++){
            char userNum = userNumber.charAt(i);
            int userIntNum = Character.getNumericValue(userNum);
            userNumArray[i] = userIntNum;
        }
        checkUserInputException(userNumArray);
        return userNumArray;
    }


}
