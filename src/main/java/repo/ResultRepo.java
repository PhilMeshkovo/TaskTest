package repo;

import hibernate.HibernateUtils;
import model.Results;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class ResultRepo {
    static final String SQL = "CREATE TABLE IF NOT EXISTS results (id INT AUTO_INCREMENT, " +
            "a_number INT NOT NULL, b_number INT NOT NULL, c_number INT NOT NULL, d_number DOUBLE NOT NULL," +
            " answer_first FLOAT NOT NULL, answer_second FLOAT NOT NULL, PRIMARY KEY (id)); ";

    public void insertData(int a, int b, int c, double d,
                           float answerFirst, float answerSecond) {
        SessionFactory factory = HibernateUtils.getSessionFactory();
        Session session = factory.openSession();
        try {
            session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(SQL);
            sqlQuery.executeUpdate();

            Results results = new Results();
            results.setA(a);
            results.setB(b);
            results.setC(c);
            results.setD(d);
            results.setAnswerFirst(answerFirst);
            results.setAnswerSecond(answerSecond);
            session.save(results);
            session.getTransaction().commit();
            HibernateUtils.shutdown();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
    }
}
