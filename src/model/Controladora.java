package model;

import java.util.Random;

public class Controladora {

    private String[][] tableroTresEnRaya;

    /**
     * Constructor de la clase Controladora para inicializar
     *
     * @pre No se requieren precondiciones específicas.
     * @post Se crea una instancia de Controladora 
     */
    public Controladora() {
        tableroTresEnRaya = new String[3][3];
        inicializarTablero();
    }

    /**
     * Inicializa el tablero con valores vacíos.
     */
    private void inicializarTablero() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tableroTresEnRaya[i][j] = " ";
            }
        }
    }

    /**
     * Devuelve el tablero en formato String.
     */
    public String obtenerTableroComoString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                sb.append(tableroTresEnRaya[i][j]);
                if (j < 2) sb.append("|");
            }
            sb.append("\n");
            if (i < 2) sb.append("-----\n");
        }
        return sb.toString();
    }

    /**
     * Realiza una jugada aleatoria para la máquina.
     */
    public void jugadaAleatoria() {
        Random rand = new Random();
        int i, j;
        do {
            i = rand.nextInt(3);
            j = rand.nextInt(3);
        } while (!tableroTresEnRaya[i][j].equals(" "));
        tableroTresEnRaya[i][j] = "X";
    }



    public boolean comprobarJugada(int fila, int colum){
        if(tableroTresEnRaya[fila][colum].equals(" ")){
            return true;
        }
        return false;
    }


    public void addJugadaAlHumano(int fila,int colum){

        tableroTresEnRaya[fila][colum] = "o";

    }


    public String verificarGanador(){
        String message = " ";
        int s;

        for(int i=0; i<tableroTresEnRaya.length;i++){


            for(int j=0; j<tableroTresEnRaya[0].length; j++){


                //Revisar columnas.
                s=0;
                for(int k=0; k<tableroTresEnRaya.length; k++){
                    
                    if(!tableroTresEnRaya[i][j].equals(" ") && tableroTresEnRaya[i][j].equalsIgnoreCase(tableroTresEnRaya[k][i])){
                        s++;
                    }

                    if(s==3){
                        message = tableroTresEnRaya[i][j];
                        return message;
                    }

                    if(k==tableroTresEnRaya.length-1){
                        s=0;
                    }
                }

                //Revisar filas

                s=0;
                for(int k=0; k<tableroTresEnRaya.length; k++){
                    
                    if(!tableroTresEnRaya[i][j].equals(" ") && tableroTresEnRaya[i][j].equalsIgnoreCase(tableroTresEnRaya[i][k])){
                        s++;
                    }

                    if(s==3){
                        message = tableroTresEnRaya[i][j];
                        return message;
                    }

                    if(k==tableroTresEnRaya.length-1){
                        s=0;
                    }
                }

                //Revisar diagonales desde la izquierda.
                
                for(int k=0; k<tableroTresEnRaya.length; k++){
                    s=0;
                    for(int t=0;t<2;t++){
                        if( !tableroTresEnRaya[i][j].equals(" ") && (i+t)<tableroTresEnRaya.length && (k+t)<tableroTresEnRaya.length && tableroTresEnRaya[i][j].equalsIgnoreCase(tableroTresEnRaya[i+t][k+t])){
                            s++;
                        }
                        
                    }

                    if(s==3){
                        message = tableroTresEnRaya[i][j];
                        return message;
                    }
                }

                //Revisar diagonales desde la derecha.
                
                for(int k=tableroTresEnRaya.length-1; k>0; k--){
                    s=0;
                    for(int t=2;t>0;t--){
                        if(!tableroTresEnRaya[i][j].equals(" ") && (t-i)>0 && (t-k)>0 && tableroTresEnRaya[i][j].equalsIgnoreCase(tableroTresEnRaya[t-i][t-k])){
                            s++;
                        }
                    }

                    if(s==3){
                        message = tableroTresEnRaya[i][j];
                        return message;
                    }
                }

                
            }
        }


        return " ";
    }

}