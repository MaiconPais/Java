//Nome do nosso pacote //                
 
package mprj;                   
 
  
 
//Classes necessárias para uso de Banco de dados //
 
import java.sql.Connection;
 
import java.sql.DriverManager;
 
import java.sql.SQLException;

import java.sql.Statement;
 
  
 
//Início da classe de conexão//
 
public class CadastroBanco {
 
    
    public static void main (String [] args){
         getConexaoMySQL();
        
            }

             public static String status = "Não conectou...";
 
//Método Construtor da Classe//
 
        public CadastroBanco() {
 
    }
 
  
 
//Método de Conexão//
 
public static  java.sql.Connection  getConexaoMySQL() {
 
        Connection connection = null;          //atributo do tipo Connection
 
  
 
try {
 
// Carregando o JDBC Driver padrão
 
String driverName = "com.mysql.jdbc.Driver";                        
 
Class.forName(driverName);
 
  
 
// Configurando a nossa conexão com um banco de dados//
      
      
        String username = "root";        //nome de um usuário de seu BD      
 
        String password = "1234";      //sua senha de acesso
        
        String url = "jdbc:mysql://localhost:3306/mprj?"
                                            +"useTimezone=true&serverTimezone=UTC";
        
        connection = DriverManager.getConnection(url, username, password);
         
    
          //Statement stmt = connection.createStatement();  
          
      
       

        //Testa sua conexão//  
 
        if (connection != null) {
 
            status = ("STATUS--->Conectado com sucesso!");
     
 
        } else {
 
            status = ("STATUS--->Não foi possivel realizar conexão");
 
        }
 
 
        return connection;
 
  
        } catch (ClassNotFoundException e) {  //Driver não encontrado
 
            System.out.println("O driver expecificado nao foi encontrado.");
 
            return null;
 
        } catch (SQLException e) {
//Não conseguindo se conectar ao banco
 
            System.out.println("Nao foi possivel conectar ao Banco de Dados."+e); 
            return null;
        }
    }
    //Método que retorna o status da sua conexão//
 
    public static String statusConection() {
 
        return status;
 
    }
   //Método que fecha sua conexão//
 
    public static boolean FecharConexao() {
 
        try {
 
         CadastroBanco.getConexaoMySQL().close();
 
            return true;
 
        } catch (SQLException e) {
 
            return false;
 
        }
    }
   //Método que reinicia sua conexão//
 
    public static java.sql.Connection ReiniciarConexao() {
 
        FecharConexao();
 
  
 
        return CadastroBanco.getConexaoMySQL();
 
    }
}