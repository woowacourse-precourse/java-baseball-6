package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import baseball.domain.User;
public class Application {
    public static final int NUMBER_LENGTH = 3;
    public static final String STRIKE = "스트라이크";
    public static final String BALL = "볼";
    public static final String NOTHING = "낫싱";
    public static void main(String[] args) {
        int exit = 1;
        while (exit == 1) { // 외부 while문 시작
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 1부터 9까지 서로 다른 세 자리의 수 생성 (컴퓨터)
            List<Integer> computerNum = new ArrayList<>();
            computer.generateComputerNum(computerNum, NUMBER_LENGTH);

            int strike = 0;
            int ball = 0;

            while (strike < 3) { // 내부 while문 시작

                ArrayList<Integer> userNumArray = user.inputUserGuess(NUMBER_LENGTH);

                // 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 낫싱
                strike = 0;
                ball = 0;

                for (int i = 0; i < userNumArray.size(); i++) {
                    if (userNumArray.get(i) == computerNum.get(i)) {
                        userNumArray.set(i, 0);
                        strike++;
                    }
                }

                for (int i : userNumArray) {
                    if (computer.contains(i)) {
                        ball++;
                    }
                }

                // 같은 수가 같은 자리에 있으면 스트라이크++, 값 0으로 바꾸기. 같은 수가 다른 자리에 있으면 볼++, 스트링 추가. 둘 다 0이면 낫싱.
                String output = "";
                if (ball > 0) {
                    output += String.format("%d%s", ball, BALL);
                }
                if (strike > 0) {
                    if (ball > 0) {
                        output += " ";
                    }
                    output += String.format("%d%s", strike, STRIKE);
                }
                if ((ball == 0) && (strike == 0)) {
                    output += String.format("%s", NOTHING);
                }
                System.out.println(computerNum);
                System.out.println(output);
            } // 내부 while문 끝
            // 3개의 숫자를 모두 맞히면 종료, 다시 시작하거나 완전히 종료
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            exit = Integer.parseInt(Console.readLine());
        } // 외부 while문 끝
    }
}
