package meituan2019;

import java.util.*;

/**
 * 题目描述
 * 一条直线上等距离放置了n台路由器。路由器自左向右从1到n编号。第i台路由器到第j台路由器的距离为| i-j |。  每台路由器都有自己的信号强度，第i台路由器的信号强度为ai。所有与第i台路由器距离不超过ai的路由器可以收到第i台路由器的信号（注意，每台路由器都能收到自己的信号）。问一共有多少台路由器可以收到至少k台不同路由器的信号。
 * 输入描述:
 * 输入第一行两个数n , k（1≤n , k≤10^5）
 * <p>
 * 第二行n个数, a1 , a2 , a3……… , an（0≤ai≤10^9）
 * 输出描述:
 * 输出一个数，一共有多少台路由器可以收到至少k台不同路由器的信号。
 */


public class Wifi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long n = scanner.nextLong();
        long k = scanner.nextLong();

        List<Long> an = new ArrayList<>();
        List<Long> countList = new ArrayList<>();

        Set<Long> sets = new HashSet<>();
        for (long i = 0; i < n; i++) {
            countList.add((long) 0);
            long a = scanner.nextLong();

            long low = lowRange(a, i);
            long high = highRange(a, i, n);
            for (long j = low; j <= high; j++) {
                if (sets.contains(j)) {
                    continue;
                }

                long newValue = countList.get((int) j) + 1;
                if (newValue >= k) {
                    sets.add(j);
                    continue;
                }
                countList.add((int) j, newValue);

            }
        }
        System.out.println(sets.size());
    }

    private static long highRange(long a, long i, long n) {
        return i + a > n ? n - 1 : i + a;
    }

    private static long lowRange(long a, long i) {
        return i - a >= 0 ? i - a : 0;
    }
}
