package baseball.domain;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.IllformedLocaleException;
import java.util.List;
import java.util.Objects;

public class Player {

    private final int NUMBER_OF_DIGITS = 3;
    private final String ERROR_MESSAGE ="입력값이 잘못되었습니다";
    private final PlayerType playerType;
    private final List<Integer> numberList;


    public Player(PlayerType playerType) {
        this.playerType = playerType;
        this.numberList = initNumberList(playerType);
    }

    private List<Integer> initNumberList(PlayerType playerType){
        return switch (playerType){
            case HUMAN-> createHumansNumberList();
            case COMPUTER-> createComputersNumberList();
        };

    }

//    사람의 숫자 셋팅
    private List<Integer> createHumansNumberList(){
        List<Integer> list = new ArrayList<>();
        String numberStr = Console.readLine();

        if(!verifyInputValue(numberStr)){
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
        return numberToList(Integer.parseInt(numberStr));
    }

//  해당 메소드는 게임 중 입력값을 검증할 때도 필요 할 수 있으니 public으로 선언
    public boolean verifyInputValue(String numberStr){
        return isThreeDigits(numberStr) && isNumbers(numberStr) && isDuplicate(numberStr);
    }

//    사용자가 입력한 값이 3자리 수인지 검증
    private boolean isThreeDigits(String numberStr){
        return numberStr.length() == NUMBER_OF_DIGITS;
    }

//    입력한 값이 숫자인지 검증
    private boolean isNumbers(String numberStr){
        return numberStr.chars()
                .filter(i-> i<'1'||i>'9')
                .count() == 0;
    }

//    중복된 값이 있는지 검증
    private boolean isDuplicate(String numberStr){
        int length = numberStr.length();
        return numberStr.chars()
                .distinct()
                .count() == length;
    }

//    입력받은 숫자를 리스트로 반환
    private List<Integer> numberToList(int number){
        List<Integer> list = new ArrayList<Integer>();
        while(number != 0) {
            list.add(0,number%10);
            number/=10;
        }
        return list;
    };



//    컴퓨터의 숫자 셋팅
    private List<Integer> createComputersNumberList(){
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < NUMBER_OF_DIGITS) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }

//    외부에서 들어온 숫자(다른 사용자가 추측한 답)와 해당 사용자의 답을 비교
    public List<Integer> compareAnswers(int answerNumber){
        List<Integer> otherPlayersList = numberToList(answerNumber);
        return calculateStrikesAndBalls(this.numberList, otherPlayersList);
    }

//    두개의 리스트를 비교해 스트라이크, 볼, 아웃을 비교
    private List<Integer> calculateStrikesAndBalls(List<Integer> thisList, List<Integer> otherList){
        int strike = 0;
        int ball = 0;
        int out = 0;

        for(int i =0; i < thisList.size();i++){
            if(!thisList.contains(otherList.get(i))){
                out++;
                continue;
            }
            if(Objects.equals(thisList.get(i), otherList.get(i))){
                strike++;
                continue;
            }
            ball++;
        }
        return List.of(strike, ball, out);
    }



    @Override
    public String toString() {
        return numberList.toString();
    }



}
