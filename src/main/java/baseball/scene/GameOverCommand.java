package baseball.scene;

import baseball.game.state.GameState;
import baseball.game.state.GameStateManager;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum GameOverCommand {
    RE_START(GameOverCommand.STRING_RE_START_INPUT),
    EXIT(GameOverCommand.STRING_EXIT_INPUT),
    UNKNOWN(GameOverCommand.STRING_UNKNOWN);

    public static final String STRING_RE_START_INPUT = "1";
    public static final String STRING_EXIT_INPUT = "2";
    public static final String STRING_UNKNOWN = "UNKNOWN";

    private final String command;

    private GameOverCommand(final String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    private static final Map<String, GameOverCommand> commands = Collections.unmodifiableMap(
            Stream.of(values()).collect(
                    Collectors.toMap(
                            GameOverCommand::getCommand,
                            Function.identity()
                    )
            )
    );

    public static GameOverCommand find(final String command) {
        return Optional.ofNullable(commands.get(command)).orElse(UNKNOWN);
    }

    public static void updateFromUserInput(final GameStateManager gameStateManager, final String userInput) {
        final GameOverCommand gameOverCommand = GameOverCommand.find(userInput);
        switch (gameOverCommand) {
            case RE_START -> gameStateManager.update(GameState.GAME);
            case EXIT -> gameStateManager.update(GameState.EXIT);
            default -> throw new IllegalArgumentException("지원하지 않는 메뉴입니다.");
        }
    }
}
