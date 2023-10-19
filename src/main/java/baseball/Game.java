package baseball;

import baseball.config.GameConfig;

import java.io.Console;
import java.util.ArrayList;
import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    private Validation validation;

    public void gameStart(){
        System.out.println("숫자 야구 게임을 시작합니다.");

        //컴퓨터 생성
        computer = new Computer();

        //유저 입장
        user = new User();

        //심판관 입장
        validation = new Validation();

        while (playGame()) {

        }


    }
    private boolean playGame(){
        boolean retryCheck = false; // 재시도 여부 체크

        //컴퓨터의 랜덤 값 생성
        List<Character> answer = computer.createAnswer();
        List<Character> userAnswer = new ArrayList<>();

        while (true){
            //유저 입력 초기화
            userAnswer.clear();
            System.out.println("숫자를 입력해주세요 : ");
            // 유저 입력 받기
            String userInput = user.inputBaseballNumber();

            //심판관 추가 (제대로 입력이 되었는지 체크 해주는 사람)
            userAnswer = validation.checkUserInput(userInput);

            // 딜러의 입력값 컴퓨터 입력값 비교
            GameResult gameResult = getGameResult(userAnswer, answer);

            // 딜러의 결과값 출력
            if(printResult(gameResult)){
                printSuccess();
                inputRetry();
            }

            // 성공 여부 체크 후 return
        }
    }

    private GameResult getGameResult(List<Character> userAnswer, List<Character> answer) {
        Integer ball = 0;
        Integer strike = 0;

        for (int i = 0; i < GameConfig.CORRECT_LENGTH; i++) {
            if (userAnswer.get(i) == answer.get(i)) {
                strike++;
            }
        }

        for (int i = 0; i < GameConfig.CORRECT_LENGTH; i++) {
            if (answer.contains(userAnswer.get(i)) && answer.get(i) != userAnswer.get(i)) {
                ball++;
            }
        }

        return new GameResult(strike, ball);
    }

    private boolean printResult(GameResult gameResult) {
        if(gameResult.getStrike() == GameConfig.CORRECT_LENGTH ){
            System.out.println(gameResult.getStrike() + "스트라이크");
            return true;
        }else if(gameResult.getStrike() != 0 || gameResult.getBall() != 0){
            System.out.println(gameResult.getStrike() + "볼 " + gameResult.getBall() + "스트라이크");
        }else{
            System.out.println("낫싱");
        }
        return false;
    }

    private void printSuccess(){
        System.out.println(GameConfig.CORRECT_LENGTH + "개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    private void inputRetry(){
        String userInput = user.inputRestartNumber();
        validation.checkRetryInput(userInput);
    }
}
