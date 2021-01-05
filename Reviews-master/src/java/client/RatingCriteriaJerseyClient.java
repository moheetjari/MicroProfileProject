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
 * Jersey REST client generated for REST resource:RatingcriteriaResource
 * [ratingcriteria]<br>
 * USAGE:
 * <pre>
 *        RatingCriteriaJerseyClient client = new RatingCriteriaJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class RatingCriteriaJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ReviewBaseSystem/webresources";

    public RatingCriteriaJerseyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("ratingcriteria");
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

    public <T> T allRatingCriteria(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void deleteRatingCriteria(String ratingcriteriaid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteRatingCriteria/{0}", new Object[]{ratingcriteriaid})).request().post(null);
    }

    public void updateRatingCriteria(String ratingcriteriaid, String ratingcriterianame) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateRatingCriteria/{0}/{1}", new Object[]{ratingcriteriaid, ratingcriterianame})).request().post(null);
    }

    public <T> T getRatingCriteria(Class<T> responseType, String ratingcriteriaid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getRatingCriteria/{0}", new Object[]{ratingcriteriaid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addRatingCriteria(String ratingcriterianame) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addRatingCriteria/{0}", new Object[]{ratingcriterianame})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
