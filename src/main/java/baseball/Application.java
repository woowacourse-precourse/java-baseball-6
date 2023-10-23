package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        try {
            boolean isEnd = true;
            BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("숫자 야구 게임을 시작합니다.");

            while(isEnd) {
                List<Integer> computer = randomComputerNumber();
                boolean isStrike = false;
                System.out.println("computer = " + computer);

                while(!isStrike) {
                    System.out.print("숫자를 입력해주세요 : ");
                    String str = bf.readLine();

                    if(str.length() != 3) {
                        throw new IllegalArgumentException("3자리 숫자를 입력해주세요.");
                    }

                    String result = checkNumber(computer, str);
                    if(result.equals("3스트라이크")) {
                        isStrike = true;
                    }
                }

                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.print("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요: ");

                int input = Integer.parseInt(bf.readLine());
                isEnd = input == 1;
            }

        } catch (IOException e) {
            System.out.println("Error: " + e);
        }
    } // main

    // 컴퓨터 입력(상대방)
    public static List<Integer> randomComputerNumber() {
        List<Integer> computer = new ArrayList<>();

        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

    // 사용자 숫자, 컴퓨터 입력값 일치 체크
    public static String checkNumber(List<Integer> computer, String str) {
        String[] srr  = str.split("");
        String result = "";
        int strike = 0;
        int ball = 0;

        for(int i=0; i<srr.length; i++) {
            int num = Integer.parseInt(srr[i]);
            int computerNum = computer.get(i);

            if(num == computerNum) {
                strike++;
            } else if(computer.contains(num)) {
                ball++;
            }
        }

        if(strike == 0 && ball == 0) {
            result = "낫싱";
            System.out.println("1 result = " + result);
            return result;
        }
        if(strike == 0) {
            result = "볼";
            System.out.println("2 result = " + ball + result);
            return ball + result;
        }
        if(ball == 0) {
            result = "스트라이크";
            System.out.println("3 result = " + strike + result);
            return strike + result;
        }
        System.out.println(ball + "볼 " + strike + "스트라이크");
        return ball + " 볼 " + strike + "스트라이크";
    }

} // class
