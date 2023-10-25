package baseball;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;

public class Application {
    static Scanner sc = new Scanner(System.in);
    static int num, first, second, third, myFirst, mySecond, myThird,ball,strike;
    public static void main(String[] args) {
        System.out.print("숫자 야구 게임을 시작합니다.");
        while(true) {
            myFirst = Randoms.pickNumberInRange(1, 9);
            mySecond = Randoms.pickNumberInRange(1, 9);
            myThird = Randoms.pickNumberInRange(1, 9);

            while (true) {
                ball = 0;
                strike = 0;
                System.out.print("숫자를 입력해주세요 : ");
                num = sc.nextInt();
                first = num / 100;
                second = (num / 10) % 10;
                third = num % 10;

                if (myFirst == first) {
                    strike++;
                }
                if (mySecond == second) {
                    strike++;
                }
                if (myThird == third) {
                    strike++;
                }
                if (first == mySecond) {
                    ball++;
                }
                if (first == myThird) {
                    ball++;
                }
                if (second == myFirst) {
                    ball++;
                }
                if (second == myThird) {
                    ball++;
                }
                if (third == myFirst) {
                    ball++;
                }
                if (third == mySecond) {
                    ball++;
                }
                if (strike == 3) {
                    System.out.print("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                    break;
                } else {
                    if (strike == 0 && ball == 0) {
                        System.out.print("낫싱");
                    } else if (strike == 0) {
                        System.out.print(ball + "볼");
                    } else if (ball == 0) {
                        System.out.print(strike + "스트라이크");
                    } else {
                        System.out.print(ball + "볼 " + strike + "스트라이크");
                    }
                }
            }
            System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            num=sc.nextInt();
            if(num==2){
                System.exit(0);
            }
        }
    }
}
