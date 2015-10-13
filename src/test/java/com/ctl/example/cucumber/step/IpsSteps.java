package com.ctl.example.cucumber.step;

import com.ctl.example.cucumber.config.CucumberConfiguration;
import com.ctl.security.ips.client.IpsInstallClient;
import com.ctl.security.ips.common.domain.ips.configuration.IpsInstallConfiguration;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.web.client.HttpServerErrorException;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by kevin on 10/8/15.
 */
@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = CucumberConfiguration.class)
public class IpsSteps {

    @Autowired
    private IpsInstallClient ipsInstallClient;

    private IpsInstallConfiguration ipsInstallConfiguration;
    private String bearerToken;

    @Given("^a Centurylink customer has a server$")
    public void a_Centurylink_customer_has_a_server() throws Throwable {
        ipsInstallConfiguration = null;
        bearerToken = null;
    }

    @When("^IPS is installed on that server$")
    public void ips_is_installed_on_that_server() throws Throwable {
        try{
            ipsInstallClient.install(ipsInstallConfiguration, bearerToken);
        }
        catch(HttpServerErrorException e){
            httpServerErrorException = e;
        }
    }

    private HttpServerErrorException httpServerErrorException;

    @Then("^the server is protected with IPS$")
    public void the_server_is_protected_with_IPS() throws Throwable {
        assertNull(httpServerErrorException);

//        boolean ipsIsInstalled = ipsInstallClient.verifyInstallation(ipsInstallConfiguration, bearerToken);

//        assertTrue(ipsIsInstalled);
    }

}
