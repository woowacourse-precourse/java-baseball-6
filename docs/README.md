1. 숫자 선택
   1. camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용하여 1부터 9까지 서로 다른 수로 이루어진 3자리 수를 할당한다.

2. 숫자 입력
   1. camp.nextstep.edu.missionutils.Console의 readLine()을 활용하여 숫자를 입력받는다.
   2. 입력받은 숫자가 3개가 아닐 경우 IllegalArgumentException을 발생시킨다.

3. 볼 카운트
   1. 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 없으면 낫싱을 출력한다.
   2. 3개의 숫자를 모두 맞히면 게임을 종료시킨다.

4. 게임 실행
   1. 게임 종료 후 1 또는 2를 입력하여 게임을 다시 시작하거나 완전히 종료한다.