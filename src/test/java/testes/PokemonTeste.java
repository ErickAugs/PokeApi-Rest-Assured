package testes;

import io.restassured.response.Response;
import modelo.Pokemon;
import objeto.PokemonServico;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.TesteBase;
import utils.Conversor;

import static org.testng.Assert.assertEquals;
import static utils.CodigosHttp.*;

public class PokemonTeste extends TesteBase {

    PokemonServico servico = new PokemonServico();

    @Test(description = "Deve retornar o Pokémon Pikachu com sucesso")
    public void deveRetornarPokemonPikachu() {
        test.info("Iniciando validação do Pokémon Pikachu...");

        Pokemon pikachu = servico.buscarPokemon("pikachu");

        String jsonFormatado = Conversor.serializar(pikachu);
        test.info("Objeto deserializado da resposta:");
        test.info("<pre>" + jsonFormatado + "</pre>");

        test.info("Nome retornado: " + pikachu.getNome());
        test.info("ID retornado: " + pikachu.getId());
        test.info("Altura: " + pikachu.getAltura() + " | Peso: " + pikachu.getPeso());

        assertEquals(pikachu.getNome(), "pikachu", "Esperava que o nome do Pokémon fosse pikachu.");
        assertEquals(pikachu.getId(), 25, "Esperava que o ID do Pikachu fosse 25.");
    }

    @Test(description = "Deve retornar 404 ao buscar Pokémon inexistente")
    public void deveRetornarErroParaPokemonInexistente() {
        test.info("Buscando Pokémon inexistente: pikachuchu");

        Response resposta = servico.buscarPokemonCru("pikachuchu");

        long tempoResposta = resposta.getTime();
        test.info("Tempo de resposta: " + tempoResposta + "ms");

        Assert.assertEquals(resposta.statusCode(), NAO_ENCONTRADO, "Esperava status 404 para Pokémon inexistente.");
    }
}
