1. 예외처리
   1. 사용자가 숫자를 입력할 때 정수 1-9 사이의 값을 입력하지 않은 경우 IllegalArgumentException 발생시킴.
   2. 사용자가 숫자를 '3자리' 입력하지 않은 경우 IllegalArgumentException 발생시킴.
   3. 한 게임을 마치고 1또는 2를 입력하지 않은 경우 IllegalArgumentException 발생시킴.

2. 사용 클래스
   1. java/baseballGame/Game
      전체 게임을 플레이하는 클래스
   2. java/constant/Constants
      게임 플레이에 사용되는 상수와 에러메시지를 관리하는 클래스