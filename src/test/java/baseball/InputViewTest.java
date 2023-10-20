package baseball;

import baseball.controller.InputController;
import baseball.model.Ball;
import baseball.model.Player;
import baseball.model.TripleBalls;
import baseball.util.Util;
import baseball.view.InputView;
import camp.nextstep.edu.missionutils.Console;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.InputStream;
import java.util.Scanner;
import java.util.stream.Stream;

public class InputViewTest extends IOTest {
    @ParameterizedTest
    @ValueSource(strings = {"checking my IoTest"})
    void generateMultiInputString(String input) {
        String[] inputArray = input.split(" ");
        String sentence = generateMultipleInputString(inputArray);

        setInUserInput(generateUserInputStream(sentence));
        String result = Console.readLine();
        String resultB = Console.readLine();
        String resultC = Console.readLine();

        System.out.println("result = " + result);
        System.out.println("resultB = " + resultB);
        System.out.println("resultC = " + resultC);
    }

    @ParameterizedTest(name = "user :{0} result : {1}")
    @CsvSource(value = {"checking:checking"}, delimiterString = ":")
    void InputView_newPlayer_Test(String userInput, String result) {
        System.out.println(userInput);
        System.out.println(result);

        setInUserInput(generateUserInputStream(userInput));
        String playerInput = InputView.getPlayerInput();

        Assertions.assertThat(playerInput).isEqualTo(result);
    }

    private static Stream<Arguments> generateInputArguments() {
        return Stream.of(
                Arguments.of("checking\n", "checking"),
                Arguments.of("My\n", "My"),
                Arguments.of("IOTest\n", "IOTest")
        );
    }

    @ParameterizedTest(name = "input : {0} result : {1}")
    @MethodSource("generateInputArguments")
    void userMultipleUserInputs(String input, String result) {
        InputStream inputStream = generateUserInputStream(input);
        setInUserInput(inputStream);
        String sentence = new Scanner(System.in).nextLine();

        Assertions.assertThat(sentence).isEqualTo(result);
    }

    @ParameterizedTest
    @ValueSource(strings = {"123"})
    void generatePlayerBallsFromInput(String ballInput) {
        Player generatedPlayer = InputController.generatePlayerTripleBalls(ballInput);
        TripleBalls playerTripleBalls = generatedPlayer.getPlayerTripleBalls();

        Assertions.assertThat(playerTripleBalls.getTripleBalls()).containsExactly(
                new Ball(1, 1), new Ball(2, 2), new Ball(3, 3)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"1"})
    void restart_Game_When_Choose_One(String restart) {
        setInUserInput(generateUserInputStream(restart));
        String restartChoice = InputView.inputRestartOrFinish();

        Assertions.assertThat(restartChoice).isEqualTo("1");
    }



}
