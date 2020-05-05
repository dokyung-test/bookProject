package book.controller;


import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import book.model.UserDto;
import book.service.UserService;


@Controller
public class BookController {

	@Autowired
	UserService userService;
	
	@RequestMapping("/loginForm.do")
	public String loginForm() {
		return "bookMain/loginForm";
	}
	
	@RequestMapping(value = "/loginCheck.do", method = RequestMethod.GET, produces = "text/plain;charset=UTF-8")
	@ResponseBody
	public void loginCheck(String id, String password, HttpSession session, HttpServletResponse response) throws Exception {
		
		HashMap<String, String> m = new HashMap<String, String>();
		m.put("id", id);
		m.put("password", password);
		try {
			UserDto userDto = userService.loginCheck(m);
			
			session.setAttribute("user_idx", userDto.getUser_idx());
			session.setAttribute("user_type_id", userDto.getUser_type_id());	
			session.setAttribute("id", userDto.getId());	
			session.setAttribute("user_name", userDto.getUser_name());	
			session.setAttribute("warehouse_id", userDto.getWarehouse_id());
			
		}catch (NullPointerException e) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('ID 또는 비밀번호가 일치하지않습니다.'); location.href='loginForm.do'; </script>");
			out.flush();
		} finally {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>location.href='main.do'; </script>");
			out.flush();
		}
		
	}
	
	@RequestMapping("/main.do")
	public String mainForm() {
		return "main";
	}

	
	
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
}
