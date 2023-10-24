package model;

public class PlayerNumbers {

    public String getNumbers() {
        return "";
    }

    public void validatedNumber(String playerNumbers) {
        if (!countNumber(playerNumbers) && duplicatedNumber(playerNumbers) && isNumber(playerNumbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isNumber(String playerNumbers) {
        for (int i = 0; i < playerNumbers.length(); i++) {
            if (playerNumbers.charAt(i) < 48 || playerNumbers.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }

    private boolean duplicatedNumber(String playerNumbers) {
        for (int i = 0; i < playerNumbers.length(); i++) {
            for (int j = i + 1; j < playerNumbers.length(); j++) {
                if (playerNumbers.charAt(i) == playerNumbers.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean countNumber(String playerNumbers) {
        return playerNumbers.length() == 3;
    }
}
