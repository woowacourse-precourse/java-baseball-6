package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.InputMismatchException;
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
                int inputNum;
                try {
                    Scanner num = new Scanner(System.in);
                    inputNum = num.nextInt();
                } catch (InputMismatchException e) {
                    throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
                }

                int[] intArray = new int[3];
                for (int i = 2; i >= 0; i--) {
                    intArray[i] = inputNum % 10;
                    inputNum = inputNum / 10;
                }
                for (int i = 0; i < 3; i++) {

//                    System.out.println("c = " + intArray[i]);
                    if (computer.contains(intArray[i])) {
                        if (computer.get(i) == intArray[i]) {
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
