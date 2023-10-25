구현해야할 기능 목록

1. SetNumber : 게임 시작 후 3자리 숫자 값을 설정하기 위함
    3자리수를 Randoms.pickNumberInRange()를 사용하여 생성 (List<Integer>)

2. InputNumber : 사용자가 숫자를 입력할 경우 값을 받아오기 위함
    3자리수를 Console.readLine()을 이용하여 먼저 String으로 받아 온 후, Integer로 변환

3. ComputeBallStrike : 볼, 스트라이크를 계산
    먼저 볼과 스트라이크 전체 개수를 계산(contain 사용)
    이후 스트라이크의 개수를 계산(get() == get())

4. Finish : 게임이 끝났을 경우, 다시 시작할지 종료할지 결정하기 위함
    Console.readLine() 사용하여 String으로 가져 온 후, Integer로 변환

5. (추가) ComputeResult : ComputeBallStrike class에서 계산과 출력까지 포함하면 코드의 길이가 길어져 출력을 다른 class로 분할
    ComputeBallStrike에서 전체,Strike 값을 가져와 계산하여 조건에 맞게 출력
