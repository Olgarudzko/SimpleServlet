package by.rudzko.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//  выравнивай отступы
public class ConnectionCreator {
private static final String COM_MYSQL_JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String URL_DB = "jdbc:mysql://localhost:3306/mysql";
	private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "leta88";
    private static volatile Connection connection = null;// а если приложение параллельно обрабатывает запросы, как ты этот один коннекшн делить будешь?

    static {
        try {// за инициализацию в статическом блоке - молодец, хотя не предусмотрела, что будет если у тебя будет несколько реализаций дао и ты не будешь знать, какое из них сработает первым
		
            Class.forName(COM_MYSQL_JDBC_DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();// а вот тут -.......
		// ну мы даже техническое правило разбирали - если гасится исключение, три раза посмотри, может в нем кто-то заинтересован, а ты его прячешь
		// у тебя драйвер не загрузился, а ты никому ни-ни,думайте, что в моем приложении все хорошо
        }
    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed())
            connection = DriverManager.getConnection(
                    URL_DB, USER_DB, PASSWORD_DB
            );
        return connection;
    }
}
