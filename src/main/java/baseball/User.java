package baseball;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class User {

    private static final int ANSWER_SIZE = 3;
    private static final int ANSWER_MIN_NUM = 1;
    private static final int ANSWER_MAX_NUM = 9;
    private static final int QUIT = 2;

    public List<Integer> guessAnswer() {
        List<Integer> myAnswer = new ArrayList<>();
        String userInput = Console.readLine();
        checkUserInputException(userInput);
        for(int i=0; i<ANSWER_SIZE; i++) {
            int myNum = Integer.parseInt(userInput.substring(i, i + 1));
            myAnswer.add(myNum);
        }
        return myAnswer;
    }

    public boolean restartOrQuit() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String userDecision = Console.readLine();
        if(Integer.parseInt(userDecision)==QUIT) {
            System.out.println("게임 종료");
            return false;
        }
        return true;
    }

    private void checkUserInputException(String userInput) {
        checkSize(userInput);
        checkOnlyNumber(userInput);
        checkDuplicated(userInput);
    }

    private void checkSize(String userInput){
        if(userInput.length()!=ANSWER_SIZE)
            throw new IllegalArgumentException("3자리 숫자만 입력 가능합니다.");
    }

    private void checkOnlyNumber(String userInput){
        for(int i=0; i<ANSWER_SIZE; i++){
            int num = (int)userInput.charAt(i)-48;
            if(!(num>=ANSWER_MIN_NUM && num<=ANSWER_MAX_NUM))
                throw new IllegalArgumentException("1~9사이 숫자만 입력 가능합니다.");
        }
    }

    private void checkDuplicated(String userInput){
        List<String> userInputToArr = new ArrayList<>();
        for(int i=0; i<ANSWER_SIZE; i++){
            String num = userInput.substring(i,i+1);
            if(userInputToArr.contains(num))
                throw new IllegalArgumentException("중복된 숫자는 입력이 불가능합니다.");
            userInputToArr.add(num);
        }
    }
}