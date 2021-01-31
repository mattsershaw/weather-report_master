package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Account;
import model.Login;
import model.ManagementLogic;
import model.ManagementUpdateLogic;

@WebServlet("/ManagementServlet")
public class ManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		HttpSession session = request.getSession();
		Login login = (Login) session.getAttribute("login");
		String userIdRough = login.getUserId();
		String passRough = login.getPass();
		String lineToken = null;
		String nickname = null;
		String location = null;
		String userId = null;
		String pass = null;

		if (!(userIdRough == null || userIdRough.length() > 20)) {
			userId = userIdRough;
		}
		if (!(passRough == null || passRough.length() > 20)) {
			pass = passRough;
		}

		Account account = new Account(userId, pass, lineToken, nickname, location);
		ManagementLogic bo = new ManagementLogic();
		account = bo.execute(account);

		if(account != null) {
			session.setAttribute("account", account);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("msgForManag", "エラーが発生しました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String lineToken = request.getParameter("lineToken");
		String nickname = request.getParameter("nickname");
		String location = request.getParameter("location");

		if (!account.getUserId().contentEquals(userId)) {
			account.setUserId(userId);
		}
		if (!account.getPass().contentEquals(pass)) {
			account.setPass(pass);
		}
		if (!account.getLineToken().contentEquals(lineToken)) {
			account.setLineToken(lineToken);
		}
		if (!account.getNickname().contentEquals(nickname)) {
			account.setNickname(nickname);
		}
		if (!account.getLocation().contentEquals(location)) {
			account.setLocation(location);
		}


		//Account account = new Account(userId, pass, lineToken, nickname, location);
		ManagementUpdateLogic bo = new ManagementUpdateLogic();
		boolean result = bo.execute(account);

		if(result) {
			//HttpSession session = request.getSession();
			session.setAttribute("account", account);

			request.setAttribute("msgForManag", "正しく更新されました");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("msgForManag", "値が正しくないため更新できませんでした");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);
		}
	}

}
