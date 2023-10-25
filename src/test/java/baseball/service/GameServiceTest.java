package baseball.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class GameServiceTest {

    GameService gameService = new GameService();
    List<Integer> computerNumber;

    @BeforeEach
    void init() {
        computerNumber = new ArrayList<>();
        computerNumber.add(1);
        computerNumber.add(2);
        computerNumber.add(3);
    }

    @Test
    void convertStringToListTest() {
        String inputNumber = "123";
        Assertions.assertThat(gameService.convertStringToList(inputNumber)).isEqualTo(computerNumber);
    }

    @Test
    void isStrikeTest() {
        List<Integer> playerNumber = new ArrayList<>();
        playerNumber.add(1);
        playerNumber.add(2);
        playerNumber.add(3);

        Assertions.assertThat(gameService.isStrike(playerNumber, computerNumber)).isTrue();
    }

    @Test
    void isStrikeFailTest() {
        List<Integer> playerNumber = new ArrayList<>();
        playerNumber.add(1);
        playerNumber.add(2);
        playerNumber.add(4);

        Assertions.assertThat(gameService.isStrike(playerNumber, computerNumber)).isFalse();
    }
}