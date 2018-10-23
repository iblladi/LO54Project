package fr.utbm.lo54.coursesession.sequence;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class CourseIdGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {

        Serializable generatedId = null;
        String prefix = "DEP";
        Connection connection = session.connection();

        try {
            Statement statement=connection.createStatement();

            ResultSet rs=statement.executeQuery("select count(id) as Id from Course");

            if(rs.next())
            {
                int id=rs.getInt(1);
                String suffix = String.format("%04d", id);
                generatedId = prefix.concat(suffix);
                System.out.println("Generated Id: " + generatedId);

            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        return generatedId;
    }

}
