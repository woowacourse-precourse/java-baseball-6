package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Boolean isPlaying = Boolean.TRUE;

        while (isPlaying) {
            System.out.println("숫자 야구 게임을 시작합니다.");
            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }

            System.out.println("computer = " + computer);

            Boolean isCorrect = Boolean.FALSE;
            while (!isCorrect){
                int ball = 0;
                int strike = 0;

                System.out.print("숫자를 입력해주세요 : ");
                Scanner num = new Scanner(System.in);
                String str = num.next();
                System.out.println("str = " + str);
                for (int i = 0; i < 3; i++) {
                    int c = Integer.valueOf(str.charAt(i)) - 48;
                    System.out.println("c = " + c);
                    if (computer.contains(c)) {
                        if (computer.get(i) == c) {
                            //위치가 같으면
                            strike++;
                        }
                        //위치가 다르면
                        else ball++;
                    }
                }
                if (strike == 3) {
                    isCorrect = Boolean.TRUE;
                    System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                    Scanner num2 = new Scanner(System.in);
                    int isReplaying = Integer.parseInt(num2.next());
                    if (isReplaying == 2) isPlaying = Boolean.FALSE;
                }
                else if (ball > 0 && strike > 0) System.out.println(ball + "볼 " + strike +"스트라이크");
                else if (ball > 0) System.out.println(ball + "볼");
                else if (strike > 0) System.out.println(strike + "스트라이크");
                else System.out.println("낫싱");

            }

        }



    }
}
