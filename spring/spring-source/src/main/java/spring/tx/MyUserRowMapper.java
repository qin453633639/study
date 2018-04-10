package spring.tx;

 import org.springframework.jdbc.core.RowMapper;

 import javax.swing.tree.TreePath;
 import java.sql.ResultSet;
 import java.sql.SQLException;

public class MyUserRowMapper implements RowMapper {

    @Override
    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        MyUser u = new MyUser();
        u.setId(rs.getInt("id"));
        u.setAge(rs.getInt("age"));
        return u;
    }
}
