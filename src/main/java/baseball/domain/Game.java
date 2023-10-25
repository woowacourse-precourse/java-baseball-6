package baseball.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Game {

    private Computer computer;
    private Player player;
    private int gameCount = 1;
    private GameStatus status = GameStatus.GAMING; //default: GAMING
    private Result result;

    public Game(Computer computer, Player player) {
        this.computer = computer;
        this.player = player;
    }

    public Computer getComputer() {
        return computer;
    }

    public Player getPlayer() {
        return player;
    }

    public Result getResult() {
        return result;
    }

    public int getGameCount() {
        return gameCount;
    }

    public void addGameCount() {
        this.gameCount++;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus gameStatus) {
        this.status = gameStatus;
    }

    public Result play() {
        List<Integer> answer = this.computer.getNumber().getNumbers();
        System.out.print("숫자를 입력해주세요: ");
        List<Integer> input = Arrays.stream(this.player.enterInput().split(""))
                .mapToInt(Integer::parseInt)
                .distinct()
                .boxed()
                .collect(Collectors.toList());

        if (input.size() != 3) {
            throw new IllegalArgumentException();
        }

        int ball = (int)input.stream().filter(in -> answer.stream().anyMatch(Predicate.isEqual(in))).count();
        int strike = 0;

        for (int i = 0; i < answer.size(); i++) {
            if (answer.get(i) == input.get(i)) {
                strike++;
                ball--;
            }
        }

        result = new Result(strike, ball);

        return result;
    }

    public void choiceContinue() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        int choice = Integer.parseInt(Console.readLine());
        if (choice == 1) setStatus(GameStatus.RESTART);
        else setStatus(GameStatus.END);
    }
}
