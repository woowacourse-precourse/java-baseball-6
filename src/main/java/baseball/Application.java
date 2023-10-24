package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {

        boolean game_flag = false;          // 게임 진행 여부
        int randomNumber;                   // 컴퓨터의 랜덤 숫자

        System.out.println("숫자 야구 게임을 시작합니다.");

        while (!game_flag) {

            // pickNumberInRange(int startInclusive, int endInclusive)
            randomNumber = Randoms.pickNumberInRange(100, 999);
            System.out.println(randomNumber);

            // 게임 시작
            start(randomNumber);

            // 게임 종료
            game_flag = end();

        }
    } // main

    private static void start(int randomNumber) {

        int userNumber;

        while (true) {

            System.out.print("숫자를 입력해주세요 : ");

            // 숫자 입력
            try {
                userNumber = Integer.parseInt(Console.readLine());
            } catch(Exception e) {
                throw new IllegalArgumentException();
            }

            // 입력된 숫자에 대한 결과
            if (userNumber == randomNumber)
                return;
        }
    } // start

    private static boolean end() {

        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

        int check = Integer.parseInt(Console.readLine());

        if (check == 1) return false;
        else if (check == 2) return true;
        else throw new IllegalArgumentException();
    } // end
}
