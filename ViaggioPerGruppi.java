package esercizi.esercizio16;

import java.util.ArrayList;


public class ViaggioPerGruppi extends Viaggio{
    
    private int minNumPartecipanti;
    private int maxPartecipanti;  
    private static double quotaGruppo = 2;

    @Override
    public String toString() {
        return "Viaggio per gruppi\n" + super.toString();
    }
    
    
    
    public ViaggioPerGruppi(int minNumPartecipanti, int maxPartecipanti, String titolo, double costoBase, ArrayList<Giorno> listaGiorni) {
        super(titolo, costoBase, listaGiorni);
        this.minNumPartecipanti = minNumPartecipanti;
        this.maxPartecipanti = maxPartecipanti;
    }

    public ViaggioPerGruppi(int minNumPartecipanti, int maxPartecipanti, String titolo, double costoBase) {
        super(titolo, costoBase);
        this.minNumPartecipanti = minNumPartecipanti;
        this.maxPartecipanti = maxPartecipanti;
    }

    public ViaggioPerGruppi() {
        this.minNumPartecipanti = 0;
        this.maxPartecipanti = 0;
    }

    @Override
    public double getCosto() {
        return super.getCosto() + (quotaGruppo*maxPartecipanti);
    }

    public int getMinNumPartecipanti() {
        return minNumPartecipanti;
    }

    public void setMinNumPartecipanti(int minNumPartecipanti) {
        this.minNumPartecipanti = minNumPartecipanti;
    }

    public int getMaxPartecipanti() {
        return maxPartecipanti;
    }

    public void setMaxPartecipanti(int maxPartecipanti) {
        this.maxPartecipanti = maxPartecipanti;
    }
    
    public double getQuotaGruppo(){
        return quotaGruppo;
    }
    
    @Override
    public void stampaCompletaViaggio(){
        System.out.println(toString());
        for(Giorno g: super.getListaGiorni()){
            System.out.println("\n -> Dettagli giorno:\n"+ g.toString());
        }
    }
    
}
