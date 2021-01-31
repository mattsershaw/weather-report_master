package model;

import dao.AccountDAO;

public class DeleteLogic {
	public boolean execute(Account accountIns) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.deleteByManagement(accountIns);
		return result;
	}
}
