package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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
            System.out.println("숫자 야구 게임을 시작합니다.");
            // 게임 함수로 이동
            play();
            // 재시작 or 종료
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            input = Console.readLine();
            if(!input.equals("1") && !input.equals("2")) throw new IllegalArgumentException(); // 에러 확인
        }while(!input.equals("2"));
    }

    // 야구 게임
    private void play() {
        List<Integer> randomNums = createRanNum();
        while(true){
            System.out.print("숫자를 입력해주세요 : ");
            String num = Console.readLine();

            // 숫자가 3자리가 아닌 경우
            if(num.length() > 3) throw new IllegalArgumentException();
            List<Integer> numbers = new ArrayList<>();
            // 같은 값을 입력하거나 숫자가 아닌 값을 입력한 경우
            try{
               Arrays.stream(num.split("")).forEach(i -> {
                   if (numbers.contains(Integer.parseInt(i))) throw new IllegalArgumentException();
                   else numbers.add(Integer.parseInt(i));
               });
            }catch (NumberFormatException e){
                throw new IllegalArgumentException();
            }

            boolean[] visited = new boolean[numbers.size()];
            int strike = checkStrike(randomNums, numbers, visited);
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return;
            }
            // 볼 체크
            int ball = checkBall(randomNums, numbers, visited);

            if(strike != 0) System.out.print(strike+"스트라이크");
            if(ball != 0) System.out.print(ball+"볼");
            if (strike == 0 && ball == 0)System.out.print("낫싱");
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
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
