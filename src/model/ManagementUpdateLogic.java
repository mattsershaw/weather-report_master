package model;

import dao.AccountDAO;

public class ManagementUpdateLogic {
	public boolean execute(Account accountIns) {
		AccountDAO dao = new AccountDAO();
		boolean result = dao.updateByManagement(accountIns);
		return result;
	}
}
