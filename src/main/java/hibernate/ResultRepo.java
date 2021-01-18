package hibernate;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.resource.transaction.spi.TransactionStatus;

public class ResultRepo {
    static final String SQL = "CREATE TABLE IF NOT EXISTS results (id INT AUTO_INCREMENT, " +
            "a_number INT NOT NULL, b_number INT NOT NULL, c_number INT NOT NULL, d_number DOUBLE NOT NULL," +
            " answer_first DECIMAL(10,3) NOT NULL, answer_second DECIMAL(10,3) NOT NULL, PRIMARY KEY (id)); ";

    public void insertData(int a, int b, int c, double D,
                           double answerFirst, double answerSecond) {
        String INSERTSQL = "INSERT INTO results (a_number, b_number, c_number, d_number, answer_first, answer_second)" +
                " VALUES (" + a + ", " + b + ", " + c + " ," + D + " ," + answerFirst + " ," + answerSecond + ");";
        SessionFactory factory = HibernateUtils.getSessionFactory();

        Session session = factory.openSession();
        try {
            session.beginTransaction();
            SQLQuery sqlQuery = session.createSQLQuery(SQL);
            sqlQuery.executeUpdate();


            if (session.getTransaction().equals(TransactionStatus.ACTIVE)) {
                session.getTransaction().commit();
            }
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            session.getTransaction().rollback();
        }
    }
}
