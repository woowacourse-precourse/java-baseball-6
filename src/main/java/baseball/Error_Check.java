package baseball;

public class Error_Check {
    public static void Exit_input_check(String input)
    {
        if(input.equals("1")||input.equals("2"))
        {
            System.out.println(input);
            return;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }
    public static int num_input_check(String input)
    {
        int number;
        try{
            number = Integer.parseInt(input);

        }
        catch (NumberFormatException ex) {
            throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
        }
        if(input.length()==3)
        {
            if(input.charAt(0)==input.charAt(1)||input.charAt(0)==input.charAt(2)||input.charAt(1)==input.charAt(2)) {
                throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
            }
            System.out.println(input);
            return number;
        }
        throw new IllegalArgumentException("유효하지 않은 값을 입력하셨습니다. 프로그램을 종료합니다.");
    }
}
