/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:RegisterResource
 * [register]<br>
 * USAGE:
 * <pre>
 *        RegisterJerseyClient client = new RegisterJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class RegisterJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ReviewBaseSystem/webresources";

    public RegisterJerseyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("register");
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void RegisterUser(String name, String phno, String pass, String interest, String gender, String email, String city, String bdate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("RegisterUser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, phno, pass, interest, gender, email, city, bdate})).request().post(null);
    }

    public void close() {
        client.close();
    }
    
}
