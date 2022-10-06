package PageSteps;

import io.qameta.allure.Allure;
import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static hooks.APIHooks.getJson;
import static io.restassured.RestAssured.given;

public class APITestTomato {

    @Step("���� JSONObject")
    public static JSONObject getJO(String fileName) throws IOException {
        getJson(fileName);
        return new JSONObject(new String(Files.readAllBytes(Paths.get("src/test/resources/" + fileName))));
    }

    @Step("������ ����/��������")
    public static JSONObject putJO(JSONObject jsonObject, String key1, Object value1, String key2, Object value2) {
        jsonObject.put(key1, value1);
        jsonObject.put(key2, value2);
        return jsonObject;
    }

    @Step("���������� ������ � �������� �����")
    public static JSONObject inOutJO(JSONObject jsonObject, String url) {
        Response response = given()
                .baseUri(url)
                .contentType("application/json;charset=UTF-8")
                .when()
                .body(jsonObject.toString())
                .post("/api/users")
                .then()
                .statusCode(201)
                .extract().response();

        String tomato = response.getBody().asString();
        return (new JSONObject(tomato));
    }

    @Step("������ ��������")
    public static void assertJO(JSONObject jsonObject) {
        String result;
        if (jsonObject.getString("name").equals("Tomato")
                && jsonObject.getString("job").equals("Eat maket")) {
            result = "�������� ��������";
        } else result = "�������� �� ��������";
        Allure.addAttachment("��������� ��������: ", result);
    }
}