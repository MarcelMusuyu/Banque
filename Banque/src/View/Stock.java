
package View;

import java.time.LocalDate;
import java.util.Date;

public class Stock {
    private LocalDate Dates;
    private int Quantite;
    private double CoutUnitaire;
    private double CoutTotal;

    public Stock(LocalDate Dates, int Quantite, double CoutUnitaire, double CoutTotal) {
        this.Dates = Dates;
        this.Quantite = Quantite;
        this.CoutUnitaire = CoutUnitaire;
        this.CoutTotal = CoutTotal;
    }

    public LocalDate getDates() {
        return Dates;
    }

    public void setDates(LocalDate Dates) {
        this.Dates = Dates;
    }

    public int getQuantite() {
        return Quantite;
    }

    public void setQuantite(int Quantite) {
        this.Quantite = Quantite;
    }

    public double getCoutUnitaire() {
        return CoutUnitaire;
    }

    public void setCoutUnitaire(double CoutUnitaire) {
        this.CoutUnitaire = CoutUnitaire;
    }

    public double getCoutTotal() {
        return CoutTotal;
    }

    public void setCoutTotal(double CoutTotal) {
        this.CoutTotal = CoutTotal;
    }

   
  
}
