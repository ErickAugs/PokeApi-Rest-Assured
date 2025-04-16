package testes;

import io.restassured.response.Response;
import modelo.TipoPokemon;
import objeto.TipoPokemonServico;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.TesteBase;
import utils.Conversor;

import static org.testng.Assert.*;
import static utils.CodigosHttp.NAO_ENCONTRADO;


public class TipoPokemonTeste extends TesteBase {

    TipoPokemonServico servico = new TipoPokemonServico();

    @Test(description = "Deve retornar o tipo Eletric com sucesso")
    public void retornarTipoEletricComSucesso() {
        teste.info("Iniciando o teste de tipagem Eeltrica do pokemon");

        TipoPokemon tipo = servico.buscarTipo("electric");

        teste.info("<pre>" + Conversor.serializar(tipo) + "</pre>");

        assertEquals(tipo.getNome(), "electric", "Esperava que o nome do tipo fosse 'electric'.");
        assertTrue(tipo.getPokemons().size() > 0,  "Esperava que houvesse pokémons associados ao tipo.");
    }

    @Test(description = "Verificar que tipo 'fire' possui múltiplos Pokémon associados")
    public void deveConterMultiplosPokemonsNoTipoFire() {
        teste.info("Buscando tipo 'fire'...");

        TipoPokemon tipo = servico.buscarTipo("fire");
        teste.info("<pre>" + Conversor.serializar(tipo) + "</pre>");

        assertEquals(tipo.getNome(), "fire", "Esperava o nome 'fire'");
        assertTrue(tipo.getPokemons().size() > 5, "Esperava mais de 5 Pokémon associados ao tipo 'fire'");
    }


    @Test(description = "Deve retornar 404 ao buscar tipo inexistente")
    public void deveRetornarErroParaTipoInexistente() {
        String tipoInvalido = "dark-water-chuchu";
        teste.info("Buscando tipo inválido: " + tipoInvalido);

        Response resposta = servico.buscarPokemonInexistente(tipoInvalido);

        teste.info("Status retornado: " + resposta.statusCode());
        assertEquals(resposta.statusCode(), NAO_ENCONTRADO, "Esperava status 404 para tipo inexistente.");
    }
}
