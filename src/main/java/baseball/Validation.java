package baseball;

public class Validation {
    private Boolean validation(String input) {
        if (input.length() == 3) {
            try {
                Integer.parseInt(input);
            } catch (Exception e) {
                return false;
            }
        } else {
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (input.charAt(i) == '0') {
                return false;
            }
        }
        return true;
    }

    public Boolean isValid(String input) {
        return validation(input);
    }
}
