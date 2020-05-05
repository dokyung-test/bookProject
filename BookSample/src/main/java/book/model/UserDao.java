package book.model;

import java.util.HashMap;

import org.mybatis.spring.support.SqlSessionDaoSupport;

public class UserDao extends SqlSessionDaoSupport{

	public UserDto loginCheck(HashMap<String, String> m) {
		UserDto userDto = getSqlSession().selectOne("bookSql.loginCheck", m);
		return userDto;
	}
}
