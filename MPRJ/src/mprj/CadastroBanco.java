/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mprj;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Daniela
 */
public class CadastroBanco {
    
    int matricula;
    String nome;
    String telefone;
    String email;
    String Perfil;

    private final String stringDeConexao = "jdbc:mysql://localhost:3306/BancoMPRJ?"
                                            +"useTimezone=true&serverTimezone=UTC";
    private final String usuario = "root";
    private final String senha = "";
    
    Funcionario funcionario = new Funcionario(matricula, nome, telefone, email, Perfil);
    public void salvar(){
        try{
           Connection con = DriverManager.getConnection(stringDeConexao, 
                                                                usuario, 
                                                                senha);
           Statement stmt = con.createStatement();                                                     
           
           String comandoInsert = "INSERT INTO Funcionario(Nome,Perfil)"
                   + "VALUES ('@Nome', '@Perfil')";
                   
           
           //Altera as strings para o nome desejado
           comandoInsert = comandoInsert.replace("@Nome", funcionario.getNome());
                                    /*    .replace("@sexo", funcionario.getSexo().toString());
                                        .replace("@endereco", funcionario.getEndereco())
                                        .replace("@bairro", funcionario.getBairro())
                                        .replace("@complemento", funcionario.getComplemento())
                                        .replace("@municipio", funcionario.getMunicipio())
                                        .replace("@uf", funcionario.getUf());
*/
           
           System.out.println("Executando...");
          // System.out.println(comandoInsert);
           
           //stmt.execute(comandoInsert); //Insere os dados
           
        } catch (Exception excecao){
            excecao.printStackTrace();
        }
            
    }
    
    public List<Funcionario> recuperarFuncionario(){
        return null;
    }
}

//}
