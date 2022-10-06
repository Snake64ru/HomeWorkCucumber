import hooks.APIHooks;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static PageSteps.APITestMortySteps.*;
import static PageSteps.APITestTomato.*;

public class APITests extends APIHooks {
    @Test
    public void mortyy() {

        JSONObject mortyJson = new JSONObject(morty());
        JSONObject episodeJson = new JSONObject(episode(mortyJson));
        JSONObject characterJson = new JSONObject(lastChar(episodeJson));
        match(characterJson, mortyJson);
    }


    @Test
    public void potato() throws IOException {

        JSONObject jsonObject = getJO("potato.json");
        putJO(jsonObject, "name", "Tomato", "job", "Eat maket");
        JSONObject responseJO = inOutJO(jsonObject, "https://reqres.in/");
        assertJO(responseJO);
    }
}