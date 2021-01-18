package model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private Integer id;

    @Column(name = "a_number")
    private int a;

    @Column(name = "b_number")
    private int b;

    @Column(name = "c_number")
    private int c;

    @Column(name = "d_number")
    private double D;

    @Column(name = "answer_first")
    private float answerFirst;

    @Column(name = "answer_second")
    private float answerSecond;

    public Results() {
    }

    public long getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public double getD() {
        return D;
    }

    public void setD(double d) {
        D = d;
    }

    public double getAnswerFirst() {
        return answerFirst;
    }

    public void setAnswerFirst(float answerFirst) {
        this.answerFirst = answerFirst;
    }

    public double getAnswerSecond() {
        return answerSecond;
    }

    public void setAnswerSecond(float answerSecond) {
        this.answerSecond = answerSecond;
    }
}
