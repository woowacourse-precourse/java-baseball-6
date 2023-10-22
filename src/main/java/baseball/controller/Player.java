package baseball.controller;


import baseball.domain.PlayerNumbers;
import baseball.dto.NumbersStringDto;

public class Player {


    private final Computer computer;
    private PlayerNumbers playerNumbers;

    public Player() {
        computer = new Computer();
    }

    private void inputNumbers(NumbersStringDto numbersStringDto) {
        playerNumbers = new PlayerNumbers(numbersStringDto.show());
    }
}

