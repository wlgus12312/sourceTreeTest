package com.ubivelox.jdbc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class Jdbc
{
    final static Logger LOGGER = (Logger) LoggerFactory.getLogger(Jdbc.class);





    public int insert(final String name, final String job, final String phone) throws SQLException
    {
        int result = 0;

        final String url = "jdbc:oracle:thin:@localhost:1521:xe";
        final String user = "MEMBER";
        final String password = "MEMBER";
        try ( Connection con = DriverManager.getConnection(url, user, password); PreparedStatement pstmt = con.prepareStatement("INSERT INTO MEMBER VALUES(?, ?, ?)") )
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");

            ;

            pstmt.setString(1, name);
            pstmt.setString(2, job);
            pstmt.setString(3, phone);

            result = pstmt.executeUpdate();

            if ( result < 1 )
            {
                con.rollback();
            }
            else
            {
                con.commit();
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }

        return result;
    }





    public Member selectOneName(final String name) throws SQLException
    {
        PreparedStatement pstmt = null;
        Member m = null;
        ResultSet rset = null;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);

            pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE NAME = ?");
            pstmt.setString(1, name);

            rset = pstmt.executeQuery();

            if ( rset.next() )
            {
                m = new Member();
                m.setName(rset.getString("name"));
                m.setJob(rset.getString("job"));
                m.setPhone(rset.getString("phone"));
            }
            else
            {
                // 에러
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            pstmt.close();
            rset.close();
        }

        return m;
    }





    public Object selectOnePhone(final String phone) throws SQLException
    {
        PreparedStatement pstmt = null;
        Member m = null;
        ResultSet rset = null;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);

            pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE PHONE = ?");
            pstmt.setString(1, phone);

            rset = pstmt.executeQuery();

            if ( rset.next() )
            {
                m = new Member();
                m.setName(rset.getString("name"));
                m.setJob(rset.getString("job"));
                m.setPhone(rset.getString("phone"));
            }
            else
            {
                // 에러
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            pstmt.close();
            rset.close();
        }

        return m;
    }





    public List<Member> selectJob(final String job) throws SQLException
    {
        List<Member> list = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);

            pstmt = con.prepareStatement("SELECT * FROM MEMBER WHERE JOB = ?");
            pstmt.setString(1, job);

            rset = pstmt.executeQuery();

            if ( rset != null )
            {
                list = new ArrayList<>();

                while ( rset.next() )
                {
                    final Member m = new Member();

                    m.setName(rset.getString("NAME"));
                    m.setJob(rset.getString("JOB"));
                    m.setPhone(rset.getString("PHONE"));

                    list.add(m);

                }
            }
            else
            {
                // 에러
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            pstmt.close();
            rset.close();
        }

        return list;
    }





    public int update(final String name, final String changePhone) throws SQLException
    {
        PreparedStatement pstmt = null;
        int result = 0;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);

            pstmt = con.prepareStatement("UPDATE MEMBER SET PHONE = ? WHERE NAME = ?");
            pstmt.setString(1, changePhone);
            pstmt.setString(2, name);

            result = pstmt.executeUpdate();

            if ( result < 1 )
            {
                con.rollback();
            }
            else
            {
                con.commit();

            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            pstmt.close();
        }

        return result;
    }





    public int delete(final String name) throws SQLException
    {
        PreparedStatement pstmt = null;
        int result = 0;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);

            pstmt = con.prepareStatement("DELETE FROM MEMBER WHERE NAME = ?");
            pstmt.setString(1, name);
            result = pstmt.executeUpdate();

            if ( result < 1 )
            {
                con.rollback();
            }
            else
            {
                con.commit();
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }
        finally
        {
            pstmt.close();
        }

        return result;
    }





    public List<Member> selectAll()
    {
        List<Member> list = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        try
        {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            final String url = "jdbc:oracle:thin:@localhost:1521:xe";
            final String user = "MEMBER";
            final String password = "MEMBER";
            final Connection con = DriverManager.getConnection(url, user, password);
            pstmt = con.prepareStatement("SELECT * FROM MEMBER");

            rset = pstmt.executeQuery();

            if ( rset != null )
            {
                list = new ArrayList<>();

                while ( rset.next() )
                {

                    final Member m = new Member();

                    m.setName(rset.getString("NAME"));
                    m.setJob(rset.getString("JOB"));
                    m.setPhone(rset.getString("PHONE"));
                    this.LOGGER.info(m.toString());
                    list.add(m);
                }
            }

        }
        catch ( final ClassNotFoundException e )
        {
            e.printStackTrace();
        }
        catch ( final SQLException e )
        {
            e.printStackTrace();
        }

        return list;
    }

}
