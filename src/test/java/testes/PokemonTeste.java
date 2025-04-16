package testes;

import io.restassured.response.Response;
import modelo.Pokemon;
import objeto.PokemonServico;
import org.testng.annotations.Test;
import runners.TesteBase;
import utils.Conversor;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static utils.CodigosHttp.*;

public class PokemonTeste extends TesteBase {

    PokemonServico servico = new PokemonServico();

    @Test(description = "Deve retornar o Pokémon Pikachu com sucesso")
    public void deveRetornarPokemonPikachu() {
        teste.info("Iniciando validação do Pokémon Pikachu...");

        Pokemon pikachu = servico.buscarPokemon("pikachu");

        teste.info("<pre>" + Conversor.serializar(pikachu) + "</pre>");

        assertEquals(pikachu.getNome(), "pikachu", "Esperava que o nome do Pokémon fosse pikachu.");
        assertEquals(pikachu.getId(), 25, "Esperava que o ID do Pikachu fosse 25.");
    }

    @Test(description = "Validar estrutura mínima do Pokémon Bulbasaur")
    public void deveValidarEstruturaDoBulbasaur() {
        teste.info("Validando estrutura do Pokémon Bulbasaur...");

        Pokemon bulbasaur = servico.buscarPokemon("bulbasaur");
        teste.info("<pre>" + Conversor.serializar(bulbasaur) + "</pre>");

        assertEquals(bulbasaur.getNome(), "bulbasaur", "Esperava o nome 'bulbasaur'");
        assertTrue(bulbasaur.getAltura() > 0, "Altura deve ser maior que zero");
        assertTrue(bulbasaur.getPeso() > 0, "Peso deve ser maior que zero");
    }

    @Test(description = "Deve retornar 404 ao buscar Pokémon inexistente")
    public void deveRetornarErroParaPokemonInexistente() {
        teste.info("Buscando Pokémon inexistente: pikachuchu");

        Response resposta = servico.buscarPokemonInexistente("pikachuchu");

        double tempoResposta = resposta.getTime();
        teste.info("Tempo de resposta: " + tempoResposta + "ms");

        assertEquals(resposta.statusCode(), NAO_ENCONTRADO, "Esperava status 404 para Pokémon inexistente.");
    }
}
