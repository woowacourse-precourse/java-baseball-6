# 숫자 야구 게임

## 구현할 개발 기능 목록

1. 확장성 고려한 파일 구조 설계
   * `baseball` > `numberBaseball` > `game` 순으로 기능 별로 분리 합니다.
   * `type`, `extension` 파일 분리를 통하여 관리 합니다. 

2. interface 를 통한 숫자 야구 게임 기능 구현
   * `playGame()` : 숫자 야구 게임을 시작 합니다. 랜덤 숫자를 생성 하고, 초기화 작업을 진행 합니다.
   * `gameOver()` : 숫자 야구 게임을 종료 합니다. 
   * `gameRestart()` : 숫자 야구 게임의 재시작 여부를 확인 합니다.
   * `gamePlaying()` : 숫자 야구 게임 유저의 입력 값을 유효성 검사한 후 리스트 추가 합니다.
   * `gameResult()` : 유저의 입력 값과 랜덤 으로 생성된 숫자와 비교 하여 판정 결과를 출력 합니다.

## 문제 해결

#### [10/22]
* gamePlaying(), gameResult() 함수 Algorithm 구현 완료
* `illegalArgumentException`과 try, catch 구문 추가로 기본 예외 처리 완료

#### [10/23] 
* gameOver(), gameResult() 함수 에서 발생한 strike, ball 초기화 문제를 해결 완료
* gameResult() 함수를 내부 while 문으로 이동 하여 출력 에러 해결 완료

#### [10/24] 
* gameRestart() 함수와 playAgain 변수 에서 발생한 재시작 오류 해결 완료

## 개선 요망

* strike, ball 초기화 함수 필요
* gameResult() 함수 내부 If 구문 refactoring 필요 