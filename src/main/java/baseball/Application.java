package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static baseball.Constant.PlayGame.*;
import static baseball.Constant.StartGame.*;

public class Application {
    public static void main(String[] args) {
        Application ap = new Application();
        ap.start();
    }

    // 초기 화면
    private void start() {
        String input = null;
        do {
            // 게임 시작
            System.out.println(GAME_START_MESSAGE);
            // 게임 함수로 이동
            play();
            // 재시작 or 종료
            System.out.println(RESTART_OR_QUIT_MESSAGE);
            input = Console.readLine();
            if(!input.equals(START_MENU) && !input.equals(END_MENU)) throw new IllegalArgumentException(); // 에러 확인
        }while(!input.equals(END_MENU));
    }

    // 야구 게임
    private void play() {
        List<Integer> randomNums = createRanNum();
        while(true){
            System.out.print(PLAY_START_MESSAGE);
            String num = Console.readLine();

            // 숫자가 3자리가 아닌 경우
            if(num.length() > NUMBER_LENGTH) throw new IllegalArgumentException();
            List<Integer> numbers = new ArrayList<>();
            // 같은 값을 입력하거나 숫자가 아닌 값을 입력한 경우
            try{
               Arrays.stream(num.split(CROP_UNIT)).forEach(i -> {
                   if (numbers.contains(Integer.parseInt(i))) throw new IllegalArgumentException();
                   else numbers.add(Integer.parseInt(i));
               });
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }

            boolean[] visited = new boolean[NUMBER_LENGTH];
            int strike = checkStrike(randomNums, numbers, visited);
            if(strike == NUMBER_LENGTH) {
                System.out.println(PLAY_END_MESSAGE);
                return;
            }
            // 볼 체크
            int ball = checkBall(randomNums, numbers, visited);

            if(strike != 0) System.out.print(strike+STRIKE_STRING);
            if(ball != 0) System.out.print(ball+BALL_STRING);
            if (strike == 0 && ball == 0)System.out.print(NOTHING_STRING);
            System.out.println();
        }
    }

    private int checkBall(List<Integer> randomNums, List<Integer> numbers, boolean[] visited) {
        int ball = 0;
        for (int i = 0; i < randomNums.size(); i++){
            for (Integer num: numbers){
                if (Objects.equals(randomNums.get(i), num) && !visited[i]) ball++;
            }
        }
        return ball;
    }

    private int checkStrike(List<Integer> randomNums, List<Integer> numbers, boolean[] visited) {
        int strike = 0;
        for (int i = 0; i< randomNums.size(); i++){
            if (numbers.get(i).equals(randomNums.get(i))) {
                strike++;
                visited[i] = true;
            }
        }
        return strike;
    }

    private List<Integer> createRanNum() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_LENGTH) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
