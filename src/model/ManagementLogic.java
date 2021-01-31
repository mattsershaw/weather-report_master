package model;

import dao.AccountDAO;

public class ManagementLogic {
	public Account execute(Account accountIns) {
		AccountDAO dao = new AccountDAO();
		Account account = dao.selectByManagement(accountIns);
		return account;
	}

}
