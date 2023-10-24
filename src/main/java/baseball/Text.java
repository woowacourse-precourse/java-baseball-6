package baseball;

public class Text {
    // 출력 및 익셉션 텍스트 저장
    public static String startingText = "숫자 야구 게임을 시작합니다.";
    public static String inputText = "숫자를 입력해주세요 : ";
    public static String correctGuessText = "개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public static String restartText = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    public static String endText = "숫자 야구 게임을 종료합니다.";

    public static String guessNullException = "인풋값이 비어있습니다.";
    public static String guessLengthException = String.format(
            "인풋값의 길이가 잘못되었습니다. %d자리 숫자를 입력해주세요.", Variables.answerLength);
    public static String guessIsNumberException = "인풋값에 숫자가 아닌 문자가 있습니다.";
    public static String guessDupliNumberException = "인풋값에 중복된 숫자가 있습니다.";
    public static String restartInputException = "올바른 인풋값이 아닙니다.";
}