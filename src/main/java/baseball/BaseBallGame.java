package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class BaseBallGame extends Game {
    private static final String REGEX_THREE_NUMBER = "^[1-9]{3}"; // 3개의 1에서 9까지 수

    @Override
    public boolean initGame() {
        return true;
    }

    @Override
    public void playGame() {
        List<Integer> computer = selectComputerNumber();
        List<Integer> user = null;
        do {
            user = inputNumber();
        } while (compareNumber(computer, user));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    private boolean compareNumber(List<Integer> computer, List<Integer> user){
        int strikeNumber = 0;
        int ballNumber = 0;

        for(int i = 0; i < computer.size(); i++){
            if(computer.get(i).equals(user.get(i))){
                strikeNumber++;
            }
            if(computer.contains(user.get(i))){
                ballNumber++;
            }
        }
        ballNumber -= strikeNumber;
        printStatus(ballNumber, strikeNumber);
        return strikeNumber != 3;
    }

    private void printStatus(int ballNumber, int strikeNumber){
        if(ballNumber == 0 && strikeNumber == 0){
            System.out.println(("낫싱"));
        }
        if(ballNumber != 0 && strikeNumber == 0){
            System.out.printf("%d볼", ballNumber).println();
        }
        if(ballNumber == 0 && strikeNumber != 0){
            System.out.printf("%d스트라이크", strikeNumber).println();
        }
        if(ballNumber != 0 && strikeNumber != 0){
            System.out.printf("%d볼 %d스트라이크", ballNumber, strikeNumber).println();
        }
    }

    private List<Integer> inputNumber(){
        System.out.println("숫자를 입력해주세요 : ");
        String input = Console.readLine();
        validateUserNumber(input);
        return input.chars().boxed().map(Character::getNumericValue).toList();
    }

    private void validateUserNumber(String input){
        ValidateInput.validate(input, REGEX_THREE_NUMBER, "3자리 수를 입력해주세요.");
        ValidateInput.validateDuplicate(input);
    }

    private List<Integer> selectComputerNumber(){
        List<Integer> computer = new ArrayList<>();
        while(computer.size()<3){
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if(!computer.contains(randomNumber)){
                computer.add(randomNumber);
            }
        }
        return computer;
    }
}
