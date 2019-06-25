/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mprj;

/**
 *
 * @author thiago.carvalho
 */
public class Patrimonio {
  protected int patrimonioNovo;
  protected int patrinmonioAntigo;
  protected String serie;
  protected String modelo;

    public int getPatrimonioNovo() {
        return patrimonioNovo;
    }

    public void setPatrimonioNovo(int patrimonioNovo) {
        this.patrimonioNovo = patrimonioNovo;
    }

    public int getPatrinmonioAntigo() {
        return patrinmonioAntigo;
    }

    public void setPatrinmonioAntigo(int patrinmonioAntigo) {
        this.patrinmonioAntigo = patrinmonioAntigo;
    }

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }


}
