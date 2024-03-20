package io.petstore.swagger.tasks;

import io.petstore.swagger.models.UserModel;
import io.petstore.swagger.questions.PutBuildUser;
import io.petstore.swagger.utils.Excel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Put;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PutUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<Map<String, String>> datos;

        try {
            datos = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Users.xlsx", "put");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }


        UserModel userInfo = actor.asksFor(PutBuildUser.was());

        actor.attemptsTo(
                Put.to(datos.get(0).get("endpoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .body(userInfo)
                )
        );


    }
    public static PutUserTask fromUser() {

        return instrumented(PutUserTask.class);
    }
}
