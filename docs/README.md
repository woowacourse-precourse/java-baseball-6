구현할 기능 목록
1. 컴퓨터는 1에서 9까지 서로 다른 임이의 수 3개 선택 -> camp.nextstep.edu.missionutils.Randoms의 pickNumberInRange()를 활용
2. 사용자 값을 입력받아 결과 출력 -> camp.nextstep.edu.missionutils.Console의 readLine()을 활용
3. 숫자 맞힐 때까지 반복, 맞힌다면 다시 시작 or 종료 선택
4. 사용자 잘못된 값 입력하면 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료

<입력 요구사항>
서로 다른 3자리의 수
게임이 끝난 경우 재시작/종료를 구분하는 1과 2 중 하나의 수

<출력 요구사항>
게임 시작 시 "숫자 야구 게임을 시작합니다." 출력
입력한 수에 대한 결과 표시 (ex. 낫싱, 1볼 1스트라이크)

성공 시
"3스트라이크
3개의 숫자를 모두 맞히셨습니다! 게임 종료
게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요." 출력
