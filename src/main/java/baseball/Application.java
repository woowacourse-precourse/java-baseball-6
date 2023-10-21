package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
public class Application {
    public static void main(String[] args) {
        // 시작 메시지 출력
        System.out.println("숫자 야구 게임을 시작합니다.");
        
        int userChoice = 1;
        while (userChoice == 1) {
            // 상대의 숫자 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randNum = Randoms.pickNumberInRange(1, 9);
                // 생성된 수가 중복되지 않도록 조건 추가
                if(!computer.contains(randNum)){
                    computer.add(randNum);
                }
            }

            while (true) {
                // 사용자 숫자 입력
                System.out.print("숫자를 입력해주세요 : ");
                String userNum = Console.readLine();

                // 예외1. 사용자 숫자가 3자리가 아닐때
                if (userNum.length() != 3) {
                    throw new IllegalArgumentException();
                }
                
                List<Integer> userGuess = new ArrayList<>();
                userGuess.add(Integer.parseInt(userNum.substring(0, 1)));
                userGuess.add(Integer.parseInt(userNum.substring(1, 2)));
                userGuess.add(Integer.parseInt(userNum.substring(2, 3)));

                // 예외2. 사용자 숫자 중복 검사
                if (userGuess.get(0) == userGuess.get(1) || userGuess.get(1) == userGuess.get(2) || userGuess.get(0) == userGuess.get(2)) {
                    throw new IllegalArgumentException();
                }

                int strike = 0;
                int ball = 0;

                // 스트라이크와 볼 카운트 측정
                for (int i = 0; i < 3; i++) {
                    if (userGuess.get(i) == computer.get(i)) {
                        strike++;
                    } else {
                        for (int j = 0; j < 3; j++) {
                            if (i != j && userGuess.get(i) == computer.get(j)) {
                                ball++;
                            }
                        }
                    }
                }

                // 측정 결과에 따라서 출력
                if (strike == 0 && ball == 0) {
                    System.out.println("낫싱");
                } else if (strike == 0 && ball != 0) {
                    System.out.println(ball + "볼");
                } else if (strike != 0 && ball == 0 && strike != 3) {
                    System.out.println(strike + "스트라이크");
                } else if (strike != 3) {
                    System.out.println(ball + "볼 " + strike + "스트라이크");
                } else if (strike == 3) {
                    System.out.println(strike + "스트라이크");
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                }
            }

            // 모든 숫자를 맞춘 뒤 게임 재시작 여부
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            userChoice = Integer.parseInt(Console.readLine());
            
            // 예외3. 재시작 여부 입력이 잘못된 경우
            if (userChoice != 1 && userChoice != 2) {
                throw new IllegalArgumentException();
            }
        }
    }
}