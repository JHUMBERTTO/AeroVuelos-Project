package conexionBD;

/**
 *
 * @author Iván
 */
public class Vuelo {
    
    public Vuelo(String cod_vue, String ori_vue, String des_vue, String dia_vue, String nda_vue) {
        
        this.cod_vue=cod_vue;
        this.ori_vue=ori_vue;
        this.des_vue=des_vue;
        this.dia_vue=dia_vue;
        this.nda_vue=nda_vue;
        
    }
    
     public String getCod_vue() {
        return cod_vue;
    }

    public String getOri_vue() {
        return ori_vue;
    }

    public String getDes_vue() {
        return des_vue;
    }

    public String getDia_vue() {
        return dia_vue;
    }

    public String getNda_vue() {
        return nda_vue;
    }

    public void setCod_vue(String cod_vue) {
        this.cod_vue = cod_vue;
    }

    public void setOri_vue(String ori_vue) {
        this.ori_vue = ori_vue;
    }

    public void setDes_vue(String des_vue) {
        this.des_vue = des_vue;
    }

    public void setDia_vue(String dia_vue) {
        this.dia_vue = dia_vue;
    }

    public void setNda_vue(String nda_vue) {
        this.nda_vue = nda_vue;
    }
    
    private String 
            cod_vue,
            ori_vue,
            des_vue,
            dia_vue,
            nda_vue;
}

   
