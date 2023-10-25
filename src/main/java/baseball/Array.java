package baseball;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;
public class Array {
    int[] answer = new int[3];
    int[] userInput = new int[3];

    void getRandomAnswer(){
        int newNum;
         int answerIndex = 0;

         while(answerIndex < 3) {
             newNum = pickNumberInRange(1, 9);

             if(!isValueInArray(newNum, answer)) {
                 answer[answerIndex] = newNum;
                 answerIndex++;
             }
         }
     }

     static boolean isValueInArray(int input, int[] arr) {
         for (int i : arr) {
             if (input == i) return true;
         }
         return false;
     }

     void getUserInput(){
        String strInput = readLine();
        throwError(strInput);

        for(int i = 0; i < 3; i++)
            userInput[i] = strInput.charAt(i) - '0';
     }

     void throwError(String str){
        checkInputDuplicates(str);
        checkInputFormat(str);
        checkInputLength(str);
     }

    void checkInputDuplicates(String str) {
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < 3; j++) {
                if (str.charAt(i) == str.charAt(j))
                    throw new IllegalArgumentException();
            }
        }
    }

    void checkInputLength(String str){
        if (str.length() != 3)
            throw new IllegalArgumentException();
    }

    void checkInputFormat(String str) {
        for (int i = 0; i < 3; i++) {
            if ('1' > str.charAt(i) || str.charAt(i) > '9')
                throw new IllegalArgumentException();
        }
    }
}