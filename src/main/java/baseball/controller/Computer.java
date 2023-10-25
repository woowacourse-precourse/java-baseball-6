package baseball.controller;

import baseball.model.ComputerNumberDto;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Computer {
    private List<Integer> computerRandomNumbers;
    private ComputerNumberDto computerNumberDto;

    public Computer(){
        computerRandomNumbers = new ArrayList<>();
        computerNumberDto = new ComputerNumberDto();
    }

    public ComputerNumberDto getRandomComputerNumber(){
        clearComputerRandomNumbersList();
        setTargetNumber();
        setComputerNumberDto();
        return computerNumberDto;
    }

    private void setTargetNumber(){
        while(computerRandomNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computerRandomNumbers.contains(randomNumber)) {
                computerRandomNumbers.add(randomNumber);
            }
        }
    }

    private void setComputerNumberDto(){
        computerNumberDto.setComputerNumber(computerRandomNumbers);
    }

    private void clearComputerRandomNumbersList(){
        computerRandomNumbers.clear();
    }
}
