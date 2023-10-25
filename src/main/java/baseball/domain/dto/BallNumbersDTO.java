package baseball.domain.dto;

public class BallNumbersDTO {

//    private final BallNumbers ballNumbers;
//
//    public BallNumbersDTO(String ballNumbersStr) {
//        this.ballNumbers = createNumberList(ballNumbersStr);
//    }
//
//    private static BallNumbers createNumberList(String ballNumbersStr) {
//        List<Integer> userNumbers = new ArrayList<>();
//        validateNumber(ballNumbersStr);
//        String[] splitNumberStr = ballNumbersStr.split("");
//        for (String numStr : splitNumberStr) {
//            userNumbers.add(Integer.parseInt(numStr));
//        }
//        return BallNumbers.from(userNumbers);
//    }
//
//
//    private static void validateNumber(String ballNumbersStr) {
//        for (int i = 0; i < ballNumbersStr.length(); i++) {
//            if (!Character.isDigit(ballNumbersStr.charAt(i))) {
//                throw new IllegalArgumentException(NUMBER_INPUT_FORMAT_EXCEPTION);
//            }
//        }
//    }
//
//    public BallNumbers getBallNumbers() {
//        return ballNumbers;
//    }
}
