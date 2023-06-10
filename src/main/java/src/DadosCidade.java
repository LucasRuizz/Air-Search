
package src;

public class DadosCidade {
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

    public DadosCidade(String country, String city, int aqiValue, String aqiCategory, 
            int COaqiValue, String COaqiCategory, int OzoneAqiValue, String OzoneAqiCategory, 
            int NO2aqiValue, String NO2aqiCategory, int PM25aqiValue, String PM25aqiCategory) {
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getAqiValue() {
        return aqiValue;
    }

    public void setAqiValue(int aqiValue) {
        this.aqiValue = aqiValue;
    }

    public String getAqiCategory() {
        return aqiCategory;
    }

    public void setAqiCategory(String aqiCategory) {
        this.aqiCategory = aqiCategory;
    }

    public int getCOaqiValue() {
        return COaqiValue;
    }

    public void setCOaqiValue(int COaqiValue) {
        this.COaqiValue = COaqiValue;
    }

    public String getCOaqiCategory() {
        return COaqiCategory;
    }

    public void setCOaqiCategory(String COaqiCategory) {
        this.COaqiCategory = COaqiCategory;
    }

    public int getOzoneAqiValue() {
        return OzoneAqiValue;
    }

    public void setOzoneAqiValue(int OzoneAqiValue) {
        this.OzoneAqiValue = OzoneAqiValue;
    }

    public String getOzoneAqiCategory() {
        return OzoneAqiCategory;
    }

    public void setOzoneAqiCategory(String OzoneAqiCategory) {
        this.OzoneAqiCategory = OzoneAqiCategory;
    }

    public int getNO2aqiValue() {
        return NO2aqiValue;
    }

    public void setNO2aqiValue(int NO2aqiValue) {
        this.NO2aqiValue = NO2aqiValue;
    }

    public String getNO2aqiCategory() {
        return NO2aqiCategory;
    }

    public void setNO2aqiCategory(String NO2aqiCategory) {
        this.NO2aqiCategory = NO2aqiCategory;
    }

    public int getPM25aqiValue() {
        return PM25aqiValue;
    }

    public void setPM25aqiValue(int PM25aqiValue) {
        this.PM25aqiValue = PM25aqiValue;
    }

    public String getPM25aqiCategory() {
        return PM25aqiCategory;
    }

    public void setPM25aqiCategory(String PM25aqiCategory) {
        this.PM25aqiCategory = PM25aqiCategory;
    }
  
    
}

