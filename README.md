# 기능 구현 목록

1. 숫자야구 게임의 Rule, 공의 범위, 등등을 담은 Enum class
2. 숫자야구 게임에 대한 전반적인 기능을 해줄 PlayBaseballGame class
   1. 게임 이용자의 숫자 input
   2. 정답과 얼마나 일치하는지 확인하는 countMatch
   3. 스트라이크, 볼의 개수를 출력해줄 printResult
   4. 오류를 검증해줄 findErrors
3. 오류처리 로직들이 들어있는 FindError class
4. 절차에 따라 PlayBaseballGame에 들어있는 로직을 실행시켜주는 StartNewGame class
