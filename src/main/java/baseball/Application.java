package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Application {
    private static final int RESTART_NUM = 1;
    private static final int EXIT_NUM = 2;
    public static void main(String[] args) {
        GenerateRandomNum randomNum = new GenerateRandomNum();
        Input input = new Input();
        Judge judge = new Judge();

        while (true){
            List<Integer> computer = randomNum.createNumber();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judge.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            int again = playagain();
            if (again == EXIT_NUM){
                break;
            }
        }
    }


    // 컴퓨터의 수와 플레이어의 수 비교 클래스
    static class Compare {
        public int howMany(List<Integer> computer, List<Integer> player){
            int result = 0;
            for (Integer number : player) {
                if (computer.contains(number)) {
                    result += 1;
                }
            }
            return result;
        }
        public int countStrike(List<Integer> computer, List<Integer> player){
            int strike = 0;
            for(int i = 0; i < player.size(); i++) {
                if(Objects.equals(computer.get(i), player.get(i))){
                    strike += 1;
                }
            }
            return strike;
        }
    }

    // 컴퓨터의 임의의 3 가지 숫자 생성하기
    static class GenerateRandomNum {
        public int randomMake() {
            return Randoms.pickNumberInRange(1, 9);
        }
        public List<Integer> createNumber() {
            List<Integer> computerNumber = new ArrayList<>();
            while (computerNumber.size() < 3){
                int randomNumber = randomMake();
                if (!computerNumber.contains(randomNumber)){
                    computerNumber.add(randomNumber);
                }
            }
            return computerNumber;
        }
    }

    // 스트라이크와 볼 최종 결정하기
    static class Judge {
        Compare compare = new Compare();
        public String judgement(List<Integer> computer, List<Integer> player) {
            int total = compare.howMany(computer, player);
            int strike = compare.countStrike(computer, player);
            int ball = total - strike;

            if(total == 0){
                return "낫싱";
            }else if(strike == 0){
                return ball + "볼";
            } else if(ball == 0){
                return strike + "스트라이크";
            }
            return ball + "볼 " + strike +"스트라이크";
        }
    }

    // 플레이어 입력값 받기
    static class Input {
        public List<Integer> playerNumber() {
            System.out.print("숫자를 입력해주세요 : ");
            List<Integer> playerNum = new ArrayList<>();
            String input = Console.readLine();
            if (input.length() != 3){
                throw new IllegalArgumentException("입력 값 오류");
            }
            for(String number: input.split("")){
                playerNum.add(Integer.parseInt(number));
            }
            return playerNum;

        }
    }

    // 경기 재시작 여부
    private static int playagain() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int reGame = Integer.parseInt(Console.readLine());
        if (reGame != RESTART_NUM && reGame != EXIT_NUM){
            throw new IllegalArgumentException("입력 오류");
        }
        return reGame;
    }
}
