import java.util.ArrayList;

public class Libro {
  private String prefazione;
  private String titolo;
  private String autore;
  private String autorePrefazione;
  private String editore;
  private ArrayList<String> indice;
  private ArrayList<String> capitolo;

  public Libro() {
    indice = new ArrayList<String>();
    capitolo = new ArrayList<String>();
  }

  public Libro(String prefazione, String titolo, String autore, String autorePrefazione, String editore, ArrayList<String> indice, ArrayList<String> capitolo) {
    this.prefazione = prefazione;
    this.titolo = titolo;
    this.autore = autore;
    this.autorePrefazione = autorePrefazione;
    this.editore = editore;
    this.indice = indice;
    this.capitolo = capitolo;
  }

  public String getPrefazione() {
    return prefazione;
  }

  public void setPrefazione(String prefazione) {
    this.prefazione = prefazione;
  }

  public ArrayList<String> getIndice() {
    return indice;
  }

  public void setIndice(ArrayList<String> indice) {
    this.indice = indice;
  }

  public ArrayList<String> getCapitolo() {
    return capitolo;
  }

  public void setCapitolo(ArrayList<String> capitolo) {
    this.capitolo = capitolo;
  }

  public void addCapitolo(String capitolo) {
    this.capitolo.add(capitolo);
  }

  public void addIndice(String indice) {
    this.indice.add(indice);
  }

  public String getTitolo() {
    return titolo;
  }

  public void setTitolo(String titolo) {
    this.titolo = titolo;
  }

  public String getAutore() {
    return autore;
  }

  public void setAutore(String autore) {
    this.autore = autore;
  }

  public String getAutorePrefazione() {
    return autorePrefazione;
  }

  public void setAutorePrefazione(String autorePrefazione) {
    this.autorePrefazione = autorePrefazione;
  }

  public String getEditore() {
    return editore;
  }

  public void setEditore(String editore) {
    this.editore = editore;
  }

  @Override
  public String toString() {
    return "Libro [prefazione=" + prefazione + ", titolo=" + titolo + ", autore=" + autore + ", autorePrefazione="
        + autorePrefazione + ", editore=" + editore + ", indice=" + indice + ", capitolo=" + capitolo + "]";
  }
}
