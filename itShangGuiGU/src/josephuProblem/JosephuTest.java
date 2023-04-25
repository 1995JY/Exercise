package josephuProblem;

public class JosephuTest {
    public static void main(String[] args) {
        SingleDirLinkedList sdll = new SingleDirLinkedList(5);
//        sdll.show();

        sdll.JosephuSolve(1, 2);

    }
}

class SingleDirLinkedList {
    Boy first = null;

    // 环形链表构造器，1为环起点
    public SingleDirLinkedList(int val) {
        Boy flag = null;
        if (val < 1) {
            System.out.println("输入数据有误");
            return;
        } else {
            for (int i = 1; i <= val; i++) {
                Boy boy = new Boy(i);
                if (i == 1) {
                    first = boy;
                    boy.next = first;
                    flag = first;
                } else {
                    flag.next = boy;
                    boy.next = first;
                    flag = boy;
                }
            }
        }
    }

    //    展示环形链表，从头开始
    public void show() {
        Boy temp = first;
        while (temp.next != first) {
            System.out.println(temp.getCount());
            temp = temp.next;
        }
        System.out.println(temp.getCount());
    }

    //    打印约瑟夫问题的答案，start是开始位置，num是报的数
    public void JosephuSolve(int start, int num) {
        // 保证头结点不变，定义1个temp标记
        Boy temp = first;
        //起点设置在第start个节点
        for (int i = 1; i < start - 1; i++) {
            temp = temp.next;
        }

//        链表没空，就还有小孩，就一直循环下去
        if (num == 1) {
            while (temp.next != null) {
                System.out.println(temp.getCount() + ",");
                temp = temp.next;
                if (temp == temp.next) {
                    return;
                }
            }
        } else if (num == 2) {
            while (temp.next != null) {
                System.out.println(temp.next.getCount());
                temp.next = temp.next.next;
                temp = temp.next;
                if (temp == temp.next) {
                    System.out.println(temp.next.getCount());
                    return;
                }
            }
        } else {
            int count = 1;
            while (temp.next != null) {
                temp = temp.next;
                count++;
                if (count == num - 1) { // 说明下一个小孩就是要被取出去的节点
                    if (temp.next == temp) { // 只剩1个小孩的情况，不然temp.next.next会出现空指针异常。
                        System.out.print(temp.next.getCount());
                        return;
                    }
                    System.out.print(temp.next.getCount() + ",");

                    temp.next = temp.next.next;
                    temp = temp.next;
                    count = 1;
                }

            }
        }

    }
}

class Boy {
    private int count;
    Boy next;

    public Boy(int count) {
        this.count = count;
    }

    /**
     * 获取
     *
     * @return count
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置
     *
     * @param count
     */
    public void setCount(int count) {
        this.count = count;
    }

    /**
     * 获取
     *
     * @return next
     */
    public Boy getNext() {
        return next;
    }

    /**
     * 设置
     *
     * @param next
     */
    public void setNext(Boy next) {
        this.next = next;
    }

    public String toString() {
        return "Boy{count = " + count + ", next = " + next + "}";
    }
}
