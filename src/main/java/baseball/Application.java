package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public void computerSet() {
        List<Integer> computer = new ArrayList<>();

        System.out.println("숫자 야구 게임을 시작합니다.");
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);

            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
            if (computer.size() == 3) {
                System.out.println(computer);
            }
        }
    }

    public void game() {
        while (true) {
            int[] insertNum;
            int j;/*
            System.out.println(computer.size() + "랜덤 컴퓨터 길이");*/
            int ball = 0;
            int strike = 0;

            System.out.println("숫자를 입력해주세요");
            String insertStringNum = Console.readLine();

            insertNum = new int[insertStringNum.length()];

            //z는
            for (int z = 0; z < 3; z++) {
                insertNum[z] = insertStringNum.charAt(z) - '0';
            }
            /*
            System.out.println(insertNum[0] + " 첫 입력값");
            System.out.println(insertNum[1] + " 두번째 입력값");
            System.out.println(insertNum[2] + " 세번째 입력값");
            System.out.println(insertNum.length + " 입력값 길이");*/

            if (insertNum.length != 3) {
                throw new IllegalArgumentException();
            }


            if (insertNum[0] == insertNum[1] || insertNum[0] == insertNum[2]) {
                    /*    System.out.println(insertNum[0] + "첫번째 입력받은 값 입니다");
                        System.out.println(insertNum[1] + "두번째 입력받은 값 입니다.");
                        System.out.println(insertNum[2] + " 세번째 입력값");*/
                throw new IllegalArgumentException();
            }


            // i는 컴퓨터랜덤값만큼 (3번) 돈다 -> 게임의 목적이 컴퓨터의 랜덤값 3자리를 전부 맞추는거니까 3번만 돎
            // 실질적인 게임 로직 스타트
            for (int i = 0; i < 3; i++) {
                for (int k = 0; k < insertNum.length; k++) {
                    if (computer.get(i) == insertNum[k] && i == k) {
                        strike++;
                    } else if (computer.get(i) == insertNum[k] && i != k) {
                        ball++;
                    }
                }

            }
            if (strike == 3) {
                System.out.println("3스트라이크" + "\n" + "3개의 숫자를 모두 맞히셧습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");

                int statusCode = Integer.parseInt(Console.readLine());
                if (statusCode == 1) {
                    continue;
                } else if (statusCode == 2) {
                    break;
                } else throw new IllegalArgumentException();


            } else if (ball != 0 && strike != 0) {
                System.out.println(ball + "볼 " + strike + "스트라이크");
            } else if (ball == 0 && strike != 0) {
                System.out.println(strike + "스트라이크");
            } else if (ball != 0) {
                System.out.println(ball + "볼");
            } else {
                System.out.println("낫싱");
            }
        }

    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현


    }
}


