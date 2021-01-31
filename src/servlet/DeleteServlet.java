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
import model.DeleteLogic;

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		Account account = (Account) session.getAttribute("account");

		DeleteLogic dl = new DeleteLogic();
		boolean result = dl.execute(account);

		if (result) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/deleteOK.jsp");
			dispatcher.forward(request, response);

		} else {
			request.setAttribute("msgForManag", "削除できませんでした");

			RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/management.jsp");
			dispatcher.forward(request, response);
		}
	}

}
