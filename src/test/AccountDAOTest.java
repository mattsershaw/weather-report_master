package test;

import dao.AccountDAO;
import model.Login;

public class AccountDAOTest {
	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}
	public static void testFindByLogin1() {
		Login login = new Login("mattser", "2460");
		AccountDAO dao = new AccountDAO();
		Login result = dao.selectByLogin(login);
		if(result != null && result.getUserId().equals("mattser") &&
			result.getPass().equals("2460")) {
			System.out.println("testFindByLogin1:成功しました");
		} else {
			System.out.println("testFindByLogin1:失敗しました");
		}

	}
	public static void testFindByLogin2() {
		Login login = new Login("mattser", "12345");
		AccountDAO dao = new AccountDAO();
		Login result = dao.selectByLogin(login);
		if(result == null) {
			System.out.println("testFindByLogin2:成功しました");
		} else {
			System.out.println("testFindByLogin2:失敗しました");
		}

	}

}
