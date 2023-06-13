/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller;

/**
 *
 * @author Lucas
 */
public class BuscaDados {
    public void SearchData() throws Exception{
    ConexaoDB db = new ConexaoDB();
    db.CriaConexaoMysql();
    }
}
