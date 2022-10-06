package PageSteps;
import io.qameta.allure.Allure;

import io.qameta.allure.Step;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;
public class APITestMortySteps {
    @Step("����� ���������� �� ��������� ����� ����")
    public static String morty() {
        Response response = given()
                .baseUri("https://rickandmortyapi.com")
                .contentType(ContentType.JSON)
                .log().all()
                .when()
                .get("/api/character/2")
                .then()
                .statusCode(200)
                .extract().response();
        return response.getBody().asString();
    }
    @Step("������� �� ������ ��������� ������, ��� ��������� �����")
    public static String episode(JSONObject mortyJO) {
        JSONArray episodesWithMorty = mortyJO.getJSONArray("episode");
        int episodeWithMorty = episodesWithMorty.length();
        String lastEpisode = episodesWithMorty.getString(episodeWithMorty - 1);
        Allure.addAttachment("��������� ������ � �������� �����",
                lastEpisode.substring(lastEpisode.length() - 2));
        Response response1 = given()
        .contentType(ContentType.JSON)
                .get(lastEpisode)
                .then().extract().response();
        return response1.getBody().asString();
    }
    @Step("�������� �� ������ ���������� ������� ���������� ���������")
    public static String lastChar(JSONObject lastEpisode) {
        JSONArray allChars = lastEpisode.getJSONArray("characters");
        int charCount = allChars.length();
        String lastChar = allChars.getString(charCount - 1);
        Response response2 = given()
                .contentType(ContentType.JSON)
                .get(lastChar)
                .then().extract().response();
        return response2.getBody().asString();
    }
    @Step("���������, ���� �������� ��� �� ���� � ��������� ��� �� ��� � �����")
    public static void match(JSONObject charJson, JSONObject mortyJson) {
        String charName = charJson.getString("name");
        String charSpecies = charJson.getString("species");
        String charLocation = charJson.getJSONObject("location").getString("name");
        String Char = "\n��������� �������� � "+charName+
                      "\n���� � "+charSpecies+ "" +
                      "\n������� � " + charLocation;
        Allure.addAttachment("���������� � ���������", Char);
        String mortyName = mortyJson.getString("name");
        String mortySpecies = mortyJson.getString("species");
        String mortyLocation = mortyJson.getJSONObject("location").getString("name");
        String morty =  "\n�� ����� � " +mortyName+ "" +
                        "\n���� � " +mortySpecies+
                        "\n������� � " + mortyLocation;
        Allure.addAttachment("�����", morty);
        String compareResult = "";
        if(mortySpecies.equals(charSpecies)) {
            compareResult += "���� " + mortyName + " � " + charName + " ���������";
        } else compareResult += "���� " + mortyName + " � " + charName + " �� ���������";
        if(mortyLocation.equals(charLocation)) {
            compareResult += "\n������� " + mortyName + " � " + charName + " ���������";
        } else compareResult += "\n������� " + mortyName + " � " + charName + " �� ���������";
        Allure.addAttachment("��������� ���������:", compareResult);
    }
}
