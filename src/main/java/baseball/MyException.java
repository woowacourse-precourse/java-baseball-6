package baseball;

public class MyException {
    public void ballException(char[] myAnswer){
        //myAnswer 서로 다른 수가 아닐때 or 3자리수 아닐때 에러 발생 or 문자 드가면 에러발생
        for (int i = 0; i < myAnswer.length; i++) {
            if(myAnswer[i]<'1'||myAnswer[i]>'1'+8){
                throw new IllegalArgumentException("범위 내 숫자가 아님");
            }
        }

        if(myAnswer.length!=3){
            throw new IllegalArgumentException("3자리수가 아닙니다.");
        }
        if(myAnswer[0]==myAnswer[1] || myAnswer[1] == myAnswer[2] || myAnswer[0] == myAnswer[2]){
            throw new IllegalArgumentException("같은 수 존재");
        }
    }

    public void endOrRestartException(int n){
        if(n!=1 && n!=2){
            throw new IllegalArgumentException("범위내 숫자가 아님");
        }
    }
}
