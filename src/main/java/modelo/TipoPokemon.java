package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TipoPokemon {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("pokemon")
    private List<PokemonRelacionado> pokemons;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<PokemonRelacionado> getPokemons() {
        return pokemons;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PokemonRelacionado {

        @JsonProperty("pokemon")
        private PokemonResumo pokemon;

        public PokemonResumo getPokemon() {
            return pokemon;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class PokemonResumo {

        @JsonProperty("name")
        private String nome;

        public String getNome() {
            return nome;
        }
    }
}
