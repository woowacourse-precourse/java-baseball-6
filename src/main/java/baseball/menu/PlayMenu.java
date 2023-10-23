package baseball.menu;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static baseball.Constant.PlayGame.*;

public class PlayMenu {
    public void play() {
        List<Integer> randomNumber = createRanNum();
        while(true){
            boolean[] visited = new boolean[NUMBER_LENGTH];

            String inputNumber = readNumber();
            List<Integer> numbers = checkNumberException(inputNumber);
            int strike = checkStrike(randomNumber, numbers, visited);
            int ball = checkBall(randomNumber, numbers, visited);
            printAnswer(strike, ball);
            if(strike == NUMBER_LENGTH) return;
        }
    }

    // 랜덤 함수 생성
    private List<Integer> createRanNum() {
        List<Integer> ranList = new ArrayList<>();
        while (ranList.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!ranList.contains(randomNumber)) ranList.add(randomNumber);
        }
        return ranList;
    }

    // 숫자 입력
    private static String readNumber() {
        System.out.print(PLAY_START_MESSAGE);
        return Console.readLine();
    }

    // 숫자 에러 처리
    private static List<Integer> checkNumberException(String inputNumber) {
        // 숫자가 3자리가 아닌 경우
        if(inputNumber.length() != NUMBER_LENGTH) throw new IllegalArgumentException();
        List<Integer> numbers = new ArrayList<>();
        // 같은 값을 입력하거나 숫자가 아닌 값을 입력한 경우
        try{
            Arrays.stream(inputNumber.split(CROP_UNIT)).forEach(i -> {
                int num = Integer.parseInt(i);
                if (numbers.contains(num) || num == 0) throw new IllegalArgumentException();
                else numbers.add(num);
            });
        }catch (NumberFormatException e){ // 숫자가 아닌 다른 값을 입력한 경우
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    // 스트라이크 체크
    private int checkStrike(List<Integer> randomNumber, List<Integer> numbers, boolean[] visited) {
        int strike = 0;
        for (int i = 0; i< randomNumber.size(); i++){
            if (numbers.get(i).equals(randomNumber.get(i))) {
                strike++;
                visited[i] = true;
            }
        }
        return strike;
    }

    // 볼 체크
    private int checkBall(List<Integer> randomNumber, List<Integer> numbers, boolean[] visited) {
        int ball = 0;
        for (int i = 0; i < randomNumber.size(); i++){
            for (Integer num: numbers){
                // 입력 숫자 중에 랜덤 숫자를 포함하고 있으며, 이미 스트라이크로 check 되지 않은 경우
                if (Objects.equals(randomNumber.get(i), num) && !visited[i]) ball++;
            }
        }
        return ball;
    }

    // 결과값 출력
    private void printAnswer(int strike, int ball) {
        if(ball != 0) System.out.print(ball +BALL_STRING + BLANK);
        if(strike != 0) System.out.print(strike +STRIKE_STRING);
        if (strike == 0 && ball == 0)System.out.print(NOTHING_STRING);
        System.out.println();
    }
}
