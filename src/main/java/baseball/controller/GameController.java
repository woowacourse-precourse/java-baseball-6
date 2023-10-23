package baseball.controller;

import baseball.domain.computer.Computer;
import baseball.domain.game.Game;
import baseball.domain.player.dto.PlayerNumbersDto;
import baseball.domain.player.Player;
import baseball.domain.player.PlayerNumbers;
import baseball.domain.player.dto.RetryNumberDto;
import baseball.global.converter.NumbersConverter;
import baseball.global.message.RetryMessage;
import baseball.global.view.input.InputView;
import baseball.global.view.output.OutputView;

import static baseball.global.message.BallMessage.STRIKE;
import static baseball.global.message.RetryMessage.ONE;

public class GameController {

    private final InputView inputView;
    private final OutputView outputView;
    private final NumbersConverter numbersConverter;
    private PlayerNumbers playerNumbers;
    private Player player;
    private Game game;


    public GameController(InputView inputView, OutputView outputView, NumbersConverter numbersConverter) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numbersConverter = numbersConverter;
    }



    public void run() {
        boolean retry;
        do {
            init();
            start();
            play();
            end();
            retry = askRetry();
        } while (retry);
    }

    public void init() {
        player = createPlayer();
        Computer computer = new Computer();
        game = new Game(computer, player);
    }

    public void start() {
        outputView.printStartMessage();
    }

    public void play() {
        String playResult;
        do {
            inputPlayerNumbers();
            playResult = game.getPlayerResult();
            outputView.printPlayerResult(playResult);

        } while (!playResult.equals("3"+STRIKE.getMessage()));
    }

    public void end() {
        outputView.printThreeStrike();
        outputView.printRetryMessage();
    }

    public boolean askRetry() {
        String input = RetryNumberDto.of(inputView.input());
        return RetryMessage.compareInput(input);
    }

    public void inputPlayerNumbers() {
        outputView.printInputThreeNumber();
        PlayerNumbersDto playerNumbersDto = PlayerNumbersDto.of(inputView.input());
        player.inputNumbers(playerNumbersDto.playerNumbers());
    }


    public Player createPlayer() {
        playerNumbers = new PlayerNumbers(numbersConverter);
        player = new Player(playerNumbers);

        return player;
    }
}
