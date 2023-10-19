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
        switch (playerType){
            case HUMAN-> createHumansNumberList();
            case COMPUTER-> createComputersNumberList();
        }
        return null;
    }

//    사람의 숫자 셋팅
    private List<Integer> createHumansNumberList(){
        List<Integer> list = new ArrayList<>();
        String numberStr = Console.readLine();

        return list;
    }

    private boolean verifyEnteredValues(String numberStr){

        return true;
    }

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
