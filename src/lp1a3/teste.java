package lp1a3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class teste {

public static void main(String[] args) throws Exception {
				
		double[] vet1 = new double[20];
		
		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 20; i++) {
			System.out.println("Insira um n�mero: ");
			vet1[i] = scanner.nextDouble();
		}
		
		double media = 0;	
		for (double num : vet1) {
			media = media + num;
		}
		media = media / vet1.length;
		
		System.out.println("\nA m�dia foi de " + media);
		System.out.println("\nOs valores menores do que a m�dia de valores s�o: ");
		for (double i : vet1) {
			if (i < media) {
				System.out.print(i + ", ");
			}
		}
	}
}


