package testes;

import io.restassured.response.Response;
import modelo.Habilidade;
import objeto.HabilidadePokemonServico;
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

        assertEquals(habilidade.getNome(), "static", "Esperava que o nome da habilidade fosse 'static'.");
        assertEquals(habilidade.getEfeitos().size() > 0, true, "Esperava que houvesse efeitos listados.");
        assertEquals(habilidade.getPokemonsRelacionados().size() > 0, true, "Esperava Pokémon relacionados à habilidade.");
    }

    @Test(description = "Deve retornar 404 ao buscar habilidade inexistente")
    public void deveRetornarErroParaHabilidadeInexistente() {
        String habilidadeInvalida = "super-salto-triplo";
        test.info("Buscando habilidade inválida: " + habilidadeInvalida);

        Response resposta = servico.buscarHabilidadeCru(habilidadeInvalida);

        test.info("Status retornado: " + resposta.statusCode());
        assertEquals(resposta.statusCode(), NAO_ENCONTRADO, "Esperava status 404 para habilidade inexistente.");
    }
}
