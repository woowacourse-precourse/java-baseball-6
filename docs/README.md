# 클래스 설계 및 초기 기능 목록

## GameManager

- 프로그램의 전체적인 시행 흐름, 예외 처리, 종료 이벤트 등을 관리함
- 최종 application에서 실행될 대상
- 게임의 진행/종료 여부인지에 따라 케이스를 분기

## GameStatusValue

- [ ]  게임의 재시작/종료 여부를 저장

## GameExceptionMessage

- [ ] 게임 진행 중 발생하는 예외 메세지를 상태별로 저장하는 enum
    - BallFormatException 등 각각 케이스별로 에러를 만들면 다양한 에러 케이스를 확장하기 좋겠지만, 요구사항에 따라 모든 에러가 IllegalArgumentException으로 통합되어야
      하므로, enum으로 관리함
- [ ] IlligalArgumentException이 발생하는 케이스를 분기한 예외 메세지를 저장하는 기능

## ConsoleManager

- [ ] 게임시작, 종료, 재시작 메세지를 출력하는 기능 (GameStatusValue에 따라 분기)
- [ ] 입력을 위한 출력 메세지를 화면에 나타내는 기능
- [ ] 사용자가 입력한 값이 유효값인지 검증하는 기능
- [ ] BaseBallNumber와 GameStatusValue를 비교하여 게임 재시작인지, 종료인지 판별하는 기능
- [ ] 비교 가능한 세 자리 숫자가 들어왔을 때 정답 나올 때까지 게임을 진행하는 기능
- [ ] 사용자가 숫자를 입력할 때마다 결과를 출력하는 기능
- [ ] 게임 종료 메세지를 출력하는 기능

## Score

- [ ] 볼, 스트라이크 수를 필드로 가짐
- [ ] 사용자의 현재 점수를 저장
- [ ] 사용자의 현재 점수를 반환

## ScoreManager

- [ ] Score 객체를 멤버 변수로 가짐
- [ ]  사용자가 맞춘 경우 점수 상태를 갱신
- [ ]  ScoreCalculator에서 계산한 점수를 Score 객체에 전달
- [ ]  사용자의 최종 점수를 반환

## ScoreCalculator

- [ ] 두 BaseBallNumber 객체를 비교하여 자리 수 별로 일치 여부를 비교하는 기능
- [ ] 비교 결과를 볼, 스트라이크, 낫싱의 경우로 나누어 판단하는 기능

## ListUtility

- [x] List 구조로 전달된 데이터들을 가공하는 기능을 모아두는 클래스
- [x] List<Integer> 형태로 자리수 별로 나누어 저장하는 기능
- [x] List → parse to int mapper로 최종 비교값을 int로 리턴
- [x] 리스트 내부의 중복을 제거하는 스트림을 생성하는 기능

## BallNumber

- [x] List 자료구조로 내부 구현
- [x] 숫자를 리스트에 자리수마다 저장하는 기능
- [x] 입력된 자리수의 숫자를 반환하는 기능
- [x] 특정 숫자를 입력하면 그 숫자가 리스트 내부에 포함되어 있는지 비교하는 기능

## InputVerifier(Interface of BaseBallVerifier, GameStatusVerifier)

- [x] 숫자인지 판별하는 기능, 숫자가 아닌 경우 예외 발생
- [x] 111 ~ 999 사이의 숫자인지 판별하는 기능, 범위를 벗어난 경우 예외 발생
- [x] 3자리 수라면 서로 다른 숫자인지 판별하는 기능, 중복된 숫자가 있는 경우 예외 발생

## BallNumberVerifier

- [ ] 사용자의 입력값이 111 ~ 999 사이의 숫자인지 확인
- [ ] 사용자의 입력값이 서로 다른 3개의 수인지 확인
- [ ] 사용자의 입력값이 게임 재시작인지 확인
- [ ] 사용자의 입력값이 게임 종료인지 확인

## RandonNumberGenerator

- [x] 유저가 맞출 숫자를 생성하는 객체
- [x] Randoms 라이브러리 메소드를 이용해 3자리 난수 생성

