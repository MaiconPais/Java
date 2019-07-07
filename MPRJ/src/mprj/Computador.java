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
public class Computador{
        protected int patrimonio;
        protected String modelo;
    
    public Computador(int patrimonio,String modelo) {
        this.patrimonio = patrimonio;
        this.modelo = modelo;
    }
    
    public Computador(int patrimonio) {
        this.patrimonio = patrimonio;
    }
    
    public Computador(String modelo) {
        this.modelo = modelo;
    }
    
    public Computador(){};
    
    public int getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(int patrimonioNovo) {
        this.patrimonio = patrimonioNovo;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

}
