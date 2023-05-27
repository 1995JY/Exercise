package test;

public class StudentUnion {
    private Student A;
    private Student B=null;

    public StudentUnion() {
    }

    public StudentUnion(Student A) {
        this.A = A;
    }


    /**
     * 获取
     * @return A
     */
    public Student getA() {
        return A;
    }

    /**
     * 设置
     * @param A
     */
    public void setA(Student A) {
        this.A = A;
    }

    /**
     * 获取
     * @return B
     */
    public Student getB() {
        return B;
    }

    /**
     * 设置
     * @param B
     */
    public void setB(Student B) {
        this.B = B;
    }

    public String toString() {
        return "StudentUnion{A = " + A + ", B = " + B + "}";
    }
}
