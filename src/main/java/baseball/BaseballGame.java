package baseball;

import java.util.List;

public class BaseballGame {
    private static final String START_MESSAGE = "숫자 야구 게임을 시작합니다.";
    private static final String WIN_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_OR_END_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String INPUT_MESSAGE = "숫자를 입력해주세요 : ";
    private static final String NOTHING = "낫싱";
    private static final String BALL = "볼";
    private static final String STRIKE = "스트라이크";
    private static final int STRIKE_TOTAL_CNT = 3;

    private Computer computer = new Computer();
    private Player player = new Player();
    private List<Integer> answer;
    private String playerInput;
    private int strikeCnt;
    private int ballCnt;

    public BaseballGame(){
    }

    public void start(){
        System.out.println(START_MESSAGE);
        answer = computer.makeRandomAnswer();

        while(true){
            strikeCnt = 0;
            ballCnt = 0;

            System.out.println(INPUT_MESSAGE);
            playerInput = player.getInput();

            calculateScore();
            System.out.println(makeResultMessage());

            if(isWin()){
                System.out.println(WIN_MESSAGE);
                System.out.println(RESTART_OR_END_MESSAGE);

                player.setEndInput();
                if(isEnd()){
                    return;
                }

                answer = computer.makeRandomAnswer();
            }
        }
    }

    private void calculateScore(){
        for(int i=0;i<3;i++) {
            int userNum = Character.getNumericValue(playerInput.charAt(i));

            for (int j = 0; j < 3; j++) {
                int answerNum = answer.get(j);
                if (userNum == answerNum) {
                    if (i == j) {
                        strikeCnt++;
                        break;
                    }

                    ballCnt++;
                }
            }
        }
    }

    private String makeResultMessage(){
        String result = "";

        if(strikeCnt == 0 && ballCnt == 0){
            return NOTHING;
        }

        if(ballCnt > 0){
            result += (ballCnt + BALL + " ");
        }

        if(strikeCnt > 0){
            result += (strikeCnt + STRIKE);
        }

        return result;
    }

    private boolean isWin(){
        return strikeCnt == STRIKE_TOTAL_CNT;
    }

    private boolean isEnd(){
        return player.isEnd();
    }

}
