package baseball.domain;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private final PlayerType playerType;
    private final List<Integer> numberList;

    public Player(PlayerType playerType) {
        this.playerType = playerType;
        this.numberList = initNumberList(this.playerType);
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
        int number = verifyEnteredValuesAndReturnForNumber(numberStr);

        return numberToList(number);
    }

//    사용자가 입력한 값이 숫자이고 3자리인지 확인
    private int verifyEnteredValuesAndReturnForNumber(String numberStr){
        if(numberStr.length()!=3){
           throw new IllegalArgumentException("입력하신 숫자의 형식이 잘못되었습니다");
        }
        int number = 0;
        try {
            number = Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다");
        }
        return number;
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
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }
        return computer;
    }





}
