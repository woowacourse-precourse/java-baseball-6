package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameProcess{
    private static final String START_MESSAGE="숫자 야구 게임을 시작합니다.";
    private static final String END_MESSAGE="3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static final String RESTART_MESSAGE="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static final String INPUT_MESSAGE="숫자를 입력해주세요 : ";
    public static void startGame(){
        // 문제 출제
        System.out.println(START_MESSAGE);

        BaseballGame game = new BaseballGame();
        playGame(game);
    }

    private static void playGame(BaseballGame game){
        // 문제 풀기-반복처리
        do {
            System.out.print(INPUT_MESSAGE);
            String userInput = readLine();

            // 정답시
            if(game.isCorrectAnswer(GameRulesForInput.parseUserInput(userInput))){
                System.out.println(END_MESSAGE);
                askForRestart();
                break;
            }
        } while(true);
    }

    private static void askForRestart() throws IllegalArgumentException{
        System.out.println(RESTART_MESSAGE);
        try{
            int willRestart=Integer.parseInt(readLine());
            if(willRestart==1){
                startGame();
            } else if(willRestart!=2){
                throw new IllegalArgumentException();
            }
        }catch(IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
    }
}