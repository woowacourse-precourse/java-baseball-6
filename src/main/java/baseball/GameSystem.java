package baseball;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Pattern;

public class GameSystem {
        private int[] computer;
        private int[] player;
        private int strike = 0;
        private int ball = 0;
        private boolean gameExit = false;

        private void resetScore() {
                strike = 0;
                ball = 0;
        }

        private void getScore() {
                for(int i=0; i<3; i++) {
                    int score = getStrikeBall(player[i], i);
                    if(score == 1) {
                        ball++;
                        continue;
                    }
                    if(score == 2) {
                        strike++;
                    }
                }
        }

        private int getStrikeBall(int num, int idx) {
            for(int i=0; i<3; i++) {
                if(computer[i] == num && i == idx) {
                    return 2;
                }
                if(computer[i] == num) {
                    return 1;
                }
            }
            return -1;
        }

        private String getStringResult() {
            StringBuilder sb = new StringBuilder();
            if(ball>0) {
                sb.append(ball).append("볼 ");
            }
            if(strike>0) {
                sb.append(strike).append("스트라이크");
            }
            if(strike == 0 && ball == 0) {
                return "낫싱";
            }
            return sb.toString();
        }

        private boolean isExitAnswer(String input) {
            Pattern pattern = Pattern.compile("[1-2]");
            return pattern.matcher(input).matches();
        }

        private String inputExit() {
            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String input = Console.readLine();
            if(!isExitAnswer(input)) {
                throw new IllegalArgumentException();
            }
            return input;
        }

        private void processExit(GameNumbers computerNumbers) {
            String input = inputExit();
            if("2".equals(input)) {
                gameExit = true;
            } else {
                computerNumbers.setRandomNumbers();
                computer = computerNumbers.getNumsList();
            }
        }

        private void judgeResult() {
            System.out.println(getStringResult());
            if(strike == 3) {
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            }
        }

        public void playGame() {
            System.out.println("숫자 야구 게임을 시작합니다.");
            GameNumbers computerNumbers = new GameNumbers();
            GameNumbers playerNumbers = new GameNumbers();

            computerNumbers.setRandomNumbers();
            computer = computerNumbers.getNumsList();

            while(!gameExit) {
                    playerNumbers.inputAnswer();
                    player = playerNumbers.getNumsList();

                    resetScore();
                    getScore();
                    judgeResult();

                    if(strike == 3) {
                        processExit(computerNumbers);
                    }
            }
        }
}