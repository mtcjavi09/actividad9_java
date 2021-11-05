/*  PROGRAMA 09: Cartas con excepciones | CLASE main
    AUTORA: Maria Tchijov Cruz.
    04 de noviembre de 2021.
    Clase que tendrá los métodos que se usarán en la clase carta, 
        usando un menú de opciones y agregando excepciones.
 */

import java.util.*;
import javax.swing.*;

public class main 
{ 
    //Método main que interactúa con el usuario
    public static void main (String[] args) throws Exception
    {
        try
        {
            //Variables necesarias para el correcto funcionamiento del método
            //Creación de objeto deck 
            deck deck = new deck();
            //Arreglos que guardan los posibles valores y palos de las cartas
            String[] valor = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
            String[] palo = {"picas","corazón","diamante","trébol"};
            //Contador que permitirá conocer el número de carta impresa
            int contador = 1; 
            //Lista que guardará todas las cartas para su posterior manipulación
            ArrayList<carta> card = new ArrayList<>();
            //Nombre del usuario para el saludo personalizado
            String nombre_usuario = JOptionPane.showInputDialog("¡Hola! ¿Cómo te llamas?");

            //Saludo para el usuario
            System.out.println("* * * * * JUEGO DECK DE MTC * * * * *");
            System.out.println("Bienvenid@, " + nombre_usuario + " :) \n");
            System.out.print("A continuación se mostrarán todas las cartas: ");

            //Se crean las cartas y se muestra el total del deck
            //For para imprimir el deck completo
            for (int x = 0; x < palo.length; x++)
            {
                for (int y = 0; y < valor.length; y++)
                {
                    //Se crea el objeto carta
                    carta carta = new carta(palo[x],get_color(palo[x]),valor[y]);               
                    //Se va a guardar el objeto carta en el deck
                    card.add(carta);
                    //Se imprimen los valores para cada carta
                    System.out.print("\nNúm " + contador + "; ");
                    System.out.print("Palo: " + palo[x] + "; ");
                    System.out.print("Valor: " + valor[y] + "; "); 
                    System.out.print("Color: " + get_color(palo[x]));
                    contador++;
                }
            }

            deck.setCard(card); //Se guarda el array en el objeto deck
            //Se muestra el tamaño total del deck
            System.out.println("\nEl tamaño del deck es: " + deck.getCard().size());
            System.out.println(); //Se imprime línea para mejor visualización

            //Se muestra el menú al usuario
            show_menu(nombre_usuario, deck);
        }
        
        catch(Exception e)
        {System.out.println("Finalizando programa por una excepción");}
    } 
    
    //Método get_color que elige entre negro y rojo dependiendo del palo de la carta
    public static String get_color(String palo)
    {
        //Se crea la variable que guardará el resultado
        String color;
        
        //Se usa una función de condición para obtener el color
        if(palo.equals("picas") || palo.equals("trébol"))
        {color = "negro";}
        else
        {color = "rojo";}
        
        //Retorna el valor
        return color;
    }      
    
    //Método show_menu que muestra mediante un ciclo el menú de actividades que puede realizar el usuario
    public static void show_menu (String nombre_usuario, deck deck) throws Exception
    {
        //Se crean las variables que se usarán en el bucle
        int opcion = 0, intentos = 0, permitidos = 3, restantes = 0;
        //Se crea un scanner para leer la opción deseada por el usuario
        Scanner scanner = new Scanner (System.in);

        //Se crea un ciclo para que el usuario pueda elegir entre las opciones
        //  hasta que su opción sea 0 o sus intentos inválidos sean 3
        do
        {
            //Se muestran las opciones en pantalla
            System.out.println("* * * Menú de acciones * * *");
            System.out.println("    [1] Mezclar el deck");
            System.out.println("    [2] Seleccionar la primera carta");
            System.out.println("    [3] Seleccionar una carta aleatoria");
            System.out.println("    [4] Generar una mano de 5 cartas");
            System.out.println("    [0] Salir");
            //Se imprime línea para mejor visualización
            System.out.println();
            
            //Se pide la opción al usuario
            opcion = Integer.parseInt(JOptionPane.showInputDialog(nombre_usuario + 
                    ", por favor, ingresa la opción que desees: "));

            //Se crea un switch-case para indicar las actividades dependiendo de la opción
            switch (opcion)
            {
                case 1:
                {
                    //Se indica al usuario la opción que eligió
                    System.out.println("Elegiste mezclar el deck "
                            + "(opción " + opcion + ")");
                    
                    //Se muestra la mezcla del deck
                    System.out.println(deck.shuffle());
                    
                    //Se imprime línea para mejor visualización
                    System.out.println();
                    break;
                }
                
                case 2:
                {
                    //Se indica al usuario la opción que eligió
                    System.out.println("Elegiste seleccionar la primera carta del deck "
                            + "(opción " + opcion + ")");
                    
                    //Se muestra la carta 1 del deck
                    deck.head();
                    
                    //Se imprime línea para mejor visualización
                    System.out.println(); 
                    break;
                }
                
                case 3:
                {
                    //Se indica al usuario la opción que eligió
                    System.out.println("Elegiste seleccionar una carta del deck al azar "
                            + "(opción " + opcion + ")");
                    
                    //Se muestra una carta aleatoria del deck
                    deck.pick();
                    
                    //Se imprime línea para mejor visualización
                    System.out.println();
                    break;
                }
                
                case 4:
                {
                    //Se indica al usuario la opción que eligió
                    System.out.println("Elegiste seleccionar una mano de cartas del deck al azar "
                            + "(opción " + opcion + ")");
                    
                    //Se muestra el arreglo de 5 cartas
                    deck.hand();
                    
                    //Se imprime línea para mejor visualización
                    System.out.println();
                    break;
                }
            }
            
            //Se crea una condición para detectar las opciones inválidas
            if (opcion < 0 || opcion > 4)
            {
                //Se suma un intento al contador
                intentos += 1;
                //Se restan los intentos permitidos menos los intentos del contador
                restantes = permitidos - intentos;

                //Se muestran los intentos que quedan disponibles
                System.out.println("Te quedan " + restantes + " intentos");
                
                //Se imprime línea para mejor visualización
                System.out.println();
            }
            
            //Se agrega otra condición indicando que el usuario podrá volverlo a intentar mientras que
            //  los intentos mientras sean diferentes a 3
            if (intentos == 3)
            {throw new Exception("Se han terminado tus intentos, programa finalizado.");}
            
        } while(opcion != 0);
        
        //Se indica que el programa ha terminado, despidiendo al usuario
        System.out.println("Ha terminado el programa. ¡Nos vemos pronto, " + nombre_usuario + "! :)");
    }
}