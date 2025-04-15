package cliente;

import io.restassured.response.Response;

import static constantes.Constantes.URL_BASE_POKEAPI;
import static io.restassured.RestAssured.given;

public class HabilidadeCliente {

    public Response getHabilidade(String nome) {
        return given()
                .baseUri(URL_BASE_POKEAPI)
                .basePath("/ability/" + nome.toLowerCase())
                .when()
                .get();
    }
}
