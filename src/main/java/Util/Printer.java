
package Util;

public class Printer {
    public void print(Message message) {
        System.out.println(message.getText());
    }
    public enum Message {
        START("숫자 야구 게임을 시작합니다."),
        GAME_OPTION("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
        USER_INPUT_PROMPT("숫자를 입력해주세요: "),
        NOTHING("낫싱"),
        ALL_STRIKE("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

        private final String text;

        Message(String text) {
            this.text = text;
        }

        public String getText() {
            return text;
        }
    }
}