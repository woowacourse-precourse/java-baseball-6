package baseball;

public class CompareNumbers {
    public String compare(ComNumber comNumber, PlayerNumber playerNumber) {
        int strikeCount = 0;
        int ballCount = 0;

        for (int i = 0; i < comNumber.pickedNumbers.size(); i++) {
            int com1 = comNumber.pickedNumbers.get(i);
            if (playerNumber.inputNumbers.contains(com1)) {
                if (com1 == playerNumber.inputNumbers.get(i)) {
                    strikeCount++;
                } else {
                    ballCount++;
                }
            }
        }

        if (strikeCount == 0 && ballCount == 0) {
            return "낫싱";
        } else if (strikeCount == 0 && ballCount != 0) {
            return ballCount + "볼";
        } else if (strikeCount != 0 && ballCount == 0) {
            return strikeCount + "스트라이크";
        } else {
            return ballCount + "볼 " + strikeCount + "스트라이크";
        }
    }
}
