package algorithm.lab_hw_0307;

import java.util.Scanner;

public class lab0_2 {
    /**
     * 다음과 같은 2가지 재귀 알고리즘을 작성하고, 사용자가 입력한 n을 매개변수로 이 두 메소드를 호출하여 결과를 얻는 프로그램을 작성하세요.
     * - 양의 정수 n을 매개변수로 받아 1부터 n까지의 합을 구하여 리턴하는 메소드
     * - 양의 정수 n을 매개변수로 받아 1부터 n까지의 정수를 출력하는 메소드
     * - 입력: 정수값(n)
     * - 출력: 1부터 n까지의 합과 정수리스트
     * - 실행 예:
     * lab0_2:이윤하
     * 5                          // 정수값 n
     * 15
     * 1 2 3 4 5
     */
    public static void main(String[] args) {
        System.out.println("lab0_2:이윤하");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(sum(n));
        print(n);
        sc.close();
    }
    // 양의 정수 n을 매개변수로 받아 1부터 n까지의 합을 구하여 리턴하는 메소드
    static int sum(int n) {
        if (n == 1) {
            return 1;
        }
        return n + sum(n -1 );
    }

    // 양의 정수 n을 매개변수로 받아 1부터 n까지의 정수를 출력하는 메소드
    static int print(int n) {
        if (n == 1) {
            System.out.print(n + " ");
            return 1;
        }
        int result = print(n - 1);
        System.out.print(n + " ");
        return result;
    }
}
