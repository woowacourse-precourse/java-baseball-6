package baseball.service;

import baseball.domain.Computer;
import baseball.domain.Player;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class GameService {

    private final ComputerService computerService = new ComputerService();
    private final PlayerService playerService = new PlayerService();
    private final MessageService messageService = new MessageService();


    public Computer initComputer() {
        messageService.startMessage();
        return setComputer();
    }

    public Computer setComputer() {
        return computerService.setComputerNumber();
    }

    public Player initPlayer() {
        messageService.inputMessage();
        return playerService.inputPlayerNumber();
    }


    public ArrayList<Integer> getResult(Computer computer, Player player) {
        return checkBallCount(computerService.getComputerNumber(computer), playerService.getPlayerNumber(player));
    }

    public ArrayList<Integer> checkBallCount(ArrayList<Integer> com, ArrayList<Integer> player) {
        int ball = 0, strike = 0;
        for (int i = 0; i < 3; i++) {
            if (Objects.equals(com.get(i), player.get(i)))
                strike += 1;
            else if (com.contains(player.get(i)))
                ball += 1;
        }

        return new ArrayList<>(Arrays.asList(ball, strike));
    }

    public void showResult(ArrayList<Integer> result) {
        messageService.resultMessage(result);
    }


    public boolean confirmGameRestart() {
        messageService.endMessage();
        messageService.restartMessage();
        return inputRestartAnswer();
    }

    public Boolean inputRestartAnswer() {
        String answer = Console.readLine();

        if (answer.equals("1")) return true;
        else if (answer.equals("2")) return false;
        else throw new IllegalArgumentException();
    }

}
