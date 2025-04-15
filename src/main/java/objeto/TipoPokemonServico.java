package objeto;

import cliente.TipoPokemonCliente;
import io.restassured.response.Response;
import modelo.TipoPokemon;

import static org.hamcrest.Matchers.notNullValue;
import static utils.CodigosHttp.OK;
import static utils.Conversor.deserializar;

public class TipoPokemonServico {
    private final TipoPokemonCliente cliente = new TipoPokemonCliente();

    public TipoPokemon buscarTipo(String nome) {
        Response resposta = cliente.getTipo(nome);

        resposta.then()
                .statusCode(OK)
                .body("name", notNullValue());

        return deserializar(resposta, TipoPokemon.class);
    }

    public Response buscarPokemonCru(String nome) {
        return cliente.getTipo(nome);
    }
}
