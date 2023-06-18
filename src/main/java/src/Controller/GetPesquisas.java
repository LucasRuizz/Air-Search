package src.Controller;
import src.Model.DadosCidade;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import src.Controller.ConexaoDB;

public class GetPesquisas {
   public String country;
   public String city;
   public int aqiValue;
   public  String aqiCategory;
   public  int COaqiValue;
   public String COaqiCategory;
   public  int OzoneAqiValue;
   public  String OzoneAqiCategory;
   public int NO2aqiValue;
   public String NO2aqiCategory;
   public int PM25aqiValue;
   public String PM25aqiCategory;
   
   public List<DadosCidade> getPesquisas() {
        List<DadosCidade> dadosCidades = new ArrayList<>();
        ConexaoDB db = new ConexaoDB();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        String sql = "SELECT * FROM poluicaoglobal WHERE ï»¿Country = 'Brazil'";

        try {
            conn = db.CriaConexaoMysql();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                  this.country = rset.getString("ï»¿Country");
    this.city = rset.getString("City");
    this.aqiValue = rset.getInt("AQI Value");
    this.aqiCategory = rset.getString("AQI Category");
    this.COaqiValue = rset.getInt("CO AQI Value");
    this.COaqiCategory = rset.getString("CO AQI Category");
    this.OzoneAqiValue = rset.getInt("Ozone AQI Value");
    this.OzoneAqiCategory = rset.getString("Ozone AQI Category");
    this.NO2aqiValue = rset.getInt("NO2 AQI Value");
    this.NO2aqiCategory = rset.getString("NO2 AQI Category");
    this.PM25aqiValue = rset.getInt("PM2.5 AQI Value");
    this.PM25aqiCategory = rset.getString("PM2.5 AQI Category");
                 DadosCidade dadosCidade = new DadosCidade(
                    this.country,
                    this.city,
                    this.aqiValue,
                    this.aqiCategory,
                    this.COaqiValue,
                    this.COaqiCategory,
                    this.OzoneAqiValue,
                    this.OzoneAqiCategory,
                    this.NO2aqiValue,
                    this.NO2aqiCategory,
                    this.PM25aqiValue,
                    this.PM25aqiCategory
                );
                dadosCidades.add(dadosCidade);
              
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Feche os recursos (ResultSet, PreparedStatement e Connection) adequadamente
            // para liberar os recursos e evitar vazamentos de memória.
            if (rset != null) {
                try {
                    rset.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return dadosCidades;
    }

    public static void main(String[] args) {
        GetPesquisas getPesquisas = new GetPesquisas();
        List<DadosCidade> dadosCidades = getPesquisas.getPesquisas();

        for (DadosCidade dadosCidade : dadosCidades) {
            
            
        }
    }
}
