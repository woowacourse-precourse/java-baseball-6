# 1주차
## 숫자 야구
클래스를 활용해 기능 별로 코드를 나누어 작성하는 연습을 했습니다.
### 클래스 및 메소드 설명
1. Application
   1. checkIfRightInput : 사용자가 숫자를 입력하면 해당 숫자가 옳은 것인지 CheckRightInput 클래스를 선언해 검사하도록 했습니다.
   2. makeAnswer : 컴퓨터가 정답을 만드는 메소드입니다. Set을 이용해 중복을 제거한 뒤 StringBuilder을 이용해 숫자를 문자열로 만들어 줬습니다.
   3. main : 기본적인 프로그램이 시작하는 부분입니다. while문을 이용해 게임의 전반적인 흐름을 제어하는 코드를 작성했습니다.
2. CheckRightInput : 사용자가 입력한 숫자가 옳은 것인지 확인하는 클래스입니다.
   1. 생성자 : 객체가 생성되자마자 오류가 존재하는지 확인하도록 checkInputLength()와 checkInputDigit()을 실행하도록 합니다.
   2. checkInputLength() : 입력한 숫자의 길이가 3이 되지 않으면 IllegalArgumentException을 반환하도록 합니다.
   3. checkInputDight() : 입력한 숫자가 전부 숫자인지 확인합니다. 0 또한 검사를 해줘야 하나 고민했지만, 숫자를 입력하라고 했으니 exception은 throw하지 않는 것으로 했습니다. 
3. Game : 게임이 시작되어 점수를 계산하는 클래스입니다.
   1. calScore : strike 수를 세는 메소드인 strike()와 ball 수를 세는 메소드인 ball()을 실행하고 반환한 값을 Score 객체에 담아 return합니다.
   2. strike : 컴퓨터가 제작한 answer과 사용자가 입력한 userNum을 비교합니다. 이때 boolean 배열을 반환하는 이유는 ball을 셀 때 strike로 지정된 수는 고려하지 않기 위함입니다.
   3. ball : strike에서 고려된 수는 true로 표시된 배열과 고객의 수를 받아 비교합니다. 이때 ball의 숫자들은 집합의 교집합인 retainAll()을 이용해 구하였습니다.
4. Score : 과거에는 calScore에 크기가 2인 배열을 만들어 인덱스 0은 strike의 수, 1은 ball의 수를 넣어주었습니다. 
           하지만, ***외부에서 봤을 때 무엇이 strike이고 ball인지 파악하기 어려운 문제***가 생겼습니다. 그렇기에 Score 클래스에 strike와 ball 변수를 마련해 외부에서 봤을 때도 쉽게 구분할 수 있게 하였습니다.

