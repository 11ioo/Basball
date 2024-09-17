import java.util.*;


/*class Answer {
    public static void generateNumbers() {
        Random rand = new Random();
        int[] num = new int[3];

        for (int i = 0; i < num.length; i++) {
            while (true) {
                num[i] = rand.nextInt(900) + 100;
                String numStr = Integer.toString(num[i]);


                if (!numStr.contains("0")) {
                    // 중복 체크
                    boolean isDuplicate = false;
                    for (int j = 0; j < i; j++) {
                        if (num[i] == num[j]) {
                            isDuplicate = true;
                            break;
                        }
                    }


                    if (!isDuplicate) {
                        System.out.println(num[i]);
                        break;
                    }
                }
            }
        }
    }
}
*/
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        while (true) {
            // 숫자 입력 받기
            int input = sc.nextInt();

            // 입력값이 -1이면 반복문 종료
            if (input == -1) {
                break;
            }

            // 세 자리 숫자만 리스트에 추가
            if (input >= 100 && input <= 999) {
                numbers.add(input);
            } else {
                System.out.println("세 자리 숫자가 아닙니다. 다시 입력하세요.");
            }
        }
    }
}
