package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;

public class Conversor {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static <T> T deserializar(Response resposta, Class<T> classe) {
        try {
            return mapper.readValue(resposta.asString(), classe);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao deserializar resposta para " + classe.getSimpleName(), e);
        }
    }

    public static String serializar(Object objeto) {
        try {
            return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(objeto);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao serializar objeto " + objeto.getClass().getSimpleName(), e);
        }
    }
}
