package sdp.gl2019.db;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;

public class Synop {

    @JsonProperty("id_stacji")
    private Integer idStacji;

    private String stacja;
    @JsonProperty("data_pomiaru")
    private LocalDate dataPomiaru;
    @JsonProperty("godzina_pomiaru")
    private Integer godzinaPomiaru;
    private Double temperatura;
    @JsonProperty("predkosc_wiatru")
    private Double predkoscWiatru;
    @JsonProperty("kierunek_wiatru")
    private Double kierunekWiatru;
    @JsonProperty("wilgotnosc_wzgledna")
    private Double wilgotnoscWzgledna;
    @JsonProperty("suma_opadu")
    private Double sumaOpadu;
    private Double cisnienie;

    public Integer getIdStacji() {
        return idStacji;
    }

    public void setIdStacji(Integer idStacji) {
        this.idStacji = idStacji;
    }

    public String getStacja() {
        return stacja;
    }

    public void setStacja(String stacja) {
        this.stacja = stacja;
    }

    public LocalDate getDataPomiaru() {
        return dataPomiaru;
    }

    public void setDataPomiaru(LocalDate dataPomiaru) {
        this.dataPomiaru = dataPomiaru;
    }

    public Integer getGodzinaPomiaru() {
        return godzinaPomiaru;
    }

    public void setGodzinaPomiaru(Integer godzinaPomiaru) {
        this.godzinaPomiaru = godzinaPomiaru;
    }

    public Double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(Double temperatura) {
        this.temperatura = temperatura;
    }

    public Double getPredkoscWiatru() {
        return predkoscWiatru;
    }

    public void setPredkoscWiatru(Double predkoscWiatru) {
        this.predkoscWiatru = predkoscWiatru;
    }

    public Double getKierunekWiatru() {
        return kierunekWiatru;
    }

    public void setKierunekWiatru(Double kierunekWiatru) {
        this.kierunekWiatru = kierunekWiatru;
    }

    public Double getWilgotnoscWzgledna() {
        return wilgotnoscWzgledna;
    }

    public void setWilgotnoscWzgledna(Double wilgotnoscWzgledna) {
        this.wilgotnoscWzgledna = wilgotnoscWzgledna;
    }

    public Double getSumaOpadu() {
        return sumaOpadu;
    }

    public void setSumaOpadu(Double sumaOpadu) {
        this.sumaOpadu = sumaOpadu;
    }

    public Double getCisnienie() {
        return cisnienie;
    }

    public void setCisnienie(Double cisnienie) {
        this.cisnienie = cisnienie;
    }

    @Override
    public String toString() {
        return "Synop{" +
                "idStacji=" + idStacji +
                ", stacja='" + stacja + '\'' +
                ", dataPomiaru=" + dataPomiaru +
                ", godzinaPomiaru=" + godzinaPomiaru +
                ", temperatura=" + temperatura +
                ", predkoscWiatru=" + predkoscWiatru +
                ", kierunekWiatru=" + kierunekWiatru +
                ", wilgotnoscWzgledna=" + wilgotnoscWzgledna +
                ", sumaOpadu=" + sumaOpadu +
                ", cisnienie=" + cisnienie +
                '}';
    }


}
