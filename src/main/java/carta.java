/*  PROGRAMA 09: Cartas con excepciones | CLASE carta
    AUTORA: Maria Tchijov Cruz.
    04 de noviembre de 2021.
    Clase que tendrá los métodos que se usarán en la clase carta, 
        usando un menú de opciones y agregando excepciones.
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
    
    //Contructor del objeto carta con valores predeterminados
    public carta(String palo, String color, String valor) 
    {
        this.palo = palo;
        this.color = color;
        this.valor = valor;
    }
    
    //Contructor del objeto carta vacío
    public carta(){}
}