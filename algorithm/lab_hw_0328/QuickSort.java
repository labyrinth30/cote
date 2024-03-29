package algorithm.lab_hw_0328;
import java.util.Scanner;

public class QuickSort
{
    public static void main(String args[]) {
        System.out.println("hw4_1:이윤하");

        // 사용자로부터 원소 개수(n)와 n 개수의 실수값을 입력받아 배열에 저장
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double[] array = new double[n];

        for (int i = 0; i < n; i++) {
            array[i] = sc.nextDouble();
        }

        // 배열 원소들을 퀵 정렬 알고리즘을 이용하여 오름차순으로 정렬
        quickSort(array, 0, n - 1);

        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
        sc.close();
    }

    // 배열 array[left...right]을 퀵 정렬
    public static void quickSort(double[] array, int left, int right) {
        if (left >= right) { // 원소가 1개인 경우
            return;
        }
        int pivotIndex = partition(array, left, right); // 반환된 pivotIndex를 기준으로 왼쪽, 오른쪽 배열을 분할
        quickSort(array, left, pivotIndex - 1);
        quickSort(array, pivotIndex + 1, right);
    }

    // array[left...right]를 분할하여 기준원소 인덱스를 리턴
    public static int partition(double[] array, int left, int right) {
        double pivot = array[right]; // pivot 선정
        int num = left - 1; // pivot보다 작은 원소 개수를 알려줄 변수
        for (int i = left; i < right; i++) {
            // 정수부만을 비교하여 정렬
            if ((int)array[i] < (int) pivot) {
                num++;
                swap(array, num, i); // pivot보다 작은 원소는 왼쪽에 있게 됨
            }
        }
        swap(array, num + 1, right); // pivot보다 작은 원소들은 왼쪽에 있게 되므로 pivot과 위치를 바꿔줌
        return num + 1;
    }

    public static void swap(double[] array, int i, int j) { // 두 원소 바꾸는 코드
        double temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}
