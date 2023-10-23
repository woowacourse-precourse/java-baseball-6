package baseball.service;

import java.util.List;
import java.util.Map;
import java.util.Objects;

import baseball.Controller.BaseballGame;
import baseball.model.Computer;
import baseball.utils.ComputerNumber;
import baseball.utils.Converter;
import baseball.utils.Vaildator;

public class Service {
    BaseballGame baseballGame;
    Computer computer;

    public void setComputerGame() {
        List<Integer> computerRandomNumber = ComputerNumber.createBaseballNumbers();
        this.computer = new Computer(computerRandomNumber);
    }

    public boolean restartGame(String player) {
        Vaildator.isVaildRestartInput(player);
        return Objects.equals(player, "1");
    }

    public String playGame(String player) {
        Vaildator.isVaildPlayerAnswer(player);
        List<Integer> playerAnswer = Converter.toInteger(player);
        Map<String, Integer> result = computer.getResult(playerAnswer);
        return Converter.toString(result);
    }

}
