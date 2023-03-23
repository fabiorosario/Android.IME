package fabiorosario.ime.pgsc.componentesandroid;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class MeuJsonReaderWriter {
    private String login;
    private String senha;
    private String email;
    private String json;

    public MeuJsonReaderWriter(String login, String senha, String email) {
        this.login = login;
        this.senha = senha;
        this.email = email;
    }

    public MeuJsonReaderWriter(String json){
        this.json = json;
    }

    public String createJson() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString( new Usuario(login, senha, email) );
    }

    public Usuario readJson() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper( );
        return (Usuario) objectMapper.readValue( json, Usuario.class );
    }
}
