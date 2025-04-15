package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {

    @JsonProperty("name")
    private String nome;

    @JsonProperty("id")
    private int id;

    @JsonProperty("height")
    private int altura;

    @JsonProperty("weight")
    private int peso;

    @JsonProperty("types")
    private List<TipoWrapper> tipos;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getAltura() {
        return altura;
    }

    public int getPeso() {
        return peso;
    }

    public List<TipoWrapper> getTipos() {
        return tipos;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class TipoWrapper {

        @JsonProperty("type")
        private Tipo tipo;

        public Tipo getTipo() {
            return tipo;
        }

        public void setTipo(Tipo tipo) {
            this.tipo = tipo;
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class Tipo {

            @JsonProperty("name")
            private String nome;

            public String getNome() {
                return nome;
            }

            public void setNome(String nome) {
                this.nome = nome;
            }
        }
    }
}