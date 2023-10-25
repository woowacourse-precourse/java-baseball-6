[기능: function() - Class] 포맷


- 게임 한 사이클 플레이 startGame() - NumberBaseballGame
  - 1)서로 다른, 2)3자리의 수: generateRandomThreeNumber() - RandomThreeDigitNumberGenerator (Randoms.pickNumerInRange() 활용!) 
  - "3스트라이크" 나올 때까지 계속 유저 입력 반복
    - 유저 숫자 입력: getUserInput() - UserGuessInput
    - 같은 숫자 (볼) 개수 체크 => 최종 볼 개수는, (볼 - 스트라이크) 개수
    - 1)같은 숫자 & 2)같은 위치 (스트라이크) 개수 체크
    - 볼, 스트라이크개수 표시: showResultPrompt() - Result 
      - case1) 3스트라이크 => 게임 종료
      - case2) 0볼 0 스트라이크 => "낫싱"
      - case3) 이외의 경우 (단, 스트라이크나 볼이 0개일때는 프린트되지 않음)
- 게임 재시작 여부
  - 유저의 게임 재시작 숫자 (1 과 2 중 하나의 수) 받아들이기 (Concole.readLine() 활용!)