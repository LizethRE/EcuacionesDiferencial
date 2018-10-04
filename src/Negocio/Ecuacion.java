/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;



/**
 *
 * @author Karito
 */
public class Ecuacion {
    
    private int auxiliar;
    private int imaginario;
    private String eRaiz1;
    private String eRaiz2;
    private int raizi;
    private int raizi2;
       

    public Ecuacion() {
        this.auxiliar = 0;
        this.imaginario = 0;
        this.eRaiz1 = "";
        this.eRaiz2 = "";
        this.raizi = 0;
        this.raizi2 = 0;
        
    }
              
    public String calcular(int masa, int cte, int rigidez) {
        String cad = "";
        String ecuacion = "";

        if (masa > 1) {
            cad = masa + "y'' + " + cte + "y' + " + rigidez + "y = 0"
                    + "\n \n" + masa + "r² + " + cte + "r + " + rigidez + " = 0";
        } else {
            cad = "y'' + " + cte + "y' + " + rigidez + "y = 0"
                    + "\n \n" + "r² + " + cte + "r + " + rigidez + " = 0";

        }

        String r1 = this.primeraRaiz(masa, cte, rigidez);
        String r2 = this.segundaRaiz(masa, cte, rigidez);
        ecuacion = this.ecuacion();
        String cad2 = "\n \n HALLAMOS LOS VALORES DE LAS RAICES ";
        String cad3 = "\n REEMPLAZAMOS LOS VALORES DE LAS RAICES";
        String cad4 = "\n \n OBTENDREMOS LA SIGUIENTE ECUACION \n \n";
        return cad + cad2 + "\n" + r1 + "\n" + r2 + "\n" + cad3 + cad4 + ecuacion;
    }

// HALLAMOS LA PRIMERA RAIZ
    public String primeraRaiz(int masa, int cte, int rigidez) {
        String raiz1 = "";
        int a = (int) Math.pow(cte, 2);
        int b = a - ((4 * masa) * rigidez);
        int d = 2 * masa;
        
        System.out.println("a = " + a);
        System.out.println("b = " + b);
        System.out.println("c = " + d);
        if (b < 0) {
            int aux1 = -cte / d;
            System.out.println(aux1);
            int imag1 = ((int) Math.sqrt(b * (-1))) / d;
            raiz1 = aux1 + " + " + imag1 + "i";
            auxiliar = aux1;
            imaginario = b;
            raizi = imag1;

        } else {
            int raiz = (-cte + (int) Math.sqrt(b)) / d;
            raiz1 = "" + raiz;
        }
        eRaiz1 = raiz1;
        System.out.println("m1 = " + raiz1);
        return "\n m1 = " + raiz1;
    }

//HALLAMOS LA SEGUNDA RAIZ
    public String segundaRaiz(int masa, int cte, int rigidez) {
        String raiz2 = "";
        int a = (int) Math.pow(cte, 2);
        int b = a - ((4 * masa) * rigidez);
        int d = 2 * masa;

        if (b < 0) {
            int aux2 = -cte / d;
            int imag2 = ((int) Math.sqrt(b * (-1))) / d;
            raiz2 = aux2 + " - " + imag2 + "i";
            raizi2 = imag2;
        } else {
            int raiz = (-cte - (int) Math.sqrt(b)) / d;
            raiz2 = "" + raiz;
        }
        eRaiz2 = raiz2;
        System.out.println("m2 = " + raiz2);
        return "\n m2 = " + raiz2;
    }

    public String ecuacion() {
        String cad = "";
        if (imaginario < 0) {
            cad = " y = e^" + auxiliar + "x (C1 cos " + raizi + "x + C2 sen " + raizi2 + "x)";
        } else {
            if (eRaiz1.equals(eRaiz2)) {
                cad = " y = C1 e^" + eRaiz1 + "x + C2 xe^" + eRaiz2 + "x";
            } else {
                cad = " y = C1 e^" + eRaiz1 + "x + C2 e^" + eRaiz2 + "x";
            }
            return cad;
        }
        return cad;

    }
    
  
  
}
