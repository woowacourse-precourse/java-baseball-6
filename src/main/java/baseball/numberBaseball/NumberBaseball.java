package baseball.numberBaseball;

import baseball.numberBaseball.game.PlayNumberBaseball;
import baseball.numberBaseball.game.PlayNumberBaseballImpl;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class NumberBaseball {
    public void playNumberBaseball() throws IllegalArgumentException {
        boolean playAgain = true;
        System.out.println("숫자 야구 게임을 시작합니다.");
        PlayNumberBaseball playNumberBaseball = new PlayNumberBaseballImpl();

        while (playAgain) {
            playNumberBaseball.playGame();
//            int attempts = 0;

            System.out.println("숫자를 생성 했어요. 게임을 시작 할게요!");
            while(!playNumberBaseball.gameOver()){
//                attempts++;
                System.out.print("숫자를 입력해주세요 : ");
                String userInput = readLine();

                try {
                    playNumberBaseball.gamePlaying(userInput);
                } catch (IllegalArgumentException e){
                    throw new IllegalArgumentException();
                }
                System.out.println(playNumberBaseball.gameResult());
            }
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            System.out.println("게임을 새로 시작 하려면 1, 종료 하려면 2를 눌러 주세요!");
            String replayInput = readLine();

            try {
                playAgain = playNumberBaseball.gameRestart(replayInput);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }
        }

    }
}