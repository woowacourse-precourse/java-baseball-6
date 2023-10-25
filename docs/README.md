숫자 야구 게임 구현 기능 목록

게임 시작
    '숫자 야구 게임을 시작합니다.' 출력
    '숫자를 입력해주세요 : ' 출력

게임 재시작 / 프로그램 종료
    '게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.' 출력
    missionutils.Console의 readLine 사용하여 입력값을 받음
    1이면 게임 재시작, 2이면 프로그램 종료
    1,2 이외의 값이면 IllegalArgumentException 예외 발생

Random 값 추출
    generateRandomNumber 메서드 생성
        각 자릿수가 다른 random한 세자리  숫자 리스트 생성
        missionutils.Randoms의 pickNumberInRange() 사용하여 random num 생성
        생성된 random num과 중복되는 숫자가 있는지 검사 후 추가

사용자의 입력
    missionutils.Console의 readLine 사용하여 입력값을 받음
    입력값 세자리가 모두 다르면 통과
    IllegalArgumentException 예외 발생
        입력 받은 숫자가 3자리가 아닌 경우
        입력 받은 값이 숫자가 아닌 경우
        입력 받은 값에 중복된 숫자가 있을 경우

3자리의 수를 맞추기
    같은 수가 같은 자리 : '스트라이크'
    같은 수가 다른 자리 : '볼'
    같은 수가 없으면 : '낫싱'

스트라이크 개수 체크
    countStrike 메서드 생성
    isDigitStrike 메서드 생성
볼 개수 체크
    countBall 메서드 생성
    isDigitBall 메서드 생성

출력
    입력한 수에 대한 결과를 볼,스트라이크 개수로 표시 : ' 볼  스트라이크'
    하나도 없는 경우 : '낫싱'
    3개의 숫자를 모두 맞힐 경우 : '3스트라이크 3개의 숫자를 모두 맞히셨습니다! 게임 종료'