# 구현할 기능 목록

- [x] 컴퓨터 생성
  - [x] 3자리 랜덤 숫자 생성하기
  - [x] 컴퓨터 숫자 생성하기
- [x] 플레이어 생성
  - [x] 플레이어 숫자 입력 받기
  - [x] 플레이어 숫자 생성하기
- [x] 게임 진행하기
  - [x] ball 숫자 계산하기
  - [x] strike 숫자 계산하기
  - [x] ball, strike 출력하기
  - [x] 게임 결과 판단
    - [x] 3 스트라이크면 게임 종료하기
- [x] 재시작/종료
  - [x] 게임 커맨드 입력받기
  - [x] 커맨드가 1이면 재시작, 2면 종료하기

---

## Domain

Baseballs
- 컴퓨터 숫자, 플레이어 숫자 생성
- 볼, 스트라이크 개수 계산
  - Ball 객체와 협력

Ball
- 볼, 스트라이크 판단

GameStatus
- 게임 클리어 판단
  - 스트라이크 개수 사용
- 게임 종료 판단
  - GameCommand 객체와 협력

GameCommand
- 종료 여부 판단

## Input
InputView
- 입력에 관련된 요구사항 처리

## Output
OutputView
- 출력에 관련된 요구사항 처리

## Utils

Converter
- 자료형을 변환하는 클래스

NumberGenerator
- 랜덤한 숫자를 생성하는 클래스

Console
- 콘솔 입력, 출력을 처리하는 클래스