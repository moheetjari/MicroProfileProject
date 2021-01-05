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
 * Jersey REST client generated for REST resource:PublisherResource
 * [publisher]<br>
 * USAGE:
 * <pre>
 *        PublisherJerseyClient client = new PublisherJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class PublisherJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ReviewBaseSystem/webresources";

    public PublisherJerseyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("publisher");
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

    public void updatePublisher(String publisherid, String publishername) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updatePublisher/{0}/{1}", new Object[]{publisherid, publishername})).request().post(null);
    }

    public void deletePublisher(String publisherid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deletePublisher/{0}", new Object[]{publisherid})).request().post(null);
    }

    public <T> T allPublisher(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getPublisher(Class<T> responseType, String publisherid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getPublisher/{0}", new Object[]{publisherid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addPublisher(String publishername) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addPublisher/{0}", new Object[]{publishername})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
