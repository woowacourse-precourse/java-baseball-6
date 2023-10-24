package baseball;

public class InputVerify {
    public static boolean checkInput(String input) {
        boolean[] usedNumbers = new boolean[10];

        if(input.length() != 3)
            return false;
        if(!input.chars().allMatch(Character::isDigit))
            return false;
        for(int i=0; i<3; i++) {
            int currentNumber = input.charAt(i)-'0';
            if(usedNumbers[currentNumber])
                return false;
            usedNumbers[currentNumber] = true;
        }
        return true;
    }
}
