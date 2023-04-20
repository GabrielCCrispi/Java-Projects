import java.util.Scanner;
import java.io.IOException;

public class robo {
    public static void main(String[] args)  throws IOException, InterruptedException
    {
       Scanner entrada = new Scanner(System.in); 
       int Nestacoes;
       int Ncomandos;
       int Nproxima;
       int comandos;
       int contproximo = 0;
       int estatual = 1;
       int cont = 0;
       
       do
       {
        if(cont > 0)
        {

        if( System.getProperty("os.name"). contains("Windows"))   
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        else
        {
        Runtime.getRuntime().exec("clear");
        }
        System.out.println("\nValor invalido, tente novamente");
       }
       
        System.out.print("\n\nDigite a quatidade de estacoes: ");
            Nestacoes = entrada.nextInt();

        System.out.print("\n\nDigite a quatidade de comandos: ");
            Ncomandos = entrada.nextInt();

        System.out.print("\n\nDigite o numero da estacao mais proxima: ");
            Nproxima = entrada.nextInt();

        cont++;
        }
        while (2 > Nestacoes || Nestacoes > 100 || 1 > Ncomandos || Ncomandos > 1000 || Nproxima == 0 || (Nestacoes - Nproxima) < 0);

            for(int i = 0; i < Ncomandos; i++)
            {
                do
                {
                System.out.print("\n\n\nPara avancar digite 1, para retornar digite -1: ");
                comandos = entrada.nextInt();
                if(comandos == 1)
                {
                    estatual++;
                    if(estatual == Nestacoes + 1)
                        estatual = 1;
                    System.out.println("Posicao atual do robo: " + estatual);
                    if(estatual == Nproxima)
                        contproximo++; 

                } 
                else if ( comandos == -1)
                {
                    estatual--;
                    if(estatual == 0) 
                        estatual = Nestacoes;
                    System.out.println("Posicao atual do robo: " + estatual);
                    if(estatual == Nproxima)
                        contproximo++; 
                }
                else
                {
                    System.out.println("Valor invalido, tente novamente\n");
                }
                }while(comandos != 1 && comandos != -1);
            }
             System.out.println("\n\n O robo esteve na estacao mais proxima: "+ contproximo +" vezes"+"\n\n\n");
    
        entrada.close();
        }
    }