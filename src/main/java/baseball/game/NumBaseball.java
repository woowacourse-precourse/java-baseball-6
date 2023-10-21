package baseball.game;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class NumBaseball implements BaseballGame{
    @Override
    public ArrayList<Integer> comNum() {
        ArrayList<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int random = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(random)) {
                computer.add(random);
            }
        }
        return computer;
    }

    @Override
    public ArrayList<Integer> userInput() {
        ArrayList<Integer> user = new ArrayList<>();
        String input = Console.readLine();

        if (input.length() != 3) {
            exceptionClose();
        }
        for (int i = 0; i < input.length(); i++) {
            int num = Character.getNumericValue(input.charAt(i));
            if (num <= 0 || num > 9) { //getNumericValue는 숫자로 변환되지 않을 경우, 경우에 따라 -1 이나 2를 반환함
                exceptionClose();
            }
            if (!user.contains(num)) {
                user.add(num);
            } else { //입력값이 서로 다른 3자리 수가 아님
                exceptionClose();
            }
        }

        return user;
    }

    @Override
    public int userAnswer() {
        String answer = Console.readLine();

        if (!answer.equals("1") && !answer.equals("2")) {
            throw new IllegalArgumentException();
        }

        return Integer.parseInt(answer);
    }

    @Override
    public int[] result(ArrayList<Integer> comNum, ArrayList<Integer> userNum) {
        int ball = 0;
        int strike = 0;
        int nothing = 0;
        for (int num : userNum) {
            if (comNum.contains(num)) {
                if (comNum.indexOf(num) == userNum.indexOf(num)) {
                    strike++;
                } else {
                    ball++;
                }
            } else {
                nothing++;
            }
        }
        int[] result = {ball, strike, nothing};

        return result;
    }

    @Override
    public void printResult(int[] result) {
        int ball = result[0];
        int strike = result[1];
        int nothing = result[2];

        StringBuilder sb = new StringBuilder();
        if (nothing == 3) {
            sb.append("낫싱");
        } else {
            if(ball != 0) {
                sb.append(ball).append("볼 ");
            }
            if(strike != 0) {
                sb.append(strike).append("스트라이크");
                if(strike == 3) {
                    sb.append("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임으로 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                }
            }
        }
        System.out.println(sb);
    }

    @Override
    public void exceptionClose() {
        throw new IllegalArgumentException();
    }

}