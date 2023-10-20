package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // 컴퓨터의 랜덤 숫자 만들기
        RandomNumbers computer = new RandomNumbers();
        computer.setRandomNumbers();

        // 사용자 입력 받기
        System.out.print("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        if (input.length() != 3) {
            throw new IllegalArgumentException("입력 값 오류");
        }

        // 입력값 랜던값 비교하기
        int strikeCnt = 0;
        int ballCnt = 0;
        String[] inputArr = input.split("");
        for (int i = 0; i < 3; i++) {
            if (computer.getNumber(i) == Integer.parseInt(inputArr[i])) {
                strikeCnt++;
            } else if (computer.contains(Integer.parseInt(inputArr[i]))) {
                ballCnt++;
            }
        }

        // 출력
        if (strikeCnt + ballCnt == 0) {
            System.out.println("낫싱");
        } else if (strikeCnt == 0) {
            System.out.println(ballCnt + "볼 ");
        } else if (ballCnt == 0) {
            System.out.println(strikeCnt + "스트라이크");
        } else {
            System.out.println(ballCnt + "볼 " + strikeCnt + "스트라이크");
        }
    }

}
