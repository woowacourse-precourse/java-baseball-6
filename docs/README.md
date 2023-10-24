# 구현할 기능 목록

## Controller

1. 게임을 제어하는 컨트롤러 - GameController
    * start(): 게임의 실행과 종료를 담당하는 함수
    * play(): 게임을 진행하는 함수
2. 사용자 화면을 제어하는 컨트롤러 - ViewController

## View

1. 입력을 담당하는 클래스 - InputView
    * Console의 readline()을 통해 입력을 받음
    * 입력 형식의 유효성을 검증
    * 검증이 끝난 사용자의 입력을 int Array로 리턴
2. 출력을 담당하는 클래스 - OutputView
    * 각종 상황에 따른 여러 출력을 담당
3. 예외 처리를 담당하는 클래스들 - exception
    * 예외 상황에 맞는 예외 메시지를 출력

## Model

1. 플레이어의 정보를 저장하는 클래스 - Player
    * 컴퓨터 플레이어 - ComputerPlayer
    * 사용자 플레이어 - UserPlayer
2. 게임 규칙에 따라 스트라이크/볼/게임종료를 판단하는 클래스 - Referee
    * judgeGameOver(): 정답을 맞춰 게임이 종료되었는지 판단하는 함수
    * judgeGameScore(): 스트라이크와 볼의 갯수를 count하는 함수

## Utils

* 문자열의 처리를 도와주는 메서드를 정의한 클래스 - StringUtils
    * parseStringToIntArray(): 문자열을 IntArray로 변환하여 return해주는 함수
