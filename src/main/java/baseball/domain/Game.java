package baseball.domain;

import java.util.List;

import baseball.exception.GameStopExeception;
import camp.nextstep.edu.missionutils.Console;

// 게임 매칭, 게임 생성, 게임 종료, 게임 재시작
public class Game {
    private Computer computer;
    private User user;
    private boolean isGameEnd;

    public Game(){
        this.computer = new Computer();
        this.user = new User();
    }

    public void gameStart(){
        // 게임 시작
        computer.generateNumber();
        gameState();
    }

    private void gameState(){
        // 게임 상태
        while (!isGameEnd){
            try{
                System.out.print("숫자를 입력해주세요 : ");
                user.setUserGuessNumber();
            } catch (Exception e){
                gameStop();
            }
            matchingNumber();
        }
    }

    private void matchingNumber(){
        List<Integer> computerNumber = computer.getNumber();
        List<Integer> userNumber = user.getUserGuessNumber();
        
        int strike = 0;
        int ball = 0;
        
        for (int i = 0; i < computerNumber.size(); i++){
            if (computerNumber.get(i) == userNumber.get(i)){
                strike++;
            } else if (computerNumber.contains(userNumber.get(i))){
                ball++;
            }
        }
        
        if (ball != 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike != 0) {
            System.out.print(strike + "스트라이크");
        }
        if (ball == 0 && strike == 0) {
            System.out.print("낫싱");
        }
        System.out.println();

        if (strike == 3){
            gameOver();
        }
    }

    private void gameOver(){
        // 게임 종료
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
       
        String input = Console.readLine();
        if (input.equals("1")){
            gameStart();
        } else if (input.equals("2")){
            gameStop();
        }
    }

    private void gameStop(){
        // 게임 중지
        throw new GameStopExeception("게임을 종료합니다.");
    }
}
