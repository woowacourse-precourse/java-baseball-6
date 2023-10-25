package baseball.model;

public class ThreeDigits {
    private char first;
    private char second;
    private char third;
    
    public ThreeDigits(final char first,final char second,final char third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public char getFirst() {
        return first;
    }
    public char getSecond() {
        return second;
    }
    public char getThird() {
        return third;
    }

    public static ThreeDigits toThreeDigits(final String input) {
        return new ThreeDigits(
            input.charAt(0), 
            input.charAt(1), 
            input.charAt(2)
        );
    }

    public static ThreeDigits generateAnswerThreeDigits(
        final int first, 
        final int second,
        final int third
    ){
        int radix = 10; // 10진수
        return new ThreeDigits(
            Character.forDigit(first,radix),
            Character.forDigit(second,radix),
            Character.forDigit(third,radix)
        );
    }

    public static StrikeBallCount compare(final int index, final ThreeDigits answer, final ThreeDigits input){
        char answerChar = getCharByIndex(answer, index);
        char inputChar = getCharByIndex(input, index);

        //* 스트라이크 체크 */
        int strikeCount = checkStrike(answerChar, inputChar);

        //* 볼 체크 */
        int ballCount = checkBall(index, answer, input);
        
        return new StrikeBallCount(strikeCount,ballCount);
    }

    private static int checkStrike(final char answerChar, final char inputChar){
        //* 스트라이크 확인 자기 위치에 같은 Char값이 있는지 확인 */
        return (answerChar == inputChar) ? Constant.STRIKE : Constant.NOT_STRIKE;
    }

    private static int checkBall(final int index, final ThreeDigits answer, final ThreeDigits input){
        //* 볼 개수 세기 자기 위치 빼고 같은게 있는지 보기 */
        char answerCharacter = getCharByIndex(answer,index);
        for(int i=0; i < Constant.DIGIT_LENGTH; i++){
            if(i != index && getCharByIndex(input,i) == answerCharacter){
                return Constant.BALL;
            }
        }
        return Constant.NOT_BALL;
    }

    private static char getCharByIndex(final ThreeDigits digits, final int index){
        if(index == 0)
            return digits.getFirst();
        
        else if(index == 1)
            return digits.getSecond();
        
        else
            return digits.getThird();
    }
}
