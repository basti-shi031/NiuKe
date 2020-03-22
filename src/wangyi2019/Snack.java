package wangyi2019;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*题目描述
牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。
牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
输入描述:
输入包括两行
第一行为两个正整数n和w(1 <= n <= 30, 1 <= w <= 2 * 10^9),表示零食的数量和背包的容量。
第二行n个正整数v[i](0 <= v[i] <= 10^9),表示每袋零食的体积。
输出描述:
输出一个正整数, 表示牛牛一共有多少种零食放法。*/
public class Snack {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long w = scanner.nextLong();

        List<Long> v = new ArrayList<>();
        long total = 0;
        for (int i = 0; i < n; i++) {
            long vi = scanner.nextLong();
            v.add(vi);
            total += vi;
        }

        if (total <= w) {
            System.out.println(new Double(Math.pow(2,n)).longValue());
            return;
        }

        long size = getSize(v, n - 1, w);
        System.out.println(size);
    }

    private static long getSize(List<Long> v, int n, long w) {

        if (w <= 0) {
            return 0;
        }
        if (n == 0) {
            if (v.get(n) <= w) {
                return 2;
            } else {
                return 1;
            }
        }


        long s1 = getSize(v, n - 1, w);
        long s2 = getSize(v, n - 1, w - v.get(n));

        return s1 + s2;
    }
}
