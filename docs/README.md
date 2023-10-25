## 📙 미션 - 숫자 야구

### 💡 기능 구현

<br>

### 📃 Computer -> 랜덤으로 입력
1. 랜덤으로 입력한 값을 List에 저장.
2. 저장을 할 때 반드시 중복되지 않도록 함. 만약 중복된다면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료.
3. 그 이외에도 3자리 숫자를 입력하도록 해야함.
   <br>

***

### 📃 Player -> 입력할 숫자
1. 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.
2. 마찬가지로 각 자리 숫자에 중복 없애고 입력 값의 길이가 3, 숫자여야 함 아니면 IllegalArgumentException을 발생.

😱 생각하지 못한 것
player 입력 값을 받는 playerNumber를 int로 해서 시작을 했었다. int로 하니 이 변수에 대한 요구사항을
맞추려고 할 때마다 계속 String으로 바꿔줬다. (입력하는 숫자 타입이 int여야 한다는 고정관념에 박혔었음.)
<br>

***

### 📃 입력할 View와 출력할 View를 만들어줌.

### input
1. 숫자를 입력할 input 생성.
2. 3스트라이크로 게임이 끝났을 때 "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 생성.
   <br>

### output
1. 모든 출력 문구들을 넣어줌.
2. input과 관련된 것들을 넣으면 X.

😱 생각하지 못한 것
input과 output의 클래스를 따로 구분해서 로직을 구현한 것은 처음봤다.
<br>

***

### 📃 스트라이크, ball 개수 카운트 -> NumberCompare
1. 스트라이크는 computer의 인덱스 값이 player의 인덱스 값과 같은지 확인하고 같으면 strikeCnt++.
2. 볼은 computer에 player 문자가 존재하면 ballCnt++
   <br>

😇 해결
정답일 맞힌 경우 '3스트라이크'만 나와야 하는데 '3볼 3스트라이크'로 출력해서 이유를 파악하는데 시간이 좀 걸림.
로직에서 숫자를 포함하면 +하기로 했기 때문에 당연히 볼이 + 된 것.
<br>

***

### 📃 strike와 ball, 낫싱 카운트 로직
1. 배열로 만든다. count[0]이 볼 카운트 값, count[1]이 스트라이크 값.
2. 스트라이크가 0이 아니면 볼 개수 카운트하고 printStrike() 출력.
3. 볼 개수가 0이 아닐 때 스트라이크도 0이 아니면 printBallAndStrike() 출력.
4. 볼 개수가 0이 아닐 때 스트라이크도 0이면 printBall() 출력.
5. 낫싱은 모두 0이 아닐 때 출력.
<br>

***

### 📃 RestartNum
1. 1, 2를 입력하지 않았을 때 예외 터뜨림.
<br>

***

### 📃 Validator
1. 3스트라이크면 게임을 재시작해야 하기 때문에 boolean으로 여부 판단.
2. count[] 배열을 가져오는 함수 구현. (BaseballGame 컨트롤러에서 비교한 값을 반환 하기 위함.)
<br>

***

### 📃 BaseballGame
1. gameStart() 에서 player가 입력한 값을 가져오고 카운트 한 볼, 스트라이크 여부를 출력. (전체 진행 과정)
2. count 배열에서 어떻게 하면 볼이고 스트라이크, 낫싱인지 판단.
3. 3스트라이크면 게임 끝. 다시 시작.
<br>

😱 생각하지 못한 것
상수, static 변수 생각없이 변수를 생성하고 객체를 생성했다.
숫자를 입력했을 때 볼과 스트라이크에 대한 결과 이후 '게임 새로 시작'이 출력됨.

***
<br>
<br>

### < 폴더 구조 >

```
├─main
│  └─java
│      └─baseball
│          │--Application.java (게임 시작)
│          │
│          ├─controller
│          │  -  BaseBallGame.java (실행 동작 구조)
│          │
│          ├─model
│          │  -  Computer.java (랜덤으로 숫자 3개 가져와 List에 삽입하고 반환)
│          │  -  Player.java (사용자가 입력한 숫자와 Valid)
│          │  -  RestartNum.java (게임 새로 시작할 때의 숫자 + Valid)
│          │  -  (Application에서 equals로 여부 판단.)
|          |
│          ├─validator
│          │  -  NumberCompare.java (볼과 스트라이크 수 카운트)
│          │  -  Validator.java (볼과 스트라이크 수에 대한 결과)
│          │
│          └─view
│                  Input.java (사용자가 입력할 숫자)
│                  Output.java (출력할 모든 메세지)
│
└─test
    └─java
        ├─baseball
        │   -   ApplicationTest.java
```
