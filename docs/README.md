# Application.java
### 1. void isThreedigitnumbers(String input)
사용자가 입력한 문자열이 다음과 일치하는지 판단한다
1. 3글자인가?
2. 각 글자가 서로 다른 숫자로 이루어져 있는가?
3. 숫자로 변환 가능 한가?

위 내용에 부합하지 않으면 1,2는 if문을 이용해 IllegalArgumentException을 발생시킨다.
3번의 경우 parseint시 error가 발생되므로, try-catch문을 사용해 에러를 변환해 발생시킨다.

### 2. void isDigit(String input)
isThreeDigitNumbers와 유사하나. 3글자가 아닌 1글자여야 하며 자리수마다 비교하는 것이 불필요하기에 제외하였다.

### 3. boolean checkAnswer(List<Integer> computer,String input)
컴퓨터와 입력값이 숫자야구 룰에 따라 판단하여 정답 여부를 반환하는 함수이다.  
string을 list<Integer>형으로 각 자리수씩 요소들을 넣어주었고,
이중 포문을 통해 각 자리수 끼리 비교할 수 있도록 하였다.  
만약 같은 숫자를 발견했을 경우 각 인덱스가 같은 경우 strike,
다른경우 ball의 값을 1씩 더한다.  
이중 for문을 벗어나면 strike와 ball 수에 따라 출력 후 만약 strike가 3이라면 true를, 아니라면 false를 반환한다.