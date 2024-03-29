package algorithm.lab_hw_0328;

import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        System.out.println("hw4_2:이윤하");

        // 사용자로부터 원소 개수(n)와 n 개수의 실수값을 입력받아 배열에 저장
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextDouble();
        }

        // 배열 원소들을 병합 정렬 알고리즘을 이용하여 오름차순으로 정렬
        mergeSort(array, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        sc.close();
    }

    public static void mergeSort(double[] array, int left, int right) {
        if (left < right) { // 재귀를 탈출하려면 left >= right여야 한다. 즉 원소가 1개인 경우
            int mid = left + ((right - left)  / 2); // (left + right) / 2와 같지만 오버플로우를 방지할 수 있다.
            mergeSort(array, left, mid); // 왼쪽 배열 정렬
            mergeSort(array, mid + 1, right); // 오른쪽 배열 정렬
            merge(array, left, mid, right); // 정렬된 두 배열 병합
        }
    }

    public static void merge(double[] array, int left, int mid, int right) {
        double[] temp = new double[array.length]; // 임시 배열 생성
        int i = left; // 왼쪽 배열의 시작 인덱스
        int j = mid + 1; // 오른쪽 배열의 시작 인덱스
        int k = left; // 병합된 배열의 시작 인덱스

        while (i <= mid && j <= right) { // 두 배열 중 하나라도 끝에 도달할 때까지 두 배열의 원소를 비교하여 작은 원소를 임시 배열에 저장
            if ((int)array[i] <= (int)array[j]) { // 정수부만 비교하여 둘 중 더 작거나 같은 원소가 왼쪽 배열에 있을 경우
                temp[k++] = array[i++];
            } else { // 더 작은 원소가 오른쪽 배열에 있을 경우
                temp[k++] = array[j++];
            }
        }
        // 두 배열 중 하나라도 끝에 도달했을 경우
        while (i <= mid) { // 왼쪽 배열이 남았다면 왼쪽 배열의 남은 원소들을 임시 배열에 저장
            temp[k++] = array[i++];
        }

        while (j <= right) { // 오른쪽 배열이 만약 남았다면 오른쪽 배열에 남은 원소들을 임시 배열에 저장
            temp[k++] = array[j++];
        }

        for (int l = left; l <= right; l++) { // 임시 배열의 원소들을 원래 배열에 복사히는 부분
            array[l] = temp[l];
        }
    }
}
