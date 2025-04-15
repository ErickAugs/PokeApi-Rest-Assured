package modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Habilidade {

    @JsonProperty("id")
    private int id;

    @JsonProperty("name")
    private String nome;

    @JsonProperty("effect_entries")
    private List<Efeito> efeitos;

    @JsonProperty("pokemon")
    private List<PokemonRelacionado> pokemonsRelacionados;

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public List<Efeito> getEfeitos() {
        return efeitos;
    }

    public List<PokemonRelacionado> getPokemonsRelacionados() {
        return pokemonsRelacionados;
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Efeito {

        @JsonProperty("short_effect")
        private String efeitoCurto;

        @JsonProperty("language")
        private Idioma idioma;

        public String getEfeitoCurto() {
            return efeitoCurto;
        }

        public Idioma getIdioma() {
            return idioma;
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Idioma {

        @JsonProperty("name")
        private String nome;

        public String getNome() {
            return nome;
        }
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
