# 숫자 야구 게임

**Main.java**

**gameRunner/GameMachine.java**

게임을 실행 할 수 있는 함수

**gameRunner/BaseBallGame.java**

하나의 숫자야구게임을 실행

**domain/baseBalls/BaseBalls.java**

BaseBalls은 여러 개의 OneBaseBalls로 이루어짐

**domain/baseBalls/AnswerBaseBalls.java**

BaseBalls를 상속
숫자 생성기 (GameNumberGenerator)로 생성

**domain/baseBalls/QuestionBaseBalls.java**

하나의 숫자 야구 그룹이라는 속성을 가지므로 BaseBalls를 상속

**domain/baseBalls/QuestionBaseBalls.Result.java**

Question 숫자 야구 그룹을 인자로 들어온 Answer 숫자 야구 그룹과 매칭 한후 판단 결과를 저장

**domain/OneBaseBall.java**

하나의 야구볼은 number와 position으로 이루어짐

**domain/BaseBallNumber.java**

사용자로부터 들어온 Input에 대한 validation을 진행

**generator/GameNumbersGenerator.java**

숫자 생성기의 interface

**generator/RandomGameNumbersGenerator.java**

숫자 생성기의 구현체

**generator/CustomGameNumbersGenerator.java** // 테스트코트

숫자 생성기의 구현체

**io/InputView.java**

**io/OutputView.java**

**parsing/NumberParsing.java**

숫자로 이루어진 String을 Integer타입의 리스트로 파싱


### 실행 결과

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