# 자동차 경주

## 기능 목록

- 게임 세팅
  - [x] 자동차 이름 입력 안내 문구 출력
  - [x] 자동차 이름 입력
  - [x] 시도할 횟수 입력 안내 문구 출력
  - [x] 시도할 횟수 입력

- 게임 로직 처리
  - [x] 무작위 숫자 생성
  - [x] 차수 마다 자동차 전진 명령
  - [x] 자동차 무작위로 전진
  - [x] 차수 실행 결과(자동차의 위치) 분석
  - [x] 차수 실행 결과 출력
  - [x] 차수 횟수 도달시 게임 종료

- 게임 종료시
  - [x] 가장 멀리 간 자동차들 판별
  - [x] 우승자 안내 문구 출력

- 예외 처리
  - [x] 자동차 이름 입력
  - [x] 시도할 횟수 입력

## 클래스 다이어그램
<img src="https://drive.google.com/uc?export=download&id=1dyQl5DYD31gapDS3C51iSa2HAisS4Wtc"/>

## 파일 구조

```
├── Application.java
├── RacingGameController.java
├── domain
│         ├── Car.java
│         ├── Cars.java
│         ├── Engine.java
│         ├── RacingManager.java
│         └── numbergenerator
│             ├── NumberGenerator.java
│             ├── RandomNumberGenerator.java
│             └── SetNumberGenerator.java
└── view
    ├── InputView.java
    └── OutputView.java
```

## 해야할 일

- [x] TDD 학습
- [x] 피드백 받은것 학습
- [x] 클래스 다이어그램 그리기
- [x] 테스트 코드 추가
- [x] 구현
- [ ] 객체지향 생활체조 원칙 적용
  - [x] 한 메소드에 오직 한 단계의 들여쓰기(indent)만 한다.
  - [x] else 예약어를 쓰지 않는다.
  - [ ] 모든 원시값과 문자열을 포장한다.
  - [x] 한 줄에 점을 하나만 찍는다.
  - [x] 줄여쓰지 않는다(축약 금지).
  - [ ] 모든 엔티티를 작게 유지한다.
  - [x] 3개 이상의 인스턴스 변수를 가진 클래스를 쓰지 않는다.
  - [x] 일급 컬렉션을 쓴다.
  - [ ] 게터/세터/프로퍼티를 쓰지 않는다. 단, DTO는 허용한다.
  - [x] 메소드의 인자 수를 최대 3개만 사용한다. 적을 수록 좋다.
  - [x] 메소드가 한가지 일만 담당하도록 구현.
  - [ ] 클래스를 작게 유지하기 위해 노력. 50줄 이상이면 여러가지 일을 동시에 하고 있을 확률이 높다.
  - [x] 메서드당 line을 10까지만 허용. 길이가 길어지면 메서드로 분리
