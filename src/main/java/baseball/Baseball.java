package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Baseball {

    int maxDigit = 3;
    List<Integer> answer;

    public void makeRandomNumber(){
        List<Integer> answer = new ArrayList<>();
        while (answer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!answer.contains(randomNumber)) {
                answer.add(randomNumber);
            }
        }

        this.answer = answer;
    }
    private List<Integer> getInput() throws IllegalArgumentException{
        List<Integer> inputNumList = new ArrayList<>();
        System.out.print("숫자를 입력해주세요 : ");
        String inputNum = Console.readLine();

        if(inputNum.length() != 3){
            throw new IllegalArgumentException();
        }

        for(int digit = 0; digit < maxDigit; digit++){
            int numberOfDigit = Character.getNumericValue(inputNum.charAt(digit));

            if(numberOfDigit == 0){
                throw new IllegalArgumentException();
            }

            inputNumList.add(numberOfDigit);
        }

        Set<Integer> numSet = new HashSet<>(inputNumList);

        if(numSet.size()!= inputNumList.size()){
            throw new IllegalArgumentException();
        }

        return inputNumList;
    }

    private boolean checkBall(List<Integer> inputNumList){
        int matchingCount = 0;
        int strike = 0;

        List<Integer> matchingList = answer.stream()
                .filter(old -> inputNumList.stream()
                        .anyMatch(Predicate.isEqual(old)))
                .toList();

        matchingCount = matchingList.size();
        for(int digit =0; digit < maxDigit; digit++){
            if(answer.get(digit) == inputNumList.get(digit)){
                strike++;
            }
        }

        if(matchingCount == 0){
            System.out.println("낫싱");
        }else{
            if(strike < matchingCount){
                System.out.print(matchingCount - strike + "볼 ");
            }
            if(strike != 0){
                System.out.println(strike + "스트라이크");
            }
        }

        return strike != 3;
    }

    public void playGame() throws IllegalArgumentException{
        makeRandomNumber();
        while(checkBall(getInput()));
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
