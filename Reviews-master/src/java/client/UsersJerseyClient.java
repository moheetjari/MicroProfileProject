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
 * Jersey REST client generated for REST resource:UserResource [user]<br>
 * USAGE:
 * <pre>
 *        UsersJerseyClient client = new UsersJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class UsersJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ReviewBaseSystem/webresources";

    public UsersJerseyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("user");
    }

    static {
        //for localhost testing only
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                new javax.net.ssl.HostnameVerifier() {

            public boolean verify(String hostname,
                    javax.net.ssl.SSLSession sslSession) {
                if (hostname.equals("localhost")) {
                    return true;
                }
                return false;
            }
        });
    }

    public void putJson(Object requestEntity) throws ClientErrorException {
        webTarget.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getUserById(Class<T> responseType, String uid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getUserById/{0}", new Object[]{uid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addUser(String name, String phno, String pass, String interest, String gender, String email, String city, String bdate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("adduser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{name, phno, pass, interest, gender, email, city, bdate})).request().post(null);
    }

    public void deleteUser(String uid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteuser/{0}", new Object[]{uid})).request().delete();
    }

    public <T> T getAllUser(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateUser(String uid, String name, String phno, String interest, String gender, String email, String city, String bdate) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateuser/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{uid, name, phno, interest, gender, email, city, bdate})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
