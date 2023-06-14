/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller.Registers;
import src.Controller.ConexaoDB;
/**
 *
 * @author Juan
 */
public class PutRegister {
    public PutRegister(int id,String nome,String email,String endereco) throws Exception{
        ConexaoDB db = new ConexaoDB();
        db.CriaConexaoMysql();
    }
}
