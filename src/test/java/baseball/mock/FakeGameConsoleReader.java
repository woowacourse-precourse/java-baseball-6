package baseball.mock;

import baseball.util.GameConsole;

public class FakeGameConsoleReader implements GameConsole {
        private final String inputText;

        public FakeGameConsoleReader(String inputText) {
                this.inputText = inputText;
        }

        @Override
        public String readInput() {
                return inputText;
        }
}
