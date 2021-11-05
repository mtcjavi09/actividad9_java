/*  PROGRAMA 09: Cartas con excepciones | CLASE deck
    AUTORA: Maria Tchijov Cruz.
    04 de noviembre de 2021.
    Clase que tendrá los métodos que se usarán en la clase carta, 
        usando un menú de opciones y agregando excepciones.
 */
   
import java.util.*;

public class deck 
{
    //Atributos de la clase deck
    private List<carta> card;
    private int num_cartas = 52;

    //Métodos get y set para atributos privados
    public int getNum_cartas() {return num_cartas;}
    public void setNum_cartas(int num_cartas) {this.num_cartas = num_cartas;}
    public List<carta> getCard() {return card;}
    public void setCard(List<carta> card) {this.card = card;}
    
    //Métodos propios de la clase deck
    //Shuffle: Mezcla la baraja
    public String shuffle() throws Exception
    {
        //Se usa try para verificar el índice completo de cartas
        try
        {
            //Se usará el collector para mezclar el deck
            Collections.shuffle(card);
        }
        
        //Se capta la excepción en general y se genera la excepción para su captura en main
        catch(Exception e)
        {
            //Se manda mensaje de error al usuario
            throw new Exception("Ya no es posible hacer otra acción con las cartas. Finalizando programa...");
        }
             
        //Regresa mensaje de confirmación
        return "Se mezcló el deck";
    }
    
    //Head: Muestra la primera carta del deck y la elimina
    public void head() throws Exception
    {      
        //Se usa try para probar el código y evitar error de índice
        try
        {
            //Se usará la posición 0 al ser el primer índice de la lista
            //Se muestra la carta que fue elegida
            System.out.println("La primera carta del deck es: ");
            System.out.print("Palo: " + card.get(0).getPalo() + "; ");
            System.out.print("Valor: " + card.get(0).getValor() + "; ");
            System.out.print("Color: " + card.get(0).getColor());

            card.remove(0); //Se elimina la carta
            num_cartas -= 1; //Se resta la carta eliminada
            //Se muestra la confirmación de la eliminación
            System.out.println("\nSe ha eliminado la carta 1, quedan: " + num_cartas); 
        }
        
        //Se capta la excepción en general y se genera la excepción para su captura en main
        catch(Exception e)
        {
            //Se manda mensaje de error al usuario
            throw new Exception("Ya no es posible hacer otra acción con las cartas. Finalizando programa...");
        }
    }
    
    //Pick: Selecciona una carta al azar y la elimina
    public void pick() throws Exception
    {
        int numero; //Variable donde se guardará el número aleatorio
        
        Random num_rand = new Random(); //Se crea el objeto random
       
        //Se usa try para probar el código y evitar error de índice
        try
        {
            //Se guarda el número aleatorio en la variable numero
            //Se establece como límite el número de cartas existentes para evitar error de índice
            //  El inicio de num_cartas es 52
            numero = num_rand.nextInt((num_cartas)); 

            //Se muestra la carta que fue elegida
            System.out.println("La carta #" + (numero + 1) + " del deck es: ");
            System.out.print("Palo: " + card.get(numero).getPalo() + "; ");
            System.out.print("Valor: " + card.get(numero).getValor() + "; ");
            System.out.print("Color: " + card.get(numero).getColor());

            card.remove(numero); //Se elimina la carta
            num_cartas -= 1; //Se resta la carta eliminada
            //Se muestra la confirmación de la eliminación
            System.out.println("\nSe ha eliminado la carta " + (numero + 1) + ", quedan: " + num_cartas);
        }
        
        //Se capta la excepción en general y se genera la excepción para su captura en main
        catch(Exception e)
        {
            //Se manda mensaje de error al usuario
            throw new Exception("Ya no es posible hacer otra acción con las cartas. Finalizando programa...");
        }
    }
    
    //Hand: Regresa un arreglo de 5 cartas del deck, las cuales se eliminarán
    public void hand() throws Exception
    {
        //Arreglos que guardarán los diferentes atributos de las cartas
        String[] palo = new String[5];
        String[] valor = new String[5];
        String[] color = new String[5];
        
        //Variable que guardará el número aleatorio
        int numero;
        
        //Se usa try para probar el código y evitar error de índice
        try
        {
            //Se crea objeto random para que genere el número aleatorio
            Random num_rand = new Random();

            //Se usa un ciclo for para guardar las cartas elegidas al azar
            for(int x = 0; x < 5; x++)
            {
                //Se guarda el número aleatorio en la variable numero
                //Se establece como límite el número de cartas existentes para evitar error de índice
                //  El inicio de num_cartas es 52, pero como las listas comienzan de 0 a 51, se resta 1
                numero = num_rand.nextInt((num_cartas));

                //Se guardan los elementos en los respectivos arreglos
                palo[x] = card.get(numero).getPalo();
                valor[x] = card.get(numero).getValor();
                color[x] = card.get(numero).getColor();

                //Una vez guardados los valores, se mostrará al usuario cada carta
                System.out.print("Palo: " + palo[x] + "; ");
                System.out.print("Valor: " + valor[x] + "; ");
                System.out.print("Color: " + color[x] + "\n");
                
                //Se elimina la carta
                card.remove(numero); 
                num_cartas -= 1; //Se resta la carta eliminada
                //Se muestra la confirmación de la eliminación
                System.out.println("Se ha eliminado la carta " + (numero + 1) + ", quedan: " + num_cartas);
                
                //Se imprime línea para mejor visualización
                System.out.println();
            } 
        }
        
        //Se capta la excepción en general y se genera la excepción para su captura en main
        catch(Exception e)
        {
            //Se manda mensaje de error al usuario
            throw new Exception("Ya no es posible hacer otra acción con las cartas. Finalizando programa...");
        }
    }    
}   
