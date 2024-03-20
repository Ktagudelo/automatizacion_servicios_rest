package io.petstore.swagger.tasks;

import io.petstore.swagger.utils.Excel;
import io.restassured.http.ContentType;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class GetUserTask implements Task {

    @Override
    public <T extends Actor> void performAs(T actor) {

        ArrayList<Map<String, String>> datos;

        try {
            datos = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Users.xlsx", "get");
        } catch (
                IOException e) {
            throw new RuntimeException(e);
        }

        actor.attemptsTo(
                Get.resource(datos.get(0).get("endpoint")).with(
                        requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)

                )
        );

    }

    public static GetUserTask fromUser() {

        return instrumented(GetUserTask.class);
    }
}
