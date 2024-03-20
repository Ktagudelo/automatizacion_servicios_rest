package io.petstore.swagger.questions;

import io.petstore.swagger.models.UserModel;
import io.petstore.swagger.utils.Excel;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

public class PostBuildUser implements Question<UserModel> {

    @Override
    public UserModel answeredBy(Actor actor) {

        ArrayList<Map<String, String>> datos;

        try {
            datos = Excel.leerDatosDeHojaDeExcel("src/test/resources/Data/Users.xlsx", "post");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        UserModel postUserData= UserModel.builder()
                .id(4)
                .username(datos.get(0).get("username"))
                .firstName(datos.get(0).get("firstName"))
                .lastName(datos.get(0).get("lastName"))
                .email(datos.get(0).get("email"))
                .password(datos.get(0).get("password"))
                .phone(datos.get(0).get("phone"))
                .userStatus(1)

                .build();
        return postUserData;
    }

    public static PostBuildUser was(){
        return  new PostBuildUser();

    }
}
