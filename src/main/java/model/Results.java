package model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Results {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false)
    private long id;

    @Column
    private int a;

    @Column
    private int b;

    @Column
    private int c;

    @Column
    private double D;

    @Column(name = "answer_first")
    private double answerFirst;

    @Column(name = "answer_second")
    private double answerSecond;

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void setAnswerFirst(double answerFirst) {
        this.answerFirst = answerFirst;
    }

    public double getAnswerSecond() {
        return answerSecond;
    }

    public void setAnswerSecond(double answerSecond) {
        this.answerSecond = answerSecond;
    }
}
