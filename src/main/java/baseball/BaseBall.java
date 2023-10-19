package baseball;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class BaseBall {
    private static final int NUMBER_LENGTH = 3;

    public static GameStarter startGame(){
        Set<String> computer = initComputer();
        return new GameStarter(getResult(computer), NUMBER_LENGTH);
    }

    private static Set<String> initComputer() {
        Set<String> computer = new HashSet<>();
        while (computer.size() < NUMBER_LENGTH) {
            String randomNumber = String.valueOf(Randoms.pickNumberInRange(1, 9));
            computer.add(randomNumber);
        }
        return computer;
    }

    private static String getResult(Set<String> computer){
        return computer.stream().collect(Collectors.joining());
    }
}
