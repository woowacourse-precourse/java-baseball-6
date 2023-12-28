package baseball.dto;

public class PlayerBallRequestDto {

    private String number;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        validateNumberFormat(number);
        this.number = number;
    }

    private void validateNumberFormat(String number) {
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
