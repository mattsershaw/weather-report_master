package model;

import dao.AccountDAO;

public class RegistrationLogic {
	public boolean execute(Account accountIns) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.insertIntoByRegistration(accountIns);
		return result;
	}
}