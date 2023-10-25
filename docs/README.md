# woowacourse java-baseball-6

## Description
숫자 야구 게임

## Environment
java 17.0.2

## Funtions List
### getRandom()
- 랜덤한 숫자 찾는 함수
- 각 자리의 숫자가 1 ~ 9 범위를 가지고 서로 다른 수로 이루어진 3자리의 수 반환

### playBaseBallGame()
- 서로 다른 수로 이루어진 3자리의 수 입력
- 입력한 값과 getRandom()으로 얻은 값 비교
	1. 같은 수가 같은 자리에 있으면 스트라이크 증가
	2. 같은 수가 다른 자리에 있으면 볼 증가
	3. 같은 수가 모든 자리에 없으면 낫싱 출력

### main()
- getRandom()으로 랜덤한 숫자 찾기
- playBaseBallGame()을 통해 숫자 입력 후 스트라이크와 볼의 결과를 출력
- 정답을 맞춰서 스트라이크가 3이 될 때까지 playBaseBallGame()을 반복
- 정답을 맞춘 후 다음 게임의 여부를 숫자 입력으로 결정
	1. 1을 입력하면 재게임
	2. 2를 입력하면 종료
	3. 1과 2를 제외한 나머지를 입력하면 IllegalArgumentException 에러 발생

