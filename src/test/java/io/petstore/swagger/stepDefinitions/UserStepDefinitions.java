package io.petstore.swagger.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.petstore.swagger.questions.DeleteResponseCode;
import io.petstore.swagger.questions.GetResponseCode;
import io.petstore.swagger.questions.PostResponseCode;
import io.petstore.swagger.questions.PutResponseCode;
import io.petstore.swagger.tasks.DeleteUserTask;
import io.petstore.swagger.tasks.GetUserTask;
import io.petstore.swagger.tasks.PostUserTask;
import io.petstore.swagger.tasks.PutUserTask;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static io.petstore.swagger.constants.Constants.CODE;
import static io.petstore.swagger.constants.Constants.URL_BASE_USER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.equalTo;

public class UserStepDefinitions {

    private static final String restAPI= URL_BASE_USER;
    private static final int restCODE= CODE;

    @When("I consume the endpoint and I send the user information")
    public void iConsumeTheEndpointAndISendTheUserInformation() {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PostUserTask.fromUser()
        );

    }

    @Then("I can validate the create user response code")
    public void iCanValidateTheCreateUserResponseCode() {
        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is", PostResponseCode.was(),equalTo(restCODE)
                )
        );

    }

    @When("I consume the endpoint and I get the user information")
    public void iConsumeTheEndpointAndIGetTheUserInformation() {

        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                GetUserTask.fromUser()
        );
    }

    @Then("I can validate the get user response code")
    public void iCanValidateTheGetUserResponseCode() {

        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is", GetResponseCode.was(),equalTo(restCODE)
                )
        );
    }

    @When("I consume the endpoint and I update the user information")
    public void iConsumeTheEndpointAndIUpdateTheUserInformation() {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                PutUserTask.fromUser()
        );

    }

    @Then("I can validate the update user response code")
    public void iCanValidateTheUpdateUserResponseCode() {
        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is", PutResponseCode.was(),equalTo(restCODE)
                )
        );

    }

    @When("I consume the endpoint and I delete the user information")
    public void iConsumeTheEndpointAndIDeleteTheUserInformation() {
        Actor user= Actor.named("user")
                .whoCan(CallAnApi.at(restAPI));
        user.attemptsTo(
                DeleteUserTask.fromUser()
        );

    }

    @Then("I can validate the delete user response code")
    public void iCanValidateTheDeleteUserResponseCode() {

        Actor user= Actor.named("user");

        user.should(
                seeThat(
                        "The response code is", DeleteResponseCode.was(),equalTo(restCODE)
                )
        );

    }

}
