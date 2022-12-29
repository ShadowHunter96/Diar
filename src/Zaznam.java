import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Zaznam {
    private LocalDate datumCas;
    private String text;
    public Zaznam(LocalDateTime datumCas, String text){
     this.datumCas = LocalDate.from(datumCas);
     this.text = text;

    }

    public LocalDate getDatumCas() {
        return datumCas;
    }

    public void setDatumCas(LocalDate datumCas) {
        this.datumCas = datumCas;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }




    @Override
    public String toString(){
        return datumCas + " " + text;
    }


    private ArrayList<Zaznam> zaznamy = new ArrayList<>();

    public void pridejZaznam(LocalDate datumCas, String text){
        zaznamy.add(new Zaznam(datumCas.atStartOfDay(), text));
    }

    public ArrayList<Zaznam> najdiZaznamy(LocalDate datum, boolean dleCasu){
        ArrayList<Zaznam> nalezene = new ArrayList<>();
        for(Zaznam z : zaznamy){
            if ((dleCasu && z.getDatumCas().equals(datum)) ||
                (!dleCasu && z.getDatumCas().equals(datum))) {
            nalezene.add(z);
        }
        }
        return nalezene;
    }
    public void vymazZaznamy(LocalDate datum) {
        ArrayList<Zaznam> nalezeno = najdiZaznamy(datum, true);
        for (Zaznam z : nalezeno) {
            zaznamy.remove(z);
        }
    }



    }













