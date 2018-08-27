/**
 *
 */


import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.eti.vendrameto.gft.ProcessorGFT;

/**
 * @author developer
 *
 */
public class ProcessorGFTTest {

	private ProcessorGFT processor;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		processor = new ProcessorGFT();
	}

	@Test
	public void testErroParametros() {
		String input = "test";
		String output = "parâmetros de entrada invalida!";

		String retorno = processor.processa(input);

		assertEquals("Erro no tratamento de parâmetros inválidos", output, retorno);
	}

	@Test
	public void testErroTipoDishInvalido() {
		String input = "dinner, 1, 2, 2";
		String output = "Dish type invalida!";

		String retorno = processor.processa(input);

		assertEquals("Entrada com tipo de dish invalido", output, retorno);
	}

	@Test
	public void testValidacaoResultado01() {
		String input = "morning, 1, 2, 3";
		String output = "eggs, toast, coffee";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

	@Test
	public void testValidacaoResultado02() {
		String input = "morning, 2, 1, 3";
		String output = "eggs, toast, coffee";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

	@Test
	public void testValidacaoResultado03() {
		String input = "morning, 1, 2, 3, 4";
		String output = "eggs, toast, coffee, error";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

	@Test
	public void testValidacaoResultado04() {
		String input = "morning, 1, 2, 3, 3, 3";
		String output = "eggs, toast, coffee(x3)";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

	@Test
	public void testValidacaoResultado05() {
		String input = "night, 1, 2, 3, 4";
		String output = "steak, potato, wine, cake";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

	@Test
	public void testValidacaoResultado06() {
		String input = "night, 1, 2, 2, 4";
		String output = "steak, potato(x2), cake";

		String retorno = processor.processa(input);

		assertEquals(String.format("Retorno valido esperado [%s] recebido [%s]", output, retorno), output, retorno);
	}

}
