package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

//interface Game {
//    public void start();
//    public void exit();
//}
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application.BaseBallGame game = new Application.BaseBallGame();
        game.start();
    }
    static class BaseBallGame {
        private String COMPUTER_VALUE;
        private final int VALUE_SIZE = 3;
        public void start() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            while(true){
                run();
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                if (Console.readLine().equals("2")) break;
            }

        }
        public void run(){
            COMPUTER_VALUE = matchFormat(generateRandomNumber());
            while(true){
                System.out.print("숫자를 입력해주세요 : ");
                String user_input = Console.readLine();
                if (user_input.length() > 3  || isDuplicated(user_input)) { // 숫자가 아닐 경우, 초과되는 숫자일 경우에 대비한 에러 처리
                    throw new IllegalArgumentException();
                }
                if (checkScore(user_input)) return;
            }
        }
        private boolean checkScore(String user_input){
            Boolean answer = false;
            StringBuilder sb = new StringBuilder();
            int strikeCount = getStrikeCount(user_input);
            int ballCount = getBallCount(user_input);
            if (ballCount > 0) {
                sb.append(ballCount + "볼 ");
            }
            if (strikeCount > 0) {
                sb.append(strikeCount + "스트라이크");
            }
            System.out.println(sb.isEmpty() ? "낫싱" : sb);
            if (strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                return true;
            }
            return false;
        }

        public void exit() {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        private String matchFormat(String value){
            return String.format("%03d", Integer.parseInt(value));
        }
        private String matchFormat(int value){
            return String.format("%03d", value);
        }
        public boolean isDuplicated(String value){
            return value.charAt(0) == value.charAt(1) || value.charAt(1) == value.charAt(2) || value.charAt(0) == value.charAt(2);
        }
        private String generateRandomNumber(){

            List<Integer> computer = new ArrayList<>();
            while (computer.size() < 3) {
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (!computer.contains(randomNumber)) {
                    computer.add(randomNumber);
                }
            }
            String randomNumber = "";
            for (Integer te: computer) {
                randomNumber += te;
            }
            return randomNumber;
        }
        private int getStrikeCount(String user_value){
            int strike_count = 0;
            for (int i=0; i < VALUE_SIZE; i++){
                if (user_value.charAt(i) == COMPUTER_VALUE.charAt(i)) {
                    strike_count++;
                }
            }
            return strike_count;
        }
        private int getBallCount(String user_value){
            int ball_count = 0;
            for (int userIdx =0; userIdx < VALUE_SIZE; userIdx++){
                for (int comIdx = 0; comIdx < VALUE_SIZE; comIdx++){
                    if (comIdx == userIdx) continue;
                    if (user_value.charAt(userIdx) == COMPUTER_VALUE.charAt(comIdx)) ball_count++;
                }
            }
            return ball_count;
        }
    }
}


