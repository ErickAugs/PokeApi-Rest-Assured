package cliente;

import io.restassured.response.Response;

import static constantes.Constantes.URL_BASE_POKEAPI;
import static io.restassured.RestAssured.given;

public class TipoPokemonCliente {
    public Response getTipo(String nome) {
        return given()
                .baseUri(URL_BASE_POKEAPI)
                .basePath("/type/" + nome.toLowerCase())
                .when()
                .get();
    }
}
