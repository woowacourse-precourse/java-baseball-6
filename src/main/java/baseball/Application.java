package baseball;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args){
        System.out.println("숫자 야구 게임을 시작합니다.");

        List<Integer> computerNumberList = computerRanNumList();

        boolean inGame = true;

        while(inGame) {
            System.out.println("숫자를 입력해주세요 : ");
            String userInput = Console.readLine();
            List<Integer> userNumberList = userInputNumList(userInput);
        }
    }

    // computer
    private static List<Integer> computerRanNumList() {
        List<Integer> computerNumberList = new ArrayList<>();
        while (computerNumberList.size() < 3) {
            int randNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerNumberList.contains(randNumber)) {
                computerNumberList.add(randNumber);
            }
        }
        return computerNumberList;
    }
    //user
    private static List<Integer> userInputNumList(String userInput){
        List<Integer> userInputNumberList = new ArrayList<>();
        checkLength(userInput);
        for(String splitUserNumber : userInput.split("")){
            if(!splitUserNumber.isEmpty()){
                userInputNumberList.add(Integer.parseInt(splitUserNumber));
            }
        }
        for(int i = 0; i < userInputNumberList.size(); i++){
            checkZero(userInputNumberList.get(i));
        }
        return userInputNumberList;
    }

    private static void checkLength(String inputNumber) {
        if (inputNumber.length() != 3){
            throw new IllegalArgumentException("3개의 숫자를 입력하세요.");
        }
    }

    private static void checkZero(int number){
        if (number <= 0){
            throw new IllegalArgumentException("1부터 9사이의 숫자만 입력하세요.");
        }
    }


}


