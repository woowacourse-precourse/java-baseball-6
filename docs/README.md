# 자동차 경주

# 기능 목록

- 게임 세팅
  - [x] 자동차 이름 입력
  - [x] 시도할 횟수 입력

- 게임 로직 처리
  - [x] 자동차 별로 무작위로 전진
  - [x] 이동 후 차수별 실행 결과(자동차의 위치) 출력
  - [x] 차수 횟수 도달시 게임 종료

- 게임 종료시
  - [x] 가장 멀리 간 자동차들이 우승
  - [x] 우승자 안내 문구 출력

- 예외 처리
  - [x] 자동차 이름 입력
  - [x] 시도할 횟수 입력

# 해야할 일

- [ ] 테스트 코드 추가
- [ ] 객체지향 생활체조 원칙 적용
- [ ] 클린코드 원칙 적용
- [ ] 클래스, 메소드 별 역할 구분

## 클래스 역할

- RacingCar.java : 자동차 추상 클래스
  - 속성: 이름, 현재 위치
  - 메소드: 랜덤으로 움직이는 메소드, 이름 반환, 위치 반환

## 파일 구조

- Application.java
- controller
  - RacingGameController.java
- domain
  - RacingCar.java
  - RandomNumberGenerator.java
  - GameResultAnalyzer.java
- ui
  - InputView.java
  - OutputView.java

