package objeto;

import cliente.PokemonCliente;
import io.restassured.response.Response;
import modelo.Pokemon;

import static org.hamcrest.Matchers.notNullValue;
import static utils.CodigosHttp.OK;
import static utils.Conversor.deserializar;

public class PokemonServico {
    private final PokemonCliente cliente = new PokemonCliente();

    public Pokemon buscarPokemon(String nome) {
        Response resposta = cliente.getPokemon(nome);

        resposta.then()
                .statusCode(OK)
                .body("name", notNullValue());

        return deserializar(resposta, Pokemon.class);
    }

    public Response buscarPokemonInexistente(String nome) {
        return cliente.getPokemon(nome);
    }
}

