package baseball.ui;

/**
 * @author 민경수
 * @description console display
 * @since 2023.10.23
 **********************************************************************************************************************/
public class ConsoleDisplayFactory {

    public static PrintMessage requestInput() {
        return new GameStartDisplay();
    }

    public static PrintResultMessage result() {
        return new GameResultDisplay();
    }

    public static PrintResultMessage end() {
        return new GameEndDisplay();
    }

    public static PrintMessage restartDrawer() {
        return new GameRestartChoiceDisplay();
    }

}