package baseball.input;

import baseball.GameStatus;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class NewGameInput {

    public int newGame(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        int inputNumber;
        try{
            inputNumber = Integer.parseInt(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }

        if (inputNumber != GameStatus.PLAY.status && inputNumber != GameStatus.FINISH.status) {
            throw new IllegalArgumentException("입력값은 1 또는 2이어야 합니다.");
        }

        return inputNumber;
    }

}
