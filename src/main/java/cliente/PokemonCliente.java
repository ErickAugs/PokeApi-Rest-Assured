package cliente;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static constantes.Constantes.URL_BASE_POKEAPI;

public class PokemonCliente {

    public Response getPokemon(String nome) {
        return given()
                .baseUri(URL_BASE_POKEAPI)
                .basePath("/pokemon/" + nome.toLowerCase())
                .when()
                .get();
    }
}
