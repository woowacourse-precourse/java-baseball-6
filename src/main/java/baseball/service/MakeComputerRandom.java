package baseball.service;

import baseball.domain.Computer;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. createRandom() : 컴퓨터 랜덤 값 만들기
 */
public class MakeComputerRandom {
    public Computer createRandom() {
        List<Integer> computer = new ArrayList<>();
        while (computer.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!computer.contains(randomNumber)) {
                computer.add(randomNumber);
            }
        }

        Computer computerValue = Computer.createComputer(computer);
        for (Integer computerV : computerValue.getComputerValue()) {
            System.out.println("computerValue = " + computerV);
        }

        return computerValue;
    }
}
