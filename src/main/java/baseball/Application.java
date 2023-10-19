package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();
        boolean gameStatus = true;

        while(gameStatus) {
            baseballGame.generate();
            System.out.println("숫자 야구 게임을 시작합니다.");
            boolean isDone = false;

            while (!isDone) {
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();
                int ballCount = baseballGame.getBallCount(userInput);
                int strikeCount = baseballGame.getStrikeCount(userInput);

                StringBuilder countMessage = new StringBuilder();
                if (ballCount == 0 && strikeCount == 0) {
                    System.out.print("낫싱");
                }

                if(ballCount != 0) {
                    countMessage.append(String.format("%d볼", ballCount));
                    if(strikeCount != 0) countMessage.append(" ");
                }
                if(strikeCount != 0) {
                    countMessage.append(String.format("%d스트라이크", strikeCount));
                }

                System.out.println(countMessage.toString());
                if(strikeCount == BaseballGame.BASEBALL_DIGIT){
                    System.out.printf("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n", BaseballGame.BASEBALL_DIGIT);
                    isDone = true;
                }
            }

            System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
            String userInput = readLine();
            gameStatus = Integer.parseInt(userInput) == 1;
        }
    }
}
