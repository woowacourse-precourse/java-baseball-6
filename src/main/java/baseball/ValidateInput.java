package baseball;

public class ValidateInput {
    public static void validateDuplicate(String input) {
        if (input.length() != input.chars().distinct().boxed().toList().size()) {
            throw new IllegalArgumentException(String.format("중복된 문자가 존재합니다. - [%s]", input));
        }
    }

    public static void validate(String input, String regex, String errorMessage) {
        if (!input.matches(regex)) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}


