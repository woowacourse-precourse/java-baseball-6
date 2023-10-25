package baseball.domain.dto;

public class UserInputDto {
    private String userInput;

    public UserInputDto(String userInput) {
        this.userInput = userInput;
    }

    public String getUserInput() {
        return userInput;
    }
}
