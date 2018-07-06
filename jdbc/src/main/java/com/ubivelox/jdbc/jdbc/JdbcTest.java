package com.ubivelox.jdbc.jdbc;

import static org.junit.Assert.assertEquals;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class JdbcTest
{

    @Test
    public void insertTest() throws SQLException
    {
        final Jdbc jdbc = new Jdbc();

        assertEquals(1, jdbc.insert("김지현", "연구원", "010-9917-0233"));

    }





    @Test
    public void selectTest() throws SQLException
    {
        final Jdbc jdbc = new Jdbc();

        List<Member> expectedAllList = new ArrayList<Member>();
        expectedAllList = jdbc.selectAll();
        assertEquals(expectedAllList, jdbc.selectAll());

        final Member m = new Member("김지현", "연구원", "010-9917-0233");
        assertEquals(m, jdbc.selectOneName("김지현"));
        assertEquals(m, jdbc.selectOnePhone("010-9917-0233"));

        final List<Member> expectedList = new ArrayList<Member>();
        expectedList.add(new Member("이태규", "연구원", "010-9367-9720"));
        expectedList.add(new Member("김동건", "연구원", "010-7118-7551"));
        expectedList.add(new Member("김가을", "연구원", "010-4743-8681"));
        expectedList.add(new Member("하은지", "연구원", "010-2886-3132"));
        expectedList.add(new Member("이상인", "연구원", "010-7458-1335"));
        expectedList.add(new Member("김지현", "연구원", "010-9917-0233"));

        assertEquals(expectedList, jdbc.selectJob("연구원"));

    }





    @Test
    public void updateTest() throws SQLException
    {
        final Jdbc jdbc = new Jdbc();

        final Member m = new Member("김지현", "연구원", "010-9917-0233");
        m.setPhone("010-0233-9917");
        assertEquals(1, jdbc.update("김지현", "010-0233-9917"));
        assertEquals(1, jdbc.update("김지현", "010-9917-0233"));

    }





    @Test
    public void deleteTest() throws SQLException
    {
        final Jdbc jdbc = new Jdbc();

        assertEquals(1, jdbc.delete("김지현"));
    }

}
