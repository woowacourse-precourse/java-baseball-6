package baseball;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class GameProcess{
    public static void startGame(){
        // 문제 출제
        System.out.println("숫자 야구 게임을 시작합니다");

        BaseballGame game = new BaseballGame();
        playGame(game);
    }

    private static void playGame(BaseballGame game){
        // 문제 풀기-반복처리
        do {
            System.out.print("숫자를 입력해주세요 : ");
            String userInput = readLine();

            // 입력값에 대한 예외 처리 필요
            try {
                GameRulesForInput.validateUserInput(userInput); // 입력값 검증
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException();
            }

            // 정답시
            if(game.isCorrectAnswer(userInput)){
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                askForRestart();
                break;
            }
        } while(true);
    }

    private static void askForRestart() throws IllegalArgumentException{
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
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