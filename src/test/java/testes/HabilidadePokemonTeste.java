package testes;

import io.restassured.response.Response;
import modelo.Habilidade;
import objeto.HabilidadePokemonServico;
import org.testng.Assert;
import org.testng.annotations.Test;
import runners.TesteBase;
import utils.Conversor;

import static org.testng.Assert.assertEquals;
import static utils.CodigosHttp.NAO_ENCONTRADO;

public class HabilidadePokemonTeste extends TesteBase {

    HabilidadePokemonServico servico = new HabilidadePokemonServico();

    @Test(description = "Deve retornar a habilidade Static com sucesso")
    public void deveRetornarHabilidadeStatic() {
        test.info("Iniciando teste da habilidade: static");

        Habilidade habilidade = servico.buscarHabilidade("static");

        test.info("<pre>" + Conversor.serializar(habilidade) + "</pre>");

        Assert.assertEquals(habilidade.getNome(), "static", "Esperava que o nome da habilidade fosse 'static'.");
        Assert.assertEquals(habilidade.getEfeitos().size() > 0, true, "Esperava que houvesse efeitos listados.");
        Assert.assertEquals(habilidade.getPokemonsRelacionados().size() > 0, true, "Esperava Pokémon relacionados à habilidade.");
    }

    @Test(description = "Validar Pokémon associados à habilidade Overgrow")
    public void deveConterPokemonsNaHabilidadeOvergrow() {
        test.info("Verificando Pokémon associados à habilidade 'overgrow'...");

        Habilidade habilidade = servico.buscarHabilidade("overgrow");
        test.info("<pre>" + Conversor.serializar(habilidade) + "</pre>");

        Assert.assertEquals(habilidade.getNome(), "overgrow", "Esperava habilidade 'overgrow'");
        assert habilidade.getPokemonsRelacionados().size() > 0 : "Esperava Pokémon associados à habilidade";

        String nomePrimeiroPokemon = habilidade.getPokemonsRelacionados().get(0).getPokemon().getNome();
        assert nomePrimeiroPokemon != null && !nomePrimeiroPokemon.isEmpty() : "Esperava nome de Pokémon no campo 'pokemon'";
    }

    @Test(description = "Deve retornar 404 ao buscar habilidade inexistente")
    public void deveRetornarErroParaHabilidadeInexistente() {
        String habilidadeInvalida = "super-salto-triplo";
        test.info("Buscando habilidade inválida: " + habilidadeInvalida);

        Response resposta = servico.buscarHabilidadeCru(habilidadeInvalida);

        test.info("Status retornado: " + resposta.statusCode());
        Assert.assertEquals(resposta.statusCode(), NAO_ENCONTRADO, "Esperava status 404 para habilidade inexistente.");
    }
}
