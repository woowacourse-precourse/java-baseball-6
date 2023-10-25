package baseball.container;

import baseball.controller.GameController;
import baseball.controller.GameControllerImpl;
import baseball.factory.GameFactory;
import baseball.factory.GameFactoryImpl;
import baseball.service.GameService;
import baseball.service.GameServiceImpl;
import baseball.util.generator.RandomNumberGenerator;
import baseball.util.generator.RandomNumberGeneratorImpl;
import baseball.util.matcher.NumbersMatcher;
import baseball.util.matcher.NumbersMatcherImpl;
import baseball.util.parser.MatchResultParser;
import baseball.util.parser.MatchResultParserImpl;
import baseball.util.validator.InputValidator;
import baseball.util.validator.InputValidatorImpl;
import baseball.view.Console;
import baseball.view.ConsoleImpl;

public class ApplicationContainer {
    private GameController gameController;
    private GameService gameService;
    private NumbersMatcher numbersMatcher;
    private MatchResultParser matchResultParser;
    private InputValidator inputValidator;
    private GameFactory gameFactory;
    private RandomNumberGenerator randomNumberGenerator;
    private Console console;

    private void printCreatedInstanceMessage( String instanceClass, String interfaceClass) {
        System.out.println(
                "The instance of " + instanceClass + " is successfully created as an implementation of " + interfaceClass
        );
    }

    public RandomNumberGenerator getRandomNumberGenerator() {
        if ( randomNumberGenerator == null ) {
            randomNumberGenerator = new RandomNumberGeneratorImpl();
            printCreatedInstanceMessage(
                    randomNumberGenerator.getClass().toString(), RandomNumberGenerator.class.toString()
            );
        }
        return randomNumberGenerator;
    }

    public MatchResultParser getMatchResultParser() {
        if ( matchResultParser == null ) {
            matchResultParser = new MatchResultParserImpl();
            printCreatedInstanceMessage(matchResultParser.getClass().toString(), MatchResultParser.class.toString());
        }
        return matchResultParser;
    }

    public NumbersMatcher getNumbersMatcher() {
        if ( numbersMatcher == null ) {
            numbersMatcher = new NumbersMatcherImpl(getMatchResultParser());
            printCreatedInstanceMessage(numbersMatcher.getClass().toString(), NumbersMatcher.class.toString());
        }
        return numbersMatcher;
    }

    public InputValidator getInputValidator() {
        if ( inputValidator == null ) {
            inputValidator = new InputValidatorImpl();
            printCreatedInstanceMessage(inputValidator.getClass().toString(), InputValidator.class.toString());
        }
        return inputValidator;
    }

    public GameFactory getGameFactory() {
        if ( gameFactory == null ) {
            gameFactory = new GameFactoryImpl();
            printCreatedInstanceMessage(gameFactory.getClass().toString(), GameFactory.class.toString());
        }
        return gameFactory;
    }

    public GameService getGameService() {
        if ( gameService == null ) {
            gameService = new GameServiceImpl(
                    getRandomNumberGenerator(), getNumbersMatcher(), getInputValidator(), getGameFactory()
            );
            printCreatedInstanceMessage(gameService.getClass().toString(), GameService.class.toString());
        }
        return gameService;
    }

    public Console getConsole() {
        if ( console == null ) {
            console = new ConsoleImpl();
            printCreatedInstanceMessage(console.getClass().toString(), Console.class.toString());
        }
        return console;
    }

    public GameController getGameController() {
        if ( gameController == null ) {
            gameController = new GameControllerImpl(getGameService(), getConsole());
            printCreatedInstanceMessage(gameController.getClass().toString(), GameController.class.toString());
        }
        return gameController;
    }
}
