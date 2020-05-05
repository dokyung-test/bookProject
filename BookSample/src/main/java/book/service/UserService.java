package book.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import book.model.UserDao;
import book.model.UserDto;

@Service
public class UserService {

	@Autowired
	UserDao userDao;

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}
	
	public UserDto loginCheck(HashMap<String, String> m) {
		return userDao.loginCheck(m);
	}

}
