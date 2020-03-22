package wangyi2019;

/*牛牛总是睡过头，所以他定了很多闹钟，只有在闹钟响的时候他才会醒过来并且决定起不起床。从他起床算起他需要X分钟到达教室，上课时间为当天的A时B分，请问他最晚可以什么时间起床
输入描述:
每个输入包含一个测试用例。
每个测试用例的第一行包含一个正整数，表示闹钟的数量N(N<=100)。
接下来的N行每行包含两个整数，表示这个闹钟响起的时间为Hi(0<=A<24)时Mi(0<=B<60)分。
接下来的一行包含一个整数，表示从起床算起他需要X(0<=X<=100)分钟到达教室。
接下来的一行包含两个整数，表示上课时间为A(0<=A<24)时B(0<=B<60)分。
数据保证至少有一个闹钟可以让牛牛及时到达教室。*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Clock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int clockSize = scanner.nextInt();
        List<Integer> clocks = new ArrayList<>();

        for (int i = 0; i < clockSize; i++) {
            int h = scanner.nextInt();
            int m = scanner.nextInt();
            clocks.add(h * 60 + m);
        }

        int duringTime = scanner.nextInt();
        int startH = scanner.nextInt();
        int startM = scanner.nextInt();
        int startTime = startH * 60 + startM - duringTime;

        Collections.sort(clocks);

        if (clocks.get(clockSize - 1) <= startTime) {
            System.out.println(clocks.get(clockSize - 1));
        } else {
            for (int index = 0; index < clockSize - 1; index++) {
                if (clocks.get(index) <= startTime && clocks.get(index + 1) > startTime) {
                    System.out.println(String.valueOf(clocks.get(index) / 60) + " " + String.valueOf(clocks.get(index) % 60));
                }
            }

            /*int low = 0;
            int high = clockSize - 1;
            int mid = (low + high) / 2;

            while (true) {
                int midValue = clocks.get(mid);

                if (midValue == startTime) {
                    System.out.println(midValue);
                    return;
                }

                if (midValue < startTime) {

                }else {

                }


            }*/

        }


    }

}
