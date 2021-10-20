/*  PROGRAMA 06: Cartas | CLASE carta
    AUTORA: Maria Tchijov Cruz.
    11 de octubre de 2021.
    Clase que inicializará un juego de poker.
 */

public class carta 
{
    //Atributos de la clase carta
    private String palo;
    private String color;
    private String valor;
    
    //Métodos get y set para atributos privados
    public String getPalo() {return palo;}
    public void setPalo(String palo) {this.palo = palo;}
    public String getColor() {return color;}
    public void setColor(String color) {this.color = color;}
    public String getValor() {return valor;}
    public void setValor(String valor) {this.valor = valor;}
    
    //Contructor del objeto carta
    public carta(String palo, String color, String valor) 
    {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    
    public carta(){}
}
