package desafioTec.digix;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import desafioTec.digix.controller.PontuacaoController;
import desafioTec.digix.criteria.CriterioPontuacao;
import desafioTec.digix.model.Familia;
import desafioTec.digix.service.CalculadoraPontuacao;
import desafioTec.digix.service.CriterioFactory;
import desafioTec.digix.service.IListagemFamiliaService;
import desafioTec.digix.service.IObtemFamilia;
import desafioTec.digix.service.ListagemFamiliaService;
import desafioTec.digix.service.ObtemFamilia;

@SpringBootApplication
public class DigixApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(DigixApplication.class, args);

		List<CriterioPontuacao> criterios = new CriterioFactory().criarCriterios();
		CalculadoraPontuacao calculadoraPontuacao = new CalculadoraPontuacao(criterios);
		IObtemFamilia obtemFamilia = new ObtemFamilia(calculadoraPontuacao);
		IListagemFamiliaService listaFamilia = new ListagemFamiliaService(obtemFamilia);
		PontuacaoController pontuacaoController = new PontuacaoController(listaFamilia);

		Scanner scanner = new Scanner(System.in);
		List<Familia> familiasCadastradas = new ArrayList<>();

		System.out.println("Bem vindo ao Cadastro de Famílias para Habite-se");
		System.out.println("Digite 1 para cadastrar famílias e 0 para sair do sistema!");
		var opcao = scanner.nextInt();
		if (opcao == 0)
			System.exit(opcao);
		while (opcao == 1) {
			System.out.println("Digite a renda da Família:");
			int rendaDaFamilia = scanner.nextInt();
			System.out.println("Digite a quantidade de dependentes (com menos de 18 anos) totais:");
			int dependentesDafmailia = scanner.nextInt();

			familiasCadastradas.add(new Familia(rendaDaFamilia, dependentesDafmailia));
			System.out.println("Família cadastrada com sucesso!");
			System.out.println("Digite 1 para cadastrar famílias e 0 para imprimir a lista de familias ordenadas");
			opcao = scanner.nextInt();
		}

		List<Familia> familiasOrdenadas = pontuacaoController.listarFamiliaPontuada(familiasCadastradas);

		for (var familia : familiasOrdenadas) {
			System.out.println(
					" Renda: " + familia.getRendaTotal() + ", \n Dependentes: "
							+ familia.getTotaisDedependentes()
							+ ", \n Pontuação: " + calculadoraPontuacao.calcularPontuacaoTotal(familia));
		}

		System.exit(opcao);
	}
}
