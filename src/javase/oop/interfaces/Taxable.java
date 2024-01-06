/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.interfaces;

/**
 *
 * @author Administrator
 * 
 * 
 */
public interface Taxable {

    public static final double TAX_PCT = ParametersHandler.getParamValueByName("TAX_PCT");
    public abstract double getTax(double value);

}