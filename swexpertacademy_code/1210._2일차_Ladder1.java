import java.util.Scanner;
import java.io.FileInputStream;

class Solution
{
	public static void main(String args[]) throws Exception
	{

		Scanner sc = new Scanner(System.in);
		int T;
		/*
		 * ���� ���� �׽�Ʈ ���̽��� �־����Ƿ�, ������ ó���մϴ�.
		 */

		// 2���� �迭 ����
		int[][] ladder = new int[100][100];
		for (int test_case = 1; test_case <= 10; test_case++) {
            		T = sc.nextInt();
			// ��ٸ� �Է�
			for (int i = 0; i < 100; ++i) {
				for (int j = 0; j < 100; j++) {
					ladder[i][j] = sc.nextInt();
				}
			}

			// ó�� �˰���
			for (int t = 0; t < 100; ++t) {
				// ���� ����
				if (ladder[0][t] == 1) {
					int i = 1;
					int j = t;
					// ���� ���� �Ʒ�:0 ��:1 ��:2
					int dir = 0;
					// Ž�� ����
					while (i < 99) {
						// ������ �Ʒ� �� ���
						if (dir == 0) {
							// �� ��� Ȯ��
							if (j > 0 && ladder[i][j-1] == 1) {
								dir = 1;
								j--;
							}
							// �� ��� Ȯ��
							else if (j < 99 && ladder[i][j+1] == 1) {
								dir = 2;
								j++;
							}
							// �Ʒ��� �̵�
							else {
								i++;
							}
						}
						// ������ �� �� ���
						else if (dir == 1) {
							// �Ʒ� ��� Ȯ��
							if (ladder[i+1][j] == 1) {
								dir = 0;
								i++;
							}
							// �·� �̵�
							else {
								j--;
							}
							
						}
						// ������ �� �� ���
						else {
							// �Ʒ� ��� Ȯ��
							if (ladder[i+1][j] == 1) {
								dir = 0;
								i++;
							}
							// ��� �̵�
							else {
								j++;
							}
						}
					}
					// ������ ���� Ȯ��
					if (ladder[i][j] == 2) {
						System.out.println("#"+T+" "+t);
						break;
					}
				}
			}
		}
	}
}