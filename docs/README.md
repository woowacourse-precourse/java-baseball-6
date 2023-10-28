# 자동차 경주

## 기능 목록

- 게임 세팅
  - [ ] 자동차 이름 입력 안내 문구 출력 - OutputView
  - [ ] 자동차 이름 입력 - InputView
  - [ ] 시도할 횟수 입력 안내 문구 출력 - OutputView
  - [ ] 시도할 횟수 입력 - InputView

- 게임 로직 처리
  - [ ] 무작위 숫자 생성 - RandomNumberGenerator
  - [ ] 차수 마다 자동차 전진 명령 - RacingManager
  - [ ] 자동차 무작위로 전진 - Car
  - [ ] 차수 실행 결과(자동차의 위치) 분석 - RacingManager
  - [ ] 차수 실행 결과 출력 - OutputView : printAttemptResult()
  - [ ] 차수 횟수 도달시 게임 종료

- 게임 종료시
  - [ ] 가장 멀리 간 자동차들 판별 - RacingManager : gameResult(), Car : compareTo()
  - [ ] 우승자 안내 문구 출력 - OutputView : showGameResult()

- 예외 처리
  - [ ] 자동차 이름 입력
  - [ ] 시도할 횟수 입력



## 해야할 일


- [x] TDD 학습
- [ ] 클래스 다이어그램 그리기
<img src='https://drive.google.com/uc?export=download&id=1iRAXmDhDeKPVf1bzERN_-zz9tWxHbdBW' width='' height=''/><br>
- [ ] 테스트 코드 추가
- [ ] 구현
- [ ] 객체지향 생활체조 원칙 적용
  - [ ] 한 메소드에 오직 한 단계의 들여쓰기(indent)만 한다.
  - [ ] else 예약어를 쓰지 않는다.
  - [ ] 모든 원시값과 문자열을 포장한다.
  - [ ] 한 줄에 점을 하나만 찍는다.
  - [ ] 줄여쓰지 않는다(축약 금지).
  - [ ] 모든 엔티티를 작게 유지한다.
  - [ ] 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
  - [ ] 일급 컬렉션을 쓴다.
  - [ ] 게터/세터/프로퍼티를 쓰지 않는다. 단, DTO는 허용한다.
  - [ ] 메소드의 인자 수를 최대 3개만 사용한다. 적을 수록 좋다.
  - [ ] 메소드가 한가지 일만 담당하도록 구현.
  - [ ] 클래스를 작게 유지하기 위해 노력. 50줄 이상이면 여러가지 일을 동시에 하고 있을 확률이 높다.
  - [ ] 메서드당 line을 10까지만 허용. 길이가 길어지면 메서드로 분리
  - [ ] 매직 리터럴 / 매직 넘버 사용을 자제하고 상수 사용

## 파일 구조

```
racingcar
├── Application.java
├── controller
│   └── RacingGameController.java : 게임 실행
├── domain
│   ├── GameResultAnalyzer.java : 게임 결과 분석
│   ├── RacingCar.java : 자동차 클래스
│   └── RandomNumberGenerator.java : 무작위 숫자 생성
├── exception
│   └── InvalidInputException.java : 유저 입력 예외 
└── ui
    ├── InputView.java : 화면 출력
    └── OutputView.java : 유저 입력
```

### 생각정리

**테스트가 쉽도록 리팩토링 하기**

랜덤값을 메소드 안에서 돌려버리면 테스트 하기 어렵다.
랜덤으로 나온 값을 매개변수로 받아서 동작하는 메소드로 만들면 테스트 하기 쉬워진다.

**입력값 검증의 책임**

InputView 에서는 기본적인 입력값 검증에 대한 책임이 있는게 확실해 보인다. (공백, 형식에 맞지 않는 입력 등)
그런데, 비즈니스 로직에 대한 검증의 책임은 누구한테 있는것일까? (길이 5자 이내, 1~9사이 등)

이름이 5자 안쪽이여야 한다는건 Car 때문에 생긴 제약일까 아니면 자동차 외부에서 정해진 규칙일까?

자동차에 이름을 새기려면 너무 길면 안되기 때문에 글자수 제한이 생긴거라고 생각하면,

RacingCar 생성시에 이름을 전달받고, 생성자에서 검증 로직을 구현하는것이 좋아보인다.
하지만, 생성자에서 특정 로직을 수행 하는것은 좋지 못하다.

해결방법 1. Name 클래스를 구현해서 이름 글자수 검증에 대한 책임을 이전하는 것이다.
하지만 이 경우 불필요한 코드만 많아지는 느낌이다.
해결방법 2. 컨트롤러에서 검증을 수행한 후 오류가 발생하지 않는 이름으로 RacingCar에게 전달한다.
다른 도메인 로직에 validator 클래스를 구현한 후 컨트롤러에서 이름 검증을 해서 전달한다.

2번은 매번 하던 방법인거 같으니 1번 방법으로 해보자.

- [참고](https://tecoble.techcourse.co.kr/post/2020-04-28-ask-instead-of-getter/)
- [참고2](https://www.slipp.net/questions/559)
- [참고3](https://www.slipp.net/questions/565)
- [토스ㅣSLASH 21 - 실무에서 바로 쓰는 Frontend Clean Code](https://www.youtube.com/watch?v=edWbHp_k_9Y&t=25s)
위 영상과 글들, 객체지향의 오해와 진실 책, 그리고 Clean Code 책을 보고,
객체지향의 올바른 설계와 TDD 방법론을 따르기 위해, 코드를 모두 갈아엎고 설계 단계부터 다시 시작하기로 했다.

> 목표 1. 모든 객체가 서로 협력할떄, 메세지를 전달하고 전달받으며 세부 로직은 서로 모르는 상태가 되는 것.
> 목표 2. 테스트가 용이하도록 구현하기 위해 코드 구현하기 전에 단위 테스트를 먼저 작성

<img src='https://drive.google.com/uc?export=download&id=1iRAXmDhDeKPVf1bzERN_-zz9tWxHbdBW' width='' height=''/><br>

다음과 같이 간단한 클래스 다이어그램을 먼저 그려서 객체들의 책임에 대해 정리했다.

이제 테스트 코드를 작성할 차례이다.
