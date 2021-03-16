/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author paulh
 */
public class Publisher extends ObjectClass {
    
    private String name;
    private String siteWeb;
    private String eMail;
    private String telephone;
    private int rating;

    public Publisher(int id, String name, String siteWeb, String eMail, String telephone, int rating) {
        super(id);
        this.name = name;
        this.siteWeb = siteWeb;
        this.eMail = eMail;
        this.telephone = telephone;
        this.rating = rating;
    }
    
    @Override
    public ObjectClass clone() throws CloneNotSupportedException{
        return new Publisher(this.id,this.name,this.siteWeb,this.eMail,this.telephone,this.rating);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSiteWeb() {
        return siteWeb;
    }

    public void setSiteWeb(String siteWeb) {
        this.siteWeb = siteWeb;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {
        return "Publisher" + " " + super.toString()+ " " + name + " " + siteWeb + " " + eMail + " " + telephone + " " + rating;
    }   
    
}
