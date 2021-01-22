/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MetodosOrdenamientoInterno4;

/**
 *
 * @author Aran Solis
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int arr[] = {12, 11, 13, 5, 6, 7};

        System.out.println("Dado arreglo ");
        imprimir(arr);

        Main ob = new Main();
        ob.mergesort(arr, 0, arr.length - 1);

        System.out.println("\nArreglo ordenado");
        imprimir(arr);
    }

    public static void mergesort(int A[], int izq, int der) {
        if (izq < der) {
            
            int m = (izq + der) / 2;
            mergesort(A, izq, m);
            mergesort(A, m + 1, der);
            merge(A, izq, m, der);
        }
    }

    public static void merge(int A[], int izq, int m, int der) {
        int i, j, k;
        int[] B = new int[A.length]; //array auxiliar
        for (i = izq; i <= der; i++) //copia ambas mitades en el array auxiliar                                       
        {
            B[i] = A[i];
        }

        i = izq;
        j = m + 1;
        k = izq;

        while (i <= m && j <= der) //copia el siguiente elemento más grande                                      
        {
            if (B[i] <= B[j]) {
                A[k++] = B[i++];
            } else {
                A[k++] = B[j++];
            }
        }

        while (i <= m) //copia los elementos que quedan de la
        {
            A[k++] = B[i++]; //primera mitad (si los hay)
        }
    }

    public static void imprimir(int[] a) {
        for (int i = 0; i < a.length; i++) { //IMPRIMO 
            System.out.print("[" + a[i] + "]");
        }
        System.out.println("\n");
    }
}
