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
import model.OpenWeather;

@WebServlet("/ExcuteServlet")
public class ExcuteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	HttpSession session = request.getSession();
    	Account account = (Account) session.getAttribute("account");
		OpenWeather ow = new OpenWeather();
		String msgForManag = null;

		try {
			ow.main(account);
		} catch(Exception e) {
			msgForManag = "天気情報が取得できませんでした";
		}
		if (msgForManag == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);
		} else {
			request.setAttribute("msgForManag", msgForManag);

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);
		}

	}

}
