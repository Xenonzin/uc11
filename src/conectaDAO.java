import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    public Connection connectDB(){
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?useSSL=false&serverTimezone=UTC", "root", "");
        } catch (ClassNotFoundException erro) {
            JOptionPane.showMessageDialog(null, "Driver MySQL não encontrado: " + erro.getMessage());
        } catch (SQLException erro){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco de dados: " + erro.getMessage());
        }
        return conn;
    }
}
