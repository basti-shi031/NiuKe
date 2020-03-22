package wangyi2019;

import java.util.*;

/**
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 */
public class Job {

    static class JobItem {
        int Di;
        int Pi;

        public JobItem(int di, int pi) {
            Di = di;
            Pi = pi;
        }

        public int getDi() {
            return Di;
        }

        public void setDi(int di) {
            Di = di;
        }

        public int getPi() {
            return Pi;
        }

        public void setPi(int pi) {
            Pi = pi;
        }
    }

    static class Person {
        int id;
        int Ai;
        int Pi;

        public int getPi() {
            return Pi;
        }

        public void setPi(int pi) {
            Pi = pi;
        }

        public Person(int id, int ai) {
            this.id = id;
            Ai = ai;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getAi() {
            return Ai;
        }

        public void setAi(int ai) {
            Ai = ai;
        }
    }

    public static void main(String[] args) {

        List<JobItem> jobItemList = new ArrayList<>();
        List<Person> personList = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();
        JobItem jobItem = null;
        Person person = null;
        for (int i = 0; i < N; i++) {
            int di = scanner.nextInt();
            int pi = scanner.nextInt();
            jobItem = new JobItem(di, pi);
            jobItemList.add(jobItem);
        }
        for (int i = 0; i < M; i++) {
            int Ai = scanner.nextInt();
            person = new Person(i, Ai);
            personList.add(person);
        }

        Collections.sort(jobItemList, new Comparator<JobItem>() {
            @Override
            public int compare(JobItem o1, JobItem o2) {
                if (o1.getDi() < o2.getDi()) {
                    return -1;
                }
                if (o1.getDi() > o2.getDi()) {
                    return 1;
                }

                return 0;
            }
        });

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getAi() < o2.getAi()) {
                    return -1;
                }
                if (o1.getAi() > o2.getAi()) {
                    return 1;
                }
                return 0;
            }
        });

        int lastJobIndex = -1;
        int lastMaxJobindex = -1;
        for (Person singlePerson : personList) {
            int[] index = searchMaxPiJob(jobItemList, singlePerson, lastJobIndex, lastMaxJobindex);
            lastJobIndex = index[0];
            lastMaxJobindex = index[1];
        }

        Collections.sort(personList, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                if (o1.getId() < o2.getId()) {
                    return -1;
                }
                if (o1.getId() > o2.getId()) {
                    return 1;
                }
                return 0;
            }
        });

        for (Person person1 : personList) {
            System.out.println(person1.getPi());
        }

    }

    private static int[] searchMaxPiJob(List<JobItem> jobItemList, Person singlePerson, int lastJobIndex, int lastMaxJobIndex) {

        int[] jobIndexs = new int[2];

        JobItem jobItem = null;
        int maxPi = -1;
        int maxJobIndex = -1;
        for (int i = lastMaxJobIndex + 1; i < jobItemList.size(); i++) {
            jobItem = jobItemList.get(i);

            if (singlePerson.getAi() >= jobItem.getDi()) {
                int pi = jobItem.getPi();
                if (pi > maxPi) {
                    maxPi = pi;
                    maxJobIndex = i;
                }
            } else {
                lastMaxJobIndex = i - 1;
                break;
            }
        }

        int lastPi = 0;
        if (lastJobIndex != -1) {
            lastPi = jobItemList.get(lastJobIndex).getPi();
        }

        if (maxPi > lastPi) {
            //能找到新的工作
            lastJobIndex = maxJobIndex;
            singlePerson.setPi(maxPi);
            jobIndexs[0] = lastJobIndex;
            jobIndexs[1] = lastMaxJobIndex;
        } else {
            if (lastJobIndex == -1) {
                singlePerson.setPi(0);
            } else {
                singlePerson.setPi(jobItemList.get(lastJobIndex).getPi());
            }
            jobIndexs[0] = lastJobIndex;
            jobIndexs[1] = lastMaxJobIndex;
        }

        return jobIndexs;
    }
}
