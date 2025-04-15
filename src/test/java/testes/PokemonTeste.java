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

        test.info("<pre>" + Conversor.serializar(pikachu) + "</pre>");

        Assert.assertEquals(pikachu.getNome(), "pikachu", "Esperava que o nome do Pokémon fosse pikachu.");
        Assert.assertEquals(pikachu.getId(), 25, "Esperava que o ID do Pikachu fosse 25.");
    }

    @Test(description = "Validar estrutura mínima do Pokémon Bulbasaur")
    public void deveValidarEstruturaDoBulbasaur() {
        test.info("Validando estrutura do Pokémon Bulbasaur...");

        Pokemon bulbasaur = servico.buscarPokemon("bulbasaur");
        test.info("<pre>" + Conversor.serializar(bulbasaur) + "</pre>");

        assertEquals(bulbasaur.getNome(), "bulbasaur", "Esperava o nome 'bulbasaur'");
        assert bulbasaur.getAltura() > 0 : "Altura deve ser maior que zero";
        assert bulbasaur.getPeso() > 0 : "Peso deve ser maior que zero";
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
