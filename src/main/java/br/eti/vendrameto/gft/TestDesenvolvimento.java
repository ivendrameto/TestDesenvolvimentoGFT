/**
 *
 */
package br.eti.vendrameto.gft;

import java.util.Scanner;

/**
 * @author developer
 */
public class TestDesenvolvimento {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String entradaDeDados = sc.nextLine();

		ProcessorGFT processor = new ProcessorGFT();
		System.out.println(processor.processa(entradaDeDados));
	}

}
