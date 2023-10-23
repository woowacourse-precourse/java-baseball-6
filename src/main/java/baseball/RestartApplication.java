package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class RestartApplication {
    public static void main(String[] args) {

        int[] pickedNumber = new int[3];
        int[] userNumbers = new int[3];
        int index = 0;
        int strikeCount = 0;
        int ballCount = 0;
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
            ballCount = 0;
            strikeCount = 0;

            //3. 입력값 받기
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
                    if (userNumbers[i] == 0) {
                        throw new IllegalArgumentException("1~9까지의 숫자를 입력하세요.");
                    }
                }
            } catch (NumberFormatException ex) {
                // 숫자들로만 구성되어 있는가?
                throw new IllegalArgumentException("숫자만 입력하세요.");
            }
//             - 서로 다른 숫자들로만 구성되어 있는가?
            for (int i = 0; i < 3; i++) {
                for (int j = i + 1; j < 3; j++) {
                    if (userNumbers[i] == userNumbers[j]) {
                        throw new IllegalArgumentException("서로 다른 숫자를 입력하세요.");
                    }
                }
            }
//            4. 입력값을 제시된 규칙에 따라 출력시키기
//                    - 로직 구현 하기(볼, 스트라이크, 낫싱)
//            - 형식에 맞춰 출력문 구성

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if ((userNumbers[i] == pickedNumber[j]) && (i == j)) {
                        strikeCount++;
                    } else if (userNumbers[i] == pickedNumber[j]) {
                        ballCount++;
                    }
                }
            }
            if (ballCount != 0) {
                System.out.print(ballCount + "볼 ");
            }
            if (strikeCount != 0) {
                System.out.print(strikeCount + "스트라이크");
            }
            if ((ballCount + strikeCount) == 0) {
                System.out.print("낫싱");
            }
            System.out.println();
            //5. 게임이 종료된 후, 다시시작 & 종료 선택 기능 넣기
            if(strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                userInput = Console.readLine();

                //1개의 입력이 들어왔는가?
                if (userInput.length() != 1) {
                    throw new IllegalArgumentException("1개의 숫자를 입력하세요.");
                }

                //숫자들로만 구성되어 있는가?
                try{
                    int exitNumber= Integer.parseInt(userInput);
                    //            - 1~2까지의 범위를 지키는가?:
                    if((exitNumber != 1) && (exitNumber !=2)){
                        throw new IllegalArgumentException("1~2 숫자를 입력하세요.");
                    }
                    if(exitNumber ==1){
                        //다시 선택
                        index =0;
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
                    }
                    if(exitNumber == 2){
                       break;
                    }
                }catch (NumberFormatException ex){
                    throw new IllegalArgumentException("숫자를 입력하세요.");
                }
            }
        }
    }
}
