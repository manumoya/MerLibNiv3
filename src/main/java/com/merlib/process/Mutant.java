package com.merlib.process;

public class Mutant {

    /* Completa matriz con DNA */
    static boolean completeMatriz (char[][] arr, String[] dna ){
        int lenghMatriz = dna.length;
        for (int i = 0; i < lenghMatriz; i++) {
            char [] dnaSimple = dna[i].toCharArray();
            if (dnaSimple.length!=lenghMatriz || lenghMatriz<4){
                //System.out.println("Error en matriz DNA!!!! => Debe ser  NxN (N >= 4)");
                return false;
            }
            if (!valideLetter(dnaSimple)){
                //System.out.println("Error en  DNA!!!! => Letras no corresponden (deben ser A, T, C o G)");
                return false;
            }
            arr[i] = dnaSimple;
        }
        return true;
    }

    /* Valida que las letras sean las correctas*/
    static boolean valideLetter(char [] dnaSimple){
        int largo = dnaSimple.length;
        for (int i = 0; i < largo; i++) {
            if (dnaSimple[i]!='A' && dnaSimple[i]!='T' && dnaSimple[i]!='C' && dnaSimple[i]!='G'){
                return false;
            }
        }
        return true;
    }

    /* Print matriz con DNA */
    static void printMatriz (char[][] arr, int largoMatriz){
        for (int i = 0; i < largoMatriz; i++) {
            for (int j = 0; j < largoMatriz; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }

    /* Cuenta secuencia Horizontal*/
    static int countSecuenceHoriz (char[][] arr, int lenghMatriz){
        int countSecuenceHoriz=0;
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                if (lenghMatriz-j>=4) {
                    if (arr[i][j] == arr[i][j+ 1] &&
                            arr[i][j] == arr[i][j + 2] &&
                            arr[i][j] == arr[i][j + 3]
                    ) {
                        countSecuenceHoriz++;
                        j = j + 3;
                        /* Acelera la busqueda de la solución*/
                        if (countSecuenceHoriz>1){
                            return (countSecuenceHoriz);
                        }
                    }
                }
            }
        }
        return countSecuenceHoriz;
    }

    /* Cuenta secuencia de forma Vertical*/
    static int countSecuenceVert (char[][] arr, int lenghMatriz){
        int countSecuenceVert=0;
        for (int i = 0; i < lenghMatriz; i++) {
            for (int j = 0; j < lenghMatriz; j++) {
                if (lenghMatriz-i>=4) {
                    if (arr[i][j] == arr[i+1][j] &&
                            arr[i][j] == arr[i+2][j] &&
                            arr[i][j] == arr[i+3][j]
                    ) {
                        countSecuenceVert++;
                        j = j + 3;
                        /* Acelera la busqueda de la solución*/
                        if (countSecuenceVert>1){
                            return (countSecuenceVert);
                        }
                    }
                }
            }
        }
        //System.out.println("Secuencias Vertical: "+  countSecuenceVert);
        return countSecuenceVert;
    }

    /* Busca secuancia diagonal de IZQ a DER*/
    static int searchDiagIzqDer(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j<=lenghMatriz-1){
            if (indLimit == "J"){
                limit=lenghMatriz-j;
            }else{
                limit=lenghMatriz-i;
            }
            if (limit>=4) {
                if (arr[i][j] == arr[i+1][j+1] &&
                        arr[i][j] == arr[i+2][j+2] &&
                        arr[i][j] == arr[i+3][j+3]
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j++;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Izquierda a Derecha */
    static int countSecuenceDiagIzqDer (char[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indI = lenghMatriz-1; indI >= 0; indI--) {
            //i=indI;
            if (indI==0){
                for (int indJ = 0; indJ < lenghMatriz; indJ++) { // busca desde [0,n]
                    i=indI;
                    j=indJ;
                    int cont = searchDiagIzqDer(arr, lenghMatriz, i, j, "J");
                    countSecuence = countSecuence + cont;
                }
            }else{ // busca desde [n,0]
                i=indI;
                int cont = searchDiagIzqDer(arr, lenghMatriz, i, j, "I");
                countSecuence = countSecuence + cont;
            }
            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }
        }
        return countSecuence;
    }

    /* Busca secuencia diagonal de DER a IZq*/
    static int searchDiagDerIzq(char[][] arr, int lenghMatriz, int i, int j, String indLimit){
        int contSecuencia =0;
        int limit=0;
        while (i<=lenghMatriz-1 && j>=0){
            if (indLimit == "J"){
                limit=j;
            }else{
                limit=lenghMatriz-i-1;
            }
            if (limit>=3) {
                if (arr[i][j] == arr[i+1][j-1] &&
                        arr[i][j] == arr[i+2][j-2] &&
                        arr[i][j] == arr[i+3][j-3]
                ) {
                    contSecuencia++;
                }
            }
            i++;
            j--;
        }
        return contSecuencia;
    }

    /* Cuenta secuencia de forma diagonal Derecha a Izquierda */
    static int countSecuenceDiagDerIzq (char[][] arr, int lenghMatriz){
        int i=0;
        int j=0;
        int countSecuence=0;
        for (int indJ = 0; indJ <= lenghMatriz-1; indJ++) {
            if (indJ==lenghMatriz-1){
                for (int indI = 0; indI <= lenghMatriz-1 ; indI++) { // busca desde [n,n]
                    i=indI;
                    j=indJ;
                    int cont = searchDiagDerIzq(arr, lenghMatriz, i, j, "I");
                    countSecuence = countSecuence + cont;
                }
            }else{ // busca desde [0,n]
                j=indJ;
                int cont = searchDiagDerIzq(arr, lenghMatriz, i, j, "J");
                countSecuence = countSecuence + cont;
            }

            // Acelera busqueda de solución
            if (countSecuence > 1){
                return countSecuence;
            }

        }
        return countSecuence;
    }

    /* Evalua si es mutante o no */
    public static boolean isMutant(String[] dna){
        int lenghMatriz = dna.length;
        char[][] arr = new char[lenghMatriz][lenghMatriz];
        if (!completeMatriz(arr,dna)){
            return false;
        }

        /* Imprime matriz  */
        //printMatriz(arr, lenghMatriz);

        /* ***************************************************
        * EVALUA RESULTADOS PARA DETERMINAR SI ES MUTANTE O NO
        * *****************************************************/

        /* Evalúa secuencia horizontal  */
        int totalSecuenceHoriz=0;
        totalSecuenceHoriz = countSecuenceHoriz(arr, lenghMatriz);
        if (totalSecuenceHoriz>1){
            return true;
        }

        /* Evalúa secuencia vertical + horizontal  */
        int totSecuenceVert=0;
        totSecuenceVert = countSecuenceVert(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER */
        int totalSecuenceDiagIzqDer=0;
        totalSecuenceDiagIzqDer = countSecuenceDiagIzqDer(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer)>1){
            return true;
        }

        /* Evalúa secuencia horizontal + vertical + diagonal IZQ => DER + diagonal DER => IZQ */
        int totalSecuenceDiagDerIzq=0;
        totalSecuenceDiagDerIzq = countSecuenceDiagDerIzq(arr, lenghMatriz);
        if ((totalSecuenceHoriz+totSecuenceVert+totalSecuenceDiagIzqDer+totalSecuenceDiagDerIzq)>1){
            return true;
        }

        // Si no encuntra secuencia mutante
        return false;
    }

}