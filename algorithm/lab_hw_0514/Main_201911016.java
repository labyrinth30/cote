package algorithm.lab_hw_0514;

import java.util.Scanner;

public class Main_201911016 {

    static Integer[] dp; // 메모이제이션을 위한 배열
    static int[] stair; // 입력받은 배열
    static int[] path; // 경로를 저장할 배열

    static int find(int n) { // n번째 계단을 밟을 때 조건에 따른 최대값을 구하는 함수
        if(dp[n] == null) {
            // n-1번째 계단을 밟았을 때와 n-2번째 계단을 밟았을 때 중 최대값을 구하고 n번째 계단을 밟을 때의 점수를 더함
            dp[n] = Math.max(find(n - 2), find(n - 3) + stair[n - 1]) + stair[n];
        }
        return dp[n];
    }
    public static void main(String[] args) {
        System.out.println("hw9_1: 이윤하");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // 배열 초기화
        dp = new Integer[n + 1];
        stair = new int[n + 1];
        path = new int[n + 1];

        for (int i = 1; i <= n; i++) { // 계단의 점수 입력
            stair[i] = sc.nextInt();
        }

        // 초기값 설정
        dp[0] = stair[0];
        dp[1] = stair[1];

        // n이 2 이상일 때 dp[2] 초기값 설정
        if(n >= 2) {
            dp[2] = stair[1] + stair[2];
        }
        System.out.println(find(n));
        int i = n;
        while (i > 0) {
            System.out.println(path[i] + " ");
            i = path[i - 1];
        }
        sc.close();
    }

}
