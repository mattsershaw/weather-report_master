package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AccountDAO;
import model.Account;

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String userIdRough = request.getParameter("userId");
		String passRough = request.getParameter("pass");
		String lineToken = request.getParameter("lineToken");
		String nicknameRough = request.getParameter("nickname");
		String locationRough = request.getParameter("location");
		String userId = null;
		String pass = null;
		String nickname = null;
		String location = null;

		if (!(userIdRough == null || userIdRough.length() > 20)) {
			userId = userIdRough;
		}
		if (!(passRough == null || passRough.length() > 20)) {
			pass = passRough;
		}
		if (!(nicknameRough == null || nicknameRough.length() > 20)) {
			nickname = nicknameRough;
		}
		if (!(locationRough == null || locationRough.length() > 20)) {
			location = locationRough;
		}

		Account account = new Account(userId, pass, lineToken, nickname, location);
		AccountDAO dao = new AccountDAO();
		boolean result = dao.insertIntoByRegistration(account);

		if(result) {

			request.setAttribute("account", account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registrationOK.jsp");
			dispatcher.forward(request, response);

		} else {

			request.setAttribute("errorMsgForRegis", "すでに登録されているユーザーIDが存在するため登録できないか、値が正しくありません");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/registration.jsp");
			dispatcher.forward(request, response);
		}

	}

}
