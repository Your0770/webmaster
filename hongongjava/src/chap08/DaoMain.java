package chap08;

public class DaoMain {
	
	public static void main(String[] args) {
		dbwork(new OracleDao());
		dbwork(new MySqlDao());

	}

	private static void dbwork(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}

}
