package service;

import repo.ResultRepo;

public class MathService {
    public double[] compute(String first, String second, String third) throws Exception {
        int a = Integer.parseInt(first);
        int b = Integer.parseInt(second);
        int c = Integer.parseInt(third);
        int d = b * b - (4 * a * c);
        if (a == 0) {
            throw new Exception("Exception: a == 0");
        }
        ResultRepo repo = new ResultRepo();
        if (d == 0) {
            double answer = calculationFormula(a, b, c);
            double[] response = {d, answer, -answer};
            float answerFirstToDB = Float.parseFloat(String.valueOf(answer));
            float answerSecondToDB = Float.parseFloat(String.valueOf(-answer));
            repo.insertData(a, b, c, d, answerFirstToDB, answerSecondToDB);
            return response;
        } else if (d > 0) {
            double answerFirst = calculationFormula(a, b, c);
            double answerSecond = (-Math.sqrt(d) - b) / (2 * a);
            double[] response = {d, answerFirst, answerSecond};
            float answerFirstToDB = Float.parseFloat(String.valueOf(answerFirst));
            float answerSecondToDB = Float.parseFloat(String.valueOf(answerSecond));
            repo.insertData(a, b, c, d, answerFirstToDB, answerSecondToDB);
            return response;
        } else {
            throw new Exception("Exception: D < 0");
        }
    }

    private double calculationFormula(int a, int b, int c) {
        int d = b * b - (4 * a * c);
        double answer = (Math.sqrt(d) - b) / (2 * a);
        return answer;
    }
}
