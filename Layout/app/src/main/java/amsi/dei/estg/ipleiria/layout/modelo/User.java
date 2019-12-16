package amsi.dei.estg.ipleiria.layout.modelo;

import java.util.Date;

public class User {


    String email;
    String nome;
   String telemovel;
    String nif;
    Date sessionExpiryDate;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome){
        this.nome=nome;
    }

    public Date getSessionExpiryDate(){
        return sessionExpiryDate;
    }

    public void setSessionExpiryDate(Date sessionExpiryDate){
        this.sessionExpiryDate=sessionExpiryDate;
    }


}
