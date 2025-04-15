package objeto;

import cliente.HabilidadeCliente;
import io.restassured.response.Response;
import modelo.Habilidade;

import static org.hamcrest.Matchers.notNullValue;
import static utils.CodigosHttp.OK;
import static utils.Conversor.deserializar;

public class HabilidadePokemonServico {

    private final HabilidadeCliente cliente = new HabilidadeCliente();

    public Habilidade buscarHabilidade(String nome) {
        Response resposta = cliente.getHabilidade(nome);

        resposta.then()
                .statusCode(OK)
                .body("name", notNullValue())
                .body("effect_entries", notNullValue())
                .body("pokemon", notNullValue());

        return deserializar(resposta, Habilidade.class);
    }

    public Response buscarHabilidadeCru(String nome) {
        return cliente.getHabilidade(nome);
    }
}
