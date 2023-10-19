package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        BaseballGame baseballGame = new BaseballGame();

        System.out.println("숫자 야구 게임을 시작합니다.");
        boolean isDone = false;
        while (!isDone) {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();
            int ballCount = baseballGame.getBallCount(userInput);
            int strikeCount = baseballGame.getStrikeCount(userInput);

            StringBuilder countMessage = new StringBuilder();
            if (ballCount == 0 && strikeCount == 0) {
                System.out.println("낫싱");
            }

            if(ballCount != 0) {
                countMessage.append(String.format("%d볼", ballCount));
                if(strikeCount != 0) countMessage.append(" ");
            }
            if(strikeCount != 0) {
                countMessage.append(String.format("%d스트라이크", strikeCount));
            }

            System.out.println(countMessage.toString());
            if(strikeCount == 3){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                isDone = true;
            }
        }
    }
}
