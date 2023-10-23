# 숫자 야구 게임

### 설계 구조
**Main.java**

static void main 함수 위치

**gameRunner/GameMachine.java**

게임을 실행 할 수 있는 함수가 담긴 클래스
여러개의 숫자야구게임(BaseBallGame)을 실행 할 수 있다.

**gameRunner/BaseBallGame.java**

하나의 숫자야구게임을 실행 할 수 있다.
하나의 숫자야구게임에는 하나의 숫자 야구 그룹 정답(AnswerBaseBalls)을 가지고 있다.

**domain/baseBalls/BaseBalls.java**

하나의 숫자 야구 그룹(BaseBalls)은 여러 개의 야구볼(OneBaseBalls)로 이루어져 있다.

```json
[{"number":3, "position": 1}, 
 {"number":7, "position": 2},
 {"number":2, "position": 3}]
```

**domain/baseBalls/AnswerBaseBalls.java**

하나의 숫자 야구 그룹이라는 속성을 가지므로 BaseBalls를 상속받는다.
이 숫자 야구 그룹은 숫자 생성기 (GameNumberGenerator)로 생성된다.

**domain/baseBalls/QuestionBaseBalls.java**

하나의 숫자 야구 그룹이라는 속성을 가지므로 BaseBalls를 상속받는다.
입력받은 ```List<Integer>``` 값을 이용하여 숫자 야구 그룹을 생성한다.
AnswerBaseBalls를 인자로 넣었을 경우,  매칭 결과를 알려주는 함수를 가지고 있다.
이 때 결과를 알려주는 로직이, QuestionBaseBalls의 멤버변수를 변경하기 때문에 매칭 결과를 알려주는 함수가 Answer가 아니라 Question에 존재한다.

**domain/baseBalls/QuestionBaseBalls.Result.java**

Question 숫자 야구 그룹을 인자로 들어온 Answer 숫자 야구 그룹과 매칭 한후 판단 결과를 저장하고 있다.

**domain/OneBaseBall.java**

하나의 야구볼은 number와 position으로 이루어져 있다.
이때 position을 멤버변수로 설정한 이유는, OneBaseBall이 모여서 List화 되었는데 한 개의 값이 사라지게 되면, 인덱스로 position을 판단하는게 불명확하다고 판단했기 때문이다.

```json
{"number":3, "position": 1}
```

**domain/BaseBallNumber.java**

야구볼의 숫자는 무조껀 1~9 사이의 수이어야 하기 때문에, 유저로부터 들어온 Input에 대한 validation을 진행한다.

**generator/GameNumbersGenerator.java**

숫자 생성기의 interface이다.

**generator/RandomGameNumbersGenerator.java**

숫자 생성기의 구현체이며, BaseBallGame이 갖고있는 GAME_NUMBERS_SIZE만큼의 ```List<Integer>```를 반환한다.

**generator/CustomGameNumbersGenerator.java** // 테스트코트

숫자 생성기의 구현체이며, Random 테스트가 어려운 점 때문에,  만들어졌다. 유저가 인자로 넣은 리스트를 반환한다.

**io/InputView.java**

게임시 유저에게 입력을 받을때의 함수들을 저장한다.

**io/OutputView.java**

게임시 인자로 받은 값의 출력을 해야할 때의 함수들을 저장한다.

**parsing/NumberParsing.java**

숫자로 이루어진 String을 Integer타입의 리스트로 파싱한다
InputView에서 받은 String을 QuestionBaseBall로 생성해야 했기 때문에 리스트로 변환해주는 작업이 필요했다. Util의 기능을 가지고 있으므로 static 함수로 만들었다.

### 구현할 기능 목록 : 나의 세미 이슈!

- [x] 1 : 컴퓨터가 게임을 하나 생성하기 : gameRunner.BaseBallGame.class
- [x] 2 : 3개의 숫자, 순서 배열을 하나로 묶는 단위 : domain.baseBalls.BaseBalls.class
- [x] 3 : 한개의 숫자의 단위 - 1~9 검증 : BaseBallNumber.class
- [x] 4 : gameRunner.BaseBallGame 클래스 하나에는 하나의 정답 domain.baseBalls.BaseBalls 객체가 들어간다.
- [x] 5 : 사용자로부터 GameNumbers를 입력 받기위한 출력문이 있다.
- [x] 6 : 사용자로부터 GameNumbers를 입력받는다.
- [x] 7 : BaseBallGame의 메소드로 들어온 domain.baseBalls.BaseBalls 객체의 결과를 리턴한다 10번과 중복
- [x] 8 : 리턴한 메소드를 받아서 결과를 출력한다.
- [x] 9 : 게임을 재시작하기 위한 사용자로부터의 입력을 받는다.
- [x] 10 : 숫자 판단의 결과인 스트라이크 볼 나싱을 분류하기 위한 객체 QuestionResult.java를 만들었다.
- [x] 11 : 컴퓨터가 랜덤한 domain.baseBalls.BaseBalls.class를 생성할 때 영향을 주는 Generator 만들기
- [x] 12 : 한개의 BaseBall은 위치와 숫자로 이루어짐 : domain.OneBaseBall.class
- [x] 13 : BaseBall은 Answer이냐, Question이냐에 따라 로직이 나뉘므로 상속으로 해결한다.
- [x] 14 : BaseBallNumber의 equal 로직을 오버라이드
- [x] 15 : 두개의 OneBaseBall사이의 strike ball 관계를 파악한다.

### 기능 요구사항

1. 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다
2. 같은 수가 같은 자리에 있으면 스트라이크, 다른자리에 있으면 볼, 같은수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(캄퓨터)의 수를 맞추면 승리한다.
   예) 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1 스트라이크, 456을 제시하는 경우 : 1 스트라이크 1볼, 789를 제시하는 경우 : 낫싱
3. 위 숫자 야구게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
4. 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
5. 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.



### 프로그램 실행 결과

```
숫자를 입력해 주세요: 123
1 스트라이크 1볼
숫자를 입력해주세요: 145
1볼
숫자를 입력해주세요: 671
2볼
숫자를 입력해주세요: 216
1 스트라이크
숫자를 입력해주세요: 713
3 스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.
1
숫자를 입력해주세요: 123
1 스트라이크 1볼
```