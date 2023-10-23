package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        // 프로그램 구현

        // Start Game
        System.out.println("숫자 야구 게임을 시작합니다.");
        int flag = 1;

        // Generate Computer Number
        StringBuilder computerNumber = new StringBuilder();
        for(int i = 0; i < 3 ; i++) {
            computerNumber.append(Randoms.pickNumberInRange(1, 9));
        }

        while (flag == 1) {
            // System.out.println(computerNumber);

            System.out.print("숫자를 입력해주세요 : ");
            StringBuilder userNumber = new StringBuilder(Console.readLine());
            System.out.println(userNumber);

            // Compare User Number and Computer Baseball Number
            /* scoreBoard [0]: ball 수 저장
             *  scoreBoard [1]: strike 수 저장
             *  */
            int[] scoreBoard = {0, 0};

            for(int i = 0; i < 3 ; i++) {
                String userSubNum = userNumber.substring(i , i+1);
                if(computerNumber.indexOf(userSubNum) > -1) {
                    if(computerNumber.substring(i, i+1).equals(userSubNum)) {
                        scoreBoard[1]++;
                    } else {
                        scoreBoard[0]++;
                    }
                }
            }

            // Print Result
            if(scoreBoard[1] == 3) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

                // Re-game ?
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력해주세요.");
                flag = Integer.parseInt(Console.readLine());

                if(flag == 1) {
                    computerNumber = new StringBuilder();
                    for(int i = 0; i < 3 ; i++) {
                        computerNumber.append(Randoms.pickNumberInRange(1, 9));
                    }
                }
            } else if(scoreBoard[0] + scoreBoard[1] == 0) {
                System.out.println("낫싱");
            } else if(scoreBoard[0] > 0 && scoreBoard[1] > 0) {
                System.out.println(scoreBoard[0]+"볼 "+scoreBoard[1]+"스트라이크");
            } else if(scoreBoard[0] > 0) {
                System.out.println(scoreBoard[0]+"볼");
            } else {
                System.out.println(scoreBoard[1]+"스트라이크");
            }
        }
    }
}
