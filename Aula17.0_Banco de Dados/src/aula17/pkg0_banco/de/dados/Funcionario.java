
package aula17.pkg0_banco.de.dados;

import java.io.Serializable;

                        //Define que a classe é serializavel
public class Funcionario implements Serializable {
    private String nome;
    private Character sexo;
    private String endereco;
    private String bairro;
    private String complemento;
    private String municipio;
    private String uf;
    
    @Override
    public String toString(){
        return this.nome+", "+
                this.sexo+", "+
                this.endereco+", "+
                this.bairro+", "+
                this.complemento+", "+
                this.municipio+", "+
                this.uf;
    }
    
    public void formString(String dados) throws Exception{
        String[] dadosSeparados = dados.split(",");
        
        if (dadosSeparados.length < 7)
            throw new Exception("Os dados estão inválidos.");

        this.nome = dadosSeparados[0];
        this.sexo = dadosSeparados[1].charAt(0);
        this.endereco = dadosSeparados[2];
        this.bairro = dadosSeparados[3];
        this.complemento = dadosSeparados[4];
        this.municipio = dadosSeparados[5];
        this.uf = dadosSeparados[6];   
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }
    
    
}
