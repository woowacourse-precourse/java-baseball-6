package baseball.util;

public enum UserInputEnum {
    RESTART("1"),
    EXIT("2");

    private final String value;


    UserInputEnum(String value){
        this.value = value;
    }

    public static UserInputEnum fromString(String input){
        for (UserInputEnum inputEnum : UserInputEnum.values()){
            if(inputEnum.getValue().equals(input)){
                return inputEnum;
            }
        }
        throw new IllegalArgumentException("잘못된 값을 입력했습니다" + " you input = " + input);
    }

    public String getValue() {
        return value;
    }
}
