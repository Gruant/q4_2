package ru.antongrutsin.hw_4;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SQLManager {
    private final Connection connection = new SQLConnection().connect();

    public List<HashMap<String, Object>> getQuery1() {
        String sql = "select s.date,\n" +
                "       m.name as movie1,\n" +
                "       s.start,\n" +
                "       s.duration,\n" +
                "       s.stop,\n" +
                "       table1.name as movie2,\n" +
                "       table1.start,\n" +
                "       table1.duration,\n" +
                "       table1.stop\n" +
                "from session as s\n" +
                "         join movie as m on s.movie_id = m.id\n" +
                "         join (select s.date, m.name, s.start, s.duration, s.stop\n" +
                "               from session as s\n" +
                "                        join movie as m on s.movie_id = m.id\n" +
                "               order by date, start) as table1\n" +
                "where s.date = table1.date\n" +
                "  and table1.start < s.stop\n" +
                "  and s.start < table1.start\n" +
                "order by s.date, s.start;";
        return makeRequest(sql);
    }
    public List<HashMap<String, Object>> getQuery2() {
        String sql = "";
        return makeRequest(sql);
    }

    public List<HashMap<String, Object>> getQuery3() {
        String sql = "select (case\n" +
                "            when s.start between '09:00:00' and '14:59:59' then '09:00:00-14:59:59'\n" +
                "            else\n" +
                "                (case\n" +
                "                     when s.start between '15:00:00' and '17:59:59' then '15:00:00-17:59:59'\n" +
                "                     else\n" +
                "                         (case\n" +
                "                              when s.start between '18:00:00' and '20:59:59' then '18:00:00-20:59:59'\n" +
                "                              else\n" +
                "                                  (case\n" +
                "                                       when s.start between '21:00:00' and '23:59:59' then '21:00:00-23:59:59'\n" +
                "                                       else 0 end)\n" +
                "                             end)\n" +
                "                    end)\n" +
                "    end)                           as period,\n" +
                "       sum(quantity)               as qua_sum,\n" +
                "       sum(cost * quantity) as tickets_cost_sum\n" +
                "from session as s\n" +
                "         join ticket as t on t.session_id = s.id\n" +
                "group by period;";
        return makeRequest(sql);
    }


    private List<HashMap<String, Object>> makeRequest(String sql) {
        List<HashMap<String, Object>> rows = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery(sql);
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                HashMap<String, Object> row = new HashMap<>(columns);
                for(int i = 1; i <= columns; ++i) {
                    row.put(resultSetMetaData.getColumnLabel(i), resultSet.getObject(i));
                }
                rows.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rows;
    }
}
