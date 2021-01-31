package model;

import dao.AccountDAO;

public class LoginLogic {
	public boolean execute(Login loginIns) {
		AccountDAO dao = new AccountDAO();
		Login login = dao.selectByLogin(loginIns);
		return login != null;
	}

}
