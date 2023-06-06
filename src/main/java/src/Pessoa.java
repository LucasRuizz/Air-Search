
package src;

public class Pessoa {
    // Atributos
    String country;
    String city;
    int aqiValue;
    String aqiCategory;
    int COaqiValue;
    String COaqiCategory;
    int OzoneAqiValue;
    String OzoneAqiCategory;
    int NO2aqiValue;
    String NO2aqiCategory;
    int PM25aqiValue;
    String PM25aqiCategory;

    public Pessoa(String country, String city, int aqiValue, String aqiCategory, int COaqiValue, String COaqiCategory, int OzoneAqiValue, String OzoneAqiCategory, int NO2aqiValue, String NO2aqiCategory, int PM25aqiValue, String PM25aqiCategory) {
        this.country = country;
        this.city = city;
        this.aqiValue = aqiValue;
        this.aqiCategory = aqiCategory;
        this.COaqiValue = COaqiValue;
        this.COaqiCategory = COaqiCategory;
        this.OzoneAqiValue = OzoneAqiValue;
        this.OzoneAqiCategory = OzoneAqiCategory;
        this.NO2aqiValue = NO2aqiValue;
        this.NO2aqiCategory = NO2aqiCategory;
        this.PM25aqiValue = PM25aqiValue;
        this.PM25aqiCategory = PM25aqiCategory;
    }
    
   
    // Métodos
    public void saudacao() {
        System.out.println("Olá, meu nome é " + nome + " e tenho " + idade + " anos.");
    }
}

