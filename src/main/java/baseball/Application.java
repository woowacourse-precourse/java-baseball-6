package baseball;


import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {
        // 게임 시작을 사용자에게 알린다.
        System.out.println("숫자 야구 게임을 시작합니다.");

        boolean playAgain = true;

        while(playAgain) {
            // 컴퓨터 숫자 랜덤 생성
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                    //System.out.println(randomNumber);
                }
            }

            int s=0, b=0;
            while(true) {
                if(s==3) {
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    s=0;
                    b=0;
                }
                List<Integer> user = new ArrayList<>();

                System.out.print("숫자를 입력해주세요 : ");
                BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
                String inputStr;
                try {
                    inputStr = input.readLine();
                } catch (IOException e) {
                    throw new IllegalArgumentException(e);
                }

                if(isNumber(inputStr)) {
                    int inputInt = Integer.parseInt(inputStr);
                    if(inputInt >= 100 && inputInt <= 999) {
                        while (user.size() < 3) {
                            // 세 자리 수의 각 자리 숫자를 추출
                            int digit = inputInt % 10;
                            if(user.contains(digit)) throw new IllegalArgumentException();
                            user.add(0, digit);
                            inputInt /= 10;
                        }
                    } else throw new IllegalArgumentException();
                } else throw new IllegalArgumentException();


                // 컴퓨터의 수와 사용자의 수 비교
                for(int i=0;i<3;i++) {
                    if(computer.get(i) == user.get(i)) s+=1;
                    else if (computer.contains(user.get(i))) b+=1;
                }

                if(s==0 && b==0) System.out.println("낫싱");
                else if(s!=0 && b!=0) System.out.println(b+"볼 " +s+"스트라이크");
                else if(s!=0 && b==0) System.out.println(s+"스트라이크");
                else if(s==0 && b!=0) System.out.println(b+"볼");
                else System.out.println("낫싱");

            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));

            try {
                String inputStr = input.readLine();
                if (!inputStr.equals("1")) {
                    playAgain = false;
                }
            } catch (IOException e) {
                throw new IllegalArgumentException(e);
            }
        }


    }

    // 입력받은 값이 숫자인지 확인
    public static boolean isNumber(String str) {
        if(str == null) return false;
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
