package baseball.logic;

import java.util.List;

public class Compare {
    public String getGameResult(List<Integer> computerInput, String userInput) {
        if (!isValidInputThreeNumber(userInput)){
            throw new IllegalArgumentException("3자리의 양의 정수를 입력해야 됩니다. 사용자의 입력 : " + userInput);
        }

//        int[] computerInputArray = convertToArray(computerInput);
//        int[] userInputArray = convertToArray(userInput);

        int checkStrike = 0;
        int checkBall = 0;
        final String NOTHING = "낫싱";

        for (int i = 0; i < computerInput.size(); i++) {
            int computerNumber = computerInput.get(i);
            int userNumber = Integer.parseInt(String.valueOf(userInput.charAt(i)));

            if (computerNumber == userNumber) {
                checkStrike += 1;
            } else {
                for (int j = 0; j < computerInput.size(); j++) {
                    if (computerNumber == Integer.parseInt(String.valueOf(userInput.charAt(j)))) {
                        checkBall += 1;
                    }
                }
            }
        }

//        for (int i = 0; i < computerInputArray.length; i++) {
//            if (computerInputArray[i] == userInputArray[i]) {
//                checkStrike += 1;
//            } else {
//                for (int j = 0; j < computerInputArray.length; j++) {
//                    if (computerInputArray[i] == userInputArray[j]) {
//                        checkBall += 1;
//                    }
//                }
//            }
//        }

        String strikeResult = checkStrike + "스트라이크";
        String ballResult = checkBall + "볼";

        if (checkStrike == 0 && checkBall == 0) {
            return NOTHING;
        }

        if (checkStrike == 0) {
            return ballResult;
        }

        if (checkBall == 0) {
            return strikeResult;
        }

        return ballResult + " " + strikeResult;
    }
    
    

    // 3자리의 정수인지 확인
    private boolean isValidInputThreeNumber(String userInput) {
//        String userInputToString = String.valueOf(userInput);
//        return userInputToString.matches("\\d{3}");

        return userInput.matches("\\d{3}");
    }

    // 인트형 배열로 변환
    private int[] convertToArray(int number) {
        String numberString = String.valueOf(number);
        int[] array = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            array[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return array;
    }
}
