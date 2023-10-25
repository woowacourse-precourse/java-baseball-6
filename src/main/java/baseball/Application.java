package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;


public class Application {
    public static void main(String[] args) {
        boolean isGameStart = true;
        
        System.out.println("숫자 야구 게임을 시작합니다.");

        while (isGameStart) {
            int strike = 0;
            int ball = 0;


            //컴퓨터가 랜덤하게 숫자를 고른다.
            int[] comNumber = new int[3];
            for (int i = 0; i < 3; i++) {
                comNumber[i] = Randoms.pickNumberInRange(1, 9);
            }
            System.out.println();


            //사용자로부터 수를 입력받는다.
            while (strike != 3) {

                strike = 0; // 새로운 수를 위해 0으로 초기화
                ball = 0;

                System.out.print("숫자를 입력해주세요 : ");
                
                int[] userNumber = new int[3]; 
                int k = 0;

                String input;
                input = Console.readLine(); //사용자 넘버 입력받기
                    
                if (input.length() != 3) { // 3자리 입력이 아닐 경우 게임 종료
                    throw new IllegalArgumentException("3자리 숫자를 입력하세요."); 
                }

                for (String s : input.split("")) {
                    userNumber[k] = Integer.parseInt(s);
                    k++;
                }
                
                for (int i = 0; i < 3; i++) {
                    if (userNumber[i] == 0) { // 0이 입력된 경우
                        throw new IllegalArgumentException("1~9 사이 숫자를 입력하세요.");
                    }
                    for (int j = i+1; j < 3; j++) {
                        if (userNumber[i] == userNumber[j]) { // 같은 숫자가 있을 경우 게임 종료
                            throw new IllegalArgumentException("같은 숫자를 입력하지 마세요.");
                        }
                    }
                }
                
                //스트라이크, 볼, 낫싱 판별
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (i == j && comNumber[i] == userNumber[j]) {
                            strike++;
                        }
                        else if (i != j && comNumber[i] == userNumber[j]) {
                            ball++;
                        }
                    }
                }

                if (strike > 0 && ball > 0) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                }
                else if (strike > 0 && ball == 0) {
                    System.out.println(strike + "스트라이크");
                }
                else if (strike == 0 && ball > 0) {
                    System.out.println(ball + "볼");
                }
                else {
                    System.out.println("낫싱");
                }

                //게임이 끝나면 재시작 할지 물어본다.
                if (strike == 3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    
                    String replay = Console.readLine();
                    int replayNum = Integer.parseInt(replay);
                        
                    if (replayNum == 1) isGameStart = true;
                    else if (replayNum == 2) isGameStart = false;
                    //1,2가 아닌 다른 수 입력하면 게임 종료
                    else { throw new IllegalArgumentException("잘못된 입력값입니다."); } 
                }
            }
        }
    }
}
