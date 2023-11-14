package br.cefetmg.biosit.DAOMySQL;

public class LoginDAO {
    private final String url;
    private final String password;
    private final String user;
    
    public LoginDAO() {
        url = "jdbc:mysql://localhost:3306/biositdb";
        password = "";
        user = "root";
    }
    
    // teste
    public boolean Buscar() {
        
    return true;
    }
}
