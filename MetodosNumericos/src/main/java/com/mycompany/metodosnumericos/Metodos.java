
package com.mycompany.metodosnumericos;

import java.util.Scanner;

/**
 *
 * @author johan
 */
public class Metodos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int salir = 0;
        while(salir != 4){
            System.out.println("-------------------------------------------");
            System.out.println("      Metodos numericos         ");
            System.out.println("1) Metodo de newton");
            System.out.println("2) Metodo de biseccion");
            System.out.println("3) Metodo de secante");
            System.out.println("4) Salir");
            System.out.println("Seleciona metodo ");
            salir = entrada.nextInt();
            
            if(salir == 1){
                System.out.println("Metodo de Newton\n");
                System.out.println("Cuanto es  x1?");
                double x1 = entrada.nextDouble();
                
                System.out.println("Cuanto es el cota?");
                double cota = entrada.nextDouble();
                
                newton(x1, 10, cota);
                System.out.println("-------------------------------------------");
                
            }else if(salir == 2){
                System.out.println("Metodo de biseccion\n");
   
                
                System.out.println("Cuanto es  x1?");
                double x1 = entrada.nextDouble();
                
                System.out.println("Cuanto es  x2?");
                double x2 = entrada.nextDouble();
                
                System.out.println("Cuanto es el cota?");
                double cota = entrada.nextDouble();
                 
                double resul = bise(x1,x2,cota,15);
                System.out.println("----------------------------------------------");
                System.out.println("La raíz es: " + resul);
                
                System.out.println("-------------------------------------------");
                
            }else if(salir == 3){
                
                System.out.println("Metodo de secante\n");
         
                System.out.println("Cuanto es  x1?");
                double x1 = entrada.nextDouble();
                
                System.out.println("Cuanto es  x2?");
                double x2 = entrada.nextDouble();
                
                System.out.println("Cuanto es el cota?");
                double cota = entrada.nextDouble();
                
                secante(x1,x2,cota,15);
                
                System.out.println("-------------------------------------------");
                
            }else if(salir == 4){
                System.out.println("Gracias por su tiempo");
            }
                
              
        }
           
    }
    
        static double fx( double y){
            double x;
            x = y - Math.cos(y);
            return x;
        }
        static double deriv( double y){
            double x;
            x = 1 + Math.sin(y);
            return x;
        }
        
        static double bise( double a, double b, double cota, double maxiteraciones){
            double error = 1;
            int i = 0;
            double list[]={-1,-2};
            
            if ((fx(a)*fx(b)) < 0){
                
                while (error > cota){
                    double xr = (a+b)/2;
                    double fxr = fx(xr);
                    double fxa = fx(a);
                    if (fxr * fxa < 0){
                        b = xr;
                    }else if (fxr * fxa >0){
                        a = xr;
                    }else{
                        break;
                    }
                    list[0] = list[1];
                    list[1] = xr;
                    
                    double xractu = xr;
                    
                    if(list[0] >= -2 || list[1] >= -2){
                        double xran = list[0];
                        error = (Math.abs((xran-xractu)/xractu));   
                    }else{
                        error = 1;
                    }
                    i++;
                }
                
            }else{
                System.out.println("No hay solución en esa region");
            }
            return list[1];
        }
        
        static void secante(double x0,double x1, double cota, double maxiteracciones){
        double error, i;
        error=1;
        i=1;
        double xrr = 0;
        while(error>cota){
            double xr;
            xr = x1- ((fx(x1)*(x1-x0))/(fx(x1)-fx(x0)));
            error=Math.abs((xr-x1)/xr);
            x0=x1;
            x1=xr;
            i+=1;
            xrr = xr;
        }   
        System.out.println("----------------------------------------------");
        System.out.println("La Raíz es: "+ xrr +"    El error es: " + error);
        
    }
        
        static void newton(double xi, double maxiti, double cota){
            
            double error, i, xr;
            error = 1;
            i = 1;
            xr = 0;
            while(error > cota){
                xr = xi -(fx(xi)/deriv(xi));
                error = Math.abs((xr-xi)/xr);
                xi = xr;
                i++;
                
            }
            
            System.out.println("----------------------------------------------");
            System.out.println("La raíz es: "+ xr + "   El error es: " + error);
            
        }
}
 
 
