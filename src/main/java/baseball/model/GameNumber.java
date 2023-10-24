package baseball.model;

import java.util.List;

public class GameNumber {
    private String userInputString;
    private List<Integer> userInputNumbers;
    private List<Integer> computerGenerateNumbers;

    public void saveUserInputNumbers(String userInputString, List<Integer> userInputNumbers) {
        this.userInputString = userInputString;
        this.userInputNumbers = userInputNumbers;
    }

    public int countSamePlacesAndNumbers() {
        int samePlaceAndNumberCount = 0;

        for (int i = 0; i < userInputNumbers.size(); i++) {
            if (userInputNumbers.get(i) == computerGenerateNumbers.get(i)) {
                samePlaceAndNumberCount++;
            }
        }
        return samePlaceAndNumberCount;
    }

    public int countOtherPlacesAndSameNumbers() {
        int otherPlaceAndSameNumberCount = 0;

        for (int i = 0; i < userInputNumbers.size(); i++) {
            if (computerGenerateNumbers.get(i) != userInputNumbers.get(i) && computerGenerateNumbers.contains(userInputNumbers.get(i))) {
                otherPlaceAndSameNumberCount++;
            }
        }
        return otherPlaceAndSameNumberCount;
    }

    public void setComputerGenerateNumbers(List<Integer> computerGenerateNumbers) {
        this.computerGenerateNumbers = computerGenerateNumbers;
    }
}
