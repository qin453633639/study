package spring.tx;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.sql.Types;

public class MyUserServiceImpl implements  MyUserService {

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(MyUser user) {
        StringBuilder builder  = new StringBuilder("insert into user(id,age)  values(");
        builder.append(user.getId()).append(",").append(user.getAge()).append(")");
        this.jdbcTemplate.update(builder.toString());

        throw new RuntimeException("211");
    }
}
