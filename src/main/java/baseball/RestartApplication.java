package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RestartApplication {
    public static void main(String[] args) {

        int[] pickedNumber = new int[3];
        int[] userNumbers = new int[3];
        int index = 0;
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
            if (!isDuplicate) {
                pickedNumber[index++] = randomNumber;
            }
        }
        for (int i1 : pickedNumber) {
            System.out.println("i1 = " + i1);
        }

        //2. 출력문구성

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();


//            - 3개의 입력이 들어왔는가?
            if (userInput.length() != 3) {
                throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
            }
            String[] userInputChars = userInput.split("");

            try {
                //int 배열로 변환
                for (int i = 0; i < 3; i++) {
                    userNumbers[i] = Integer.parseInt(userInputChars[i]);
                    //1~9까지의 범위를 지키는가?
                    if (userNumbers[i] == 0){
                        throw new IllegalArgumentException("1~9까지의 숫자를 입력하세요.");
                    }
                }
            } catch (NumberFormatException ex) {
                // 숫자들로만 구성되어 있는가?
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }
//             - 서로 다른 숫자들로만 구성되어 있는가?
            for(int i=0; i<3; i++){
                for(int j=i+1; j<3; j++){
                    if(userNumbers[i] == userNumbers[j]){
                        throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
                    }
                }
            }


        }


    }
}
