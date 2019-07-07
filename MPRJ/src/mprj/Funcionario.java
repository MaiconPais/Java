/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mprj;

public class Funcionario {
    int matricula;
    String nome;
    String telefone;
    String email;
    String Perfil;

    public Funcionario(int matricula){
        this.matricula = matricula; 
    }
    
    public Funcionario(String nome){
        this.nome = nome;
    }
    
    public Funcionario(int matricula,String nome){
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Funcionario(int matricula,String nome,String telefone){
        this.matricula = matricula;
        this.nome = nome;
    }
    
    public Funcionario(int matricula,String nome,String telefone,String email){
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email; 
    }
    
    public Funcionario(int matricula,String nome,String telefone,String email,String Perfil){
        this.matricula = matricula;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.Perfil = Perfil;  
    }
    
    public Funcionario (){}
    
    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPerfil() {
        return Perfil;
    }

    public void setPerfil(String Perfil) {
        this.Perfil = Perfil;
    }
    
}
