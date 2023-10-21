설계
1회차
프로그램 흐름도

1. 시작
2. 상대 수 생성하기. (targetNumber)
3. 플레이어 수 입력 받기. (myNumber)
4. 예외 처리. (IllegalArgumentException을 발생)
4. 수 비교. (myNumber) -> [strike, ball, miss]
5. 힌트 생성. [strike, ball, miss] -> (hint)
6. 힌트 출력.
6. 정답 여부 확인. 정답시 7번이동.
7. 다시 시작 여부 확인(1 시작 , 2 종료)

model(Computer)

1. 필드 : targetNumber
2. 생성자 : targetNumber를 생성
   -> camp.nextstep.edu.missionutils.Randoms의
   pickNumberInRange()을 활용한다.
3. CompareNumber
   -> 플레이어측 수를 비교해 배열 생성
4. MakeHint
   -> 배열을 문자열로 반환

controller(Application)
camp.nextstep.edu.missionutils 모듈 사용

1. player 객체 생성
2. myNumber 생성
   -> camp.nextstep.edu.missionutils.Console의
   readLine()을 활용한다.
3. if 문을 이용해 myNumber을 판별한다.
4. 수를 비교한다.
   -> baseball 클래스에 CompareNumber 이용
5. 힌트를 생성한다.
   -> baseball 클래스에 MakeHint 이용
6. Hint 출력
7. if 문을 이용해 3 strike 시 종료 .

---------------------------------------
2회차

2차 작업 중 생각난 할 것들

1. application 에서 모두 담당하려하지말고 game을 만드는 새로운 클래스를 만들자.
2. compareNumber로 [strike , ball, miss] 를 반환했는데 miss가 필요없다.
3. compareNumber에서 MakeHint를 호출해서 string을 반환하자.
4. input 처리도 따로 클래스를 만들자.

controller(Game)

1. 이전 Application의 기능.
2. main 에서 계속해서 호출하여 게임을 실행하도록 만들자.

model(Input)
Input은 예외를 발생시킨다.
camp.nextstep.edu.missionutils.Console의
readLine()은 String을 반환하는데 이를 int값으로 변환 시켜야한다.

주요기능

1. 게임 도중 3자리 수를 받는 input
   -> input이 3자리수인가?, 모두 숫자인가? , 서로 다른가?를 판별
   -> 모든 질문에 통과한다면 int를 반환, 만약 실수한다면 각각 예외를 발생시켜야함.

2. 게임이 끝난 후 exit code를 받는 input
   -> input이 1자리수인가?, 모두 숫자인가? , 1혹은 2인가?를 판별
   -> 모든 질문에 통과한다면 int를 반환, 만약 실수한다면 각각 예외를 발생시켜야함.

부족한 점
-> 자바를 안다룬지 너무 오래되어서 static class로 구현할 만한 것들을 class로 구현함.
-> 충분히 더 작은 단위로 함수를 쪼갤수 있음. 한 함수 함수 하나가 너무 큰 단위로 이루어짐.

추후
클래스, 함수 나누기, test 추가하는 것 필요.
----------
3회차
./gradlew clean test 실행, 오류 발생

수정사항
오류 수정

1. 오류 체크를 위해 게임시작 시 미리 게임의 답이 보이도록 만들어놨었음.
   -> 해당 부분 제거
2. 예외를 던지고 예외처리를 해서 정상 종료되도록 만들었었는데 해당 부분에서 오류발생.
   -> try catch문 제거

리팩토링

1. 각 함수의 내부를 살펴보며 각 부분별 기능을 주석으로 정리하자.
2. 주석을 적은 부분에 대해 각각 함수로 만들자.
3. 효율성을 위한 코드를 추가하자.




