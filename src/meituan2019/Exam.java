package meituan2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 小明同学在参加一场考试，考试时间2个小时。试卷上一共有n道题目，小明要在规定时间内，完成一定数量的题目。  考试中不限制试题作答顺序，对于 i 第道题目，小明有三种不同的策略可以选择:  (1)直接跳过这道题目，不花费时间，本题得0分。
 * <p>
 * (2)只做一部分题目，花费pi分钟的时间，本题可以得到ai分。  (3)做完整个题目，花费qi分钟的时间，本题可以得到bi分。
 * <p>
 * 小明想知道，他最多能得到多少分。
 * <p>
 * 输入描述:
 * 第一行输入一个n数表示题目的数量。
 * <p>
 * 接下来n行，每行四个数p_i，a_i，q_i，b_i。(1≤n≤100，1≤p_i≤q_i≤120，0≤a_i≤b_i≤1000
 * )。
 */
public class Exam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Integer> pList = new ArrayList<>();
        List<Integer> aList = new ArrayList<>();
        List<Integer> qList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            int p = scanner.nextInt();
            int a = scanner.nextInt();
            int q = scanner.nextInt();
            int b = scanner.nextInt();
            pList.add(p);
            aList.add(a);
            qList.add(q);
            bList.add(b);
        }

        int[][] dp = new int[n + 1][121];
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= 120; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= pList.get(i-1)) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - pList.get(i-1)] + aList.get(i-1));
                if (j >= qList.get(i-1)) dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - qList.get(i-1)] + bList.get(i-1));
            }
        }
        System.out.println(dp[n][120]);
    }

}
