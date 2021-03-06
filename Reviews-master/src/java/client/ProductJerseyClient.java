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
 * Jersey REST client generated for REST resource:ProductResource [product]<br>
 * USAGE:
 * <pre>
 *        ProductJerseyClient client = new ProductJerseyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author hi
 */
public class ProductJerseyClient {

    private WebTarget webTarget;
    private Client client;
    private static final String BASE_URI = "https://localhost:8181/ReviewBaseSystem/webresources";

    public ProductJerseyClient(String token) {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        client.register(new RestFilter(token));
        webTarget = client.target(BASE_URI).path("product");
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

    public <T> T getProduct(Class<T> responseType, String productid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("getProduct/{0}", new Object[]{productid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void addProduct(String categoryid, String productname, String productimage, String referencelink, String authorid, String genreid, String publisherid, String companyid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("addProduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{categoryid, productname, productimage, referencelink, authorid, genreid, publisherid, companyid})).request().post(null);
    }

    public void updateProduct(String productid, String categoryid, String productname, String referencelink, String authorid, String genreid, String publisherid, String companyid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateProduct/{0}/{1}/{2}/{3}/{4}/{5}/{6}/{7}", new Object[]{productid, categoryid, productname, referencelink, authorid, genreid, publisherid, companyid})).request().post(null);
    }

    public <T> T allProduct(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void updateImage(String productid, String productimage) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("updateImage/{0}/{1}", new Object[]{productid, productimage})).request().post(null);
    }

    public void deleteProduct(String productid, String categoryid) throws ClientErrorException {
        webTarget.path(java.text.MessageFormat.format("deleteProduct/{0}/{1}", new Object[]{productid, categoryid})).request().post(null);
    }

    public void close() {
        client.close();
    }

}
