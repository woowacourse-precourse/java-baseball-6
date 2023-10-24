package baseball;

public class NumberValidate {
    public static Integer MAX_VALUE = 9;
    public static Integer MIN_VALUE = 1;
    public static boolean isInRange(int givenNumber) {
        return MIN_VALUE <= givenNumber && givenNumber <= MAX_VALUE ;
    }

    public static boolean isNumber(String number) {
        try{
            Integer.parseInt(number);
            return true;
        }catch (NumberFormatException e){
            System.out.println(e+"숫자가 아님");
            return false;
        }
    }
}
