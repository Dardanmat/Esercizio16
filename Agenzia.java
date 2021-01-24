package esercizi.esercizio16;
import java.util.ArrayList;

public class Agenzia {
    
    private String nomeAgenzia;
    private ArrayList<Viaggio> listaViaggi;

    @Override
    public String toString() {
        String str = "Lista Viaggi dell'agenzia " + nomeAgenzia + "\n";
        int i = 1;
        
        for(Viaggio v: listaViaggi){
            str += "\n\n" + "Viaggio num." + i + ":\n" + v.toString();
            i++;
        }
        if(i == 1) str += "Al momento l'agenzia non ha viaggi";
        return str;
    }

    
    
    public Agenzia(String nomeAgenzia, ArrayList<Viaggio> listaViaggi) {
        this.nomeAgenzia = nomeAgenzia;
        this.listaViaggi = listaViaggi;
    }
    
    public Agenzia(String nomeAgenzia) {
        this.nomeAgenzia = nomeAgenzia;
        this.listaViaggi = new ArrayList<>();
    }
    
    public Agenzia() {
        this.nomeAgenzia = "";
        this.listaViaggi = new ArrayList<>();
    }
    
    public boolean addViaggio (Viaggio v){
        return listaViaggi.add(v);
    }
    
    public boolean removeViaggio (String titolo){
        
        for(Viaggio v: listaViaggi){   
            if(v.getTitolo().equals(titolo)){
                return listaViaggi.remove(v);
            }
        }
        return false;
    }
    
    public boolean removeViaggio (Viaggio viaggio){
        
        for(Viaggio v: listaViaggi){   
            if(v.equals(v)){
                return listaViaggi.remove(v);
            }
        }
        return false;
    }
    
    public ArrayList<Viaggio> listaViaggiConCostoMinore(double costo){
        ArrayList<Viaggio> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            
            if(v.getCosto() < costo){
                lista.add(v);
            }
        }
        lista.sort(new CompareCostoDecr());
        return lista;
    }
    
    //la creazione della lista dei viaggi per singoli che passano da una certa località, 
    //in ordine alfabetico per titolo del viaggio;
    public ArrayList<ViaggioPerSingoli> listaViaggiSingoliStessaLocalita(String localita){
        ArrayList<ViaggioPerSingoli> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            
            if(v instanceof ViaggioPerSingoli){
                
                for(Giorno g: v.getListaGiorni()){
                    
                    if(g.getNomeLuogo().equals(localita)){
                        lista.add((ViaggioPerSingoli)v);
                        break;
                    }
                }
            } 
        }
        lista.sort(new CompareTitoloViaggio());
        return lista;
    }
    
    //la creazione della lista dei viaggi per gruppi con numero minimo di partecipanti uguale ad un certo
    //valore, ordinati per numero di giorni previsti;
    public ArrayList<ViaggioPerGruppi> listaViaggiGruppiPerPartecimantiMinimi(int val){
        ArrayList<ViaggioPerGruppi> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            
            if(v instanceof ViaggioPerGruppi){
                
                if(((ViaggioPerGruppi) v).getMinNumPartecipanti() == val){
                    lista.add((ViaggioPerGruppi)v);
                }
            }
        }
        lista.sort(new CompareNumeroGiorniViaggio());
        return lista;
    }
    
    //la creazione della lista dei viaggi per gruppi che superano un certo numero di giorni.
    public ArrayList<ViaggioPerGruppi> listaViaggiPerGruppiConNumGiorniSuperiore(int val){
        ArrayList<ViaggioPerGruppi> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            
            if(v instanceof ViaggioPerGruppi){
                
                if(((ViaggioPerGruppi) v).getListaGiorni().size() > val){
                    lista.add((ViaggioPerGruppi)v);
                }
            }
        }
        
        return lista;
    }
    
//    Metodo che restituisce il viaggio più costoso 
    public Viaggio viaggioPiuCostoso(){
        int max = 0;
        
        for(int i = 0; i < listaViaggi.size(); i++){
            if(listaViaggi.get(i).getCosto() > listaViaggi.get(max).getCosto()) max = i;
        }
        
        return listaViaggi.get(max);
    }
    
//    Metodo che restituisce il viaggio per singoli più costoso 
    public ViaggioPerSingoli viaggioSingoliPiuCostoso(){
        int max = 0;
        
        for(int i = 0; i < listaViaggi.size(); i++){
            if(listaViaggi.get(i) instanceof ViaggioPerSingoli){
                if(listaViaggi.get(i).getCosto() > listaViaggi.get(max).getCosto()) max = i;
            }
        }
        
        return (ViaggioPerSingoli)listaViaggi.get(max);  
    }
    
//    Metodo che restituisce il viaggio per gruppo più costoso 
    public ViaggioPerGruppi viaggioGruppiPiuCostoso(){
        int max = 0;
        
        for(int i = 0; i < listaViaggi.size(); i++){
            if(listaViaggi.get(i) instanceof ViaggioPerGruppi){
                if(listaViaggi.get(i).getCosto() > listaViaggi.get(max).getCosto()) max = i;
            }
        }
        
        return (ViaggioPerGruppi)listaViaggi.get(max);  
    }
    
//    Metodo che ricevuto in input un oggetto di tipo giorno, restituisce l’elenco di viaggi che hanno in comune tale giorno.
    public ArrayList<Viaggio> listaViaggiConGiorno (Giorno g){
        ArrayList<Viaggio> lista = new ArrayList<>();
        
        for(Viaggio v: listaViaggi){
            for(Giorno days: v.getListaGiorni()){
                if(days.equals(g)) lista.add(v);
            }
        }
        
        return lista;
    }
    
//    Override del metodo toString per tutte le classi
    //già fatto in tutte le classi
    
}
