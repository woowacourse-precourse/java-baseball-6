package baseball;

import java.util.ArrayList;
import java.util.List;

public class InputValidation{

    private final List<Integer> validationList;

    public InputValidation(String console) {

        if (console.length() == 3 && console.chars().noneMatch(Character::isLetter)) {

            validationList = new ArrayList<>();

            for (int i = 0; i < 3; i++) {

                int element = Integer.parseInt(String.valueOf(console.charAt(i)));

                if (!validationList.contains(element))
                    validationList.add(element);
                else
                    throw new IllegalArgumentException();
            }

        } else
            throw new IllegalArgumentException();
    }

    public List<Integer> getValidationList() {
        return validationList;
    }
}
