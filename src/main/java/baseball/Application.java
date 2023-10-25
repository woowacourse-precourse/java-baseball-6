package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

    public static void main(String[] args) {
        int[] computerNumbers = new int[3];
        int[] userNumbers = new int[3];
        int strikes, balls;
        int choice;

        do {
            // 컴퓨터가 3개의 서로 다른 숫자 선택
            for (int i = 0; i < 3; i++) {
                int num;
                do {
                    num = Randoms.pickNumberInRange(1, 9);
                } while (computerNumbers[0] == computerNumbers[1] || computerNumbers[0] == computerNumbers[2] || computerNumbers[1] == computerNumbers[2]);
                computerNumbers[i] = num;
            }
         

            System.out.println("숫자 야구 게임을 시작합니다.");

            do {
                strikes = 0;
                balls = 0;
                System.out.print("숫자를 입력해주세요 : ");
                
               String userInput = Console.readLine();
               char digit1 = userInput.charAt(0); 
               char digit2 = userInput.charAt(1); 
               char digit3 = userInput.charAt(2); 
               userNumbers[0] = digit1 - '0';
               userNumbers[1] = digit2 - '0';
               userNumbers[2] = digit3 - '0';
               
               if (userInput.length() != 3) {
                throw new IllegalArgumentException("잘못된 입력! 1에서 9 사이의 중복되지 않는 숫자를 입력하세요.");
            }


                    for (int i = 0; i < 3; i++) {
                      
                            //userNumbers[i] = Integer.parseInt(Console.readLine( ));
                            if (userNumbers[i] < 1 || userNumbers[i] > 9 ) {
                              throw new IllegalArgumentException("잘못된 입력! 1에서 9 사이의 중복되지 않는 숫자를 입력하세요.");
                            }
                      
                    }
                    if (userNumbers[0] == userNumbers[1] || userNumbers[0] == userNumbers[2] || userNumbers[1] == userNumbers[2]) {  //중복된 숫자가 있는지 확인
                       throw new IllegalArgumentException("잘못된 입력! 1에서 9 사이의 중복되지 않는 숫자를 입력하세요.");
                     }
                   // break;
                    //}

                // 스트라이크와 볼 계산
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (userNumbers[i] == computerNumbers[j]) {
                            if (i == j) {
                                strikes++;
                            } else {
                                balls++;
                            }
                        }
                    }
                }

                // 결과 출력
                if (strikes == 3) {
                    System.out.println("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else if (strikes > 0 && balls > 0) {
                    System.out.println(balls + "볼 " + strikes + "스트라이크");
                } else if (strikes > 0) {
                    System.out.println(strikes + "스트라이크");
                } else if (balls > 0) {
                    System.out.println(balls + "볼");
                } else {
                    System.out.println("낫싱");
                }
            } while (true);

            System.out.print("게임을 다시 시작하려면 1을, 종료하려면 2를 입력하세요: ");
            choice = Integer.parseInt(Console.readLine());
        } while (choice == 1);
    }
}