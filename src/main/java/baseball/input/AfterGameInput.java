package baseball.input;

import static camp.nextstep.edu.missionutils.Console.readLine;
public class AfterGameInput {

    public int getAfterGameInput(){
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userInput = readLine();
        int inputNumber;
        try{
            inputNumber = Integer.parseInt(userInput);
        }catch (Exception e){
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
        if (inputNumber == 1 || inputNumber == 2) {
            return inputNumber;
        } else {
            throw new IllegalArgumentException("입력값은 1 또는 2이어야 합니다.");
        }
    }

}
