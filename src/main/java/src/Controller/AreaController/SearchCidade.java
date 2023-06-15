/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package src.Controller.AreaController;
import src.Controller.ConexaoDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import src.Model.DadosCidade;
import src.View.Graph;
/**
 *
 * @author Lucas
 */
public class SearchCidade {
   public  String country;
   public String city;
   public int aqiValue;
   public String aqiCategory;
   public int COaqiValue;
   public String COaqiCategory;
   public int OzoneAqiValue;
   public String OzoneAqiCategory;
   public int NO2aqiValue;
    public String NO2aqiCategory;
   public int PM25aqiValue;
   public String PM25aqiCategory;
    
    public  void searchcity(String cidade) throws Exception{
        ConexaoDB db = new ConexaoDB();
        String sql = "SELECT * FROM poluicaoglobal WHERE ï»¿Country = 'Brazil' AND city LIKE '%" + cidade + "%'";
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
         try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                this.country = rset.getString("ï»¿Country");
                this.city = rset.getString("City");
                this.aqiValue = rset.getInt("AQI Value");
                this.aqiCategory = rset.getString("AQI Category");
                this.COaqiCategory = rset.getString(("CO AQI Category"));
                this.COaqiValue = rset.getInt("CO AQI Value");
                this.OzoneAqiValue = rset.getInt("Ozone AQI Value");
                this.OzoneAqiCategory =rset.getString("Ozone AQI Category");
                this.NO2aqiValue = rset.getInt("NO2 AQI Value");
                this.NO2aqiCategory = rset.getString("NO2 AQI Category");
                this.PM25aqiValue = rset.getInt("PM2.5 AQI Value");
                this.PM25aqiCategory = rset.getString("PM2.5 AQI Category");
            DadosCidade dadoscidade =  new DadosCidade(
                this.country,
                this.city ,
                this.aqiValue ,
                this.aqiCategory,
                this.COaqiValue,
                this.COaqiCategory,
                this.OzoneAqiValue ,
                this.OzoneAqiCategory ,
                this.NO2aqiValue ,
                this.NO2aqiCategory ,
                this.PM25aqiValue ,
                this.PM25aqiCategory);
                
            }
            
        } catch (Exception x) {
            
            x.printStackTrace();
        }
         
    }
}
