/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JSFBeans;

//import client.NewsJerseyClient;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import models.NewsEntity;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 *
 * /**
 *
 * @author hi
 */
@Named(value = "newsManagedBean")
@RequestScoped
public class NewsManagedBean {

//    NewsJerseyClient njc = new NewsJerseyClient();
    private String author, title, description, url, urlToImage, publishedAt, content;
    private Collection<NewsEntity> lstNews;
    private Collection<NewsEntity> lstNews1;
    private String BaseUri = "http://newsapi.org/v2/top-headlines";
    private String apiKey = "apiKey=f14e8adede4044139ea49f208c73dcb8";
    private String category;

    public NewsManagedBean() {

    }


    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }

    public String getPublishedAt() {
        return publishedAt;
    }

    public void setPublishedAt(String publishedAt) {
        this.publishedAt = publishedAt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Collection<NewsEntity> getLstNews() {
        return lstNews;
    }

    public void setLstNews(Collection<NewsEntity> lstNews) {
        this.lstNews = lstNews;
    }

    public Collection<NewsEntity> getLstNews1() {
        return lstNews1;
    }

    public void setLstNews1(Collection<NewsEntity> lstNews1) {
        this.lstNews1 = lstNews1;
    }
    

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    @PostConstruct
    public void init() {
        lstNews = new ArrayList<NewsEntity>();
        getAllNews();
    }

    public String fetchCategory(String cat)
    {   
        System.out.println(cat);
        this.category=cat;
        return category;
    }
    
    
    public void getAllNews()
    {
        System.out.println("in all news");
        String result = null;
        String query_url;
        JSONObject myResponse = null;
        query_url = BaseUri + "?country=in&" + apiKey;
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            //System.out.println(result);
            myResponse = new JSONObject(result);
            JSONArray jSONArray = myResponse.getJSONArray("articles");
            for (int i = 0; i < jSONArray.length(); i++) {
                //System.out.println(jSONArray.getJSONObject(i).get("author"));
                NewsEntity ne = new NewsEntity();
                //System.out.println(i);
                if (jSONArray.getJSONObject(i).get("author").equals(null)) 
                {
                    //System.out.println("in if");
                    ne.setAuthor("UNKNOWN");
                } 
                else 
                {
                    //System.out.println("in else");
                    ne.setAuthor((String) jSONArray.getJSONObject(i).get("author"));
                }

                if (jSONArray.getJSONObject(i).get("title").equals(null)) 
                {
                    ne.setTitle("UNKNOWN");
                } 
                else 
                {
                    ne.setTitle((String) jSONArray.getJSONObject(i).get("title"));
                }

                if (jSONArray.getJSONObject(i).get("description").equals(null)) 
                {
                    ne.setDescription("null");
                } 
                else 
                {
                    ne.setDescription((String) jSONArray.getJSONObject(i).get("description"));
                }

                if (jSONArray.getJSONObject(i).get("url").equals(null)) 
                {
                    ne.setUrl("null");
                }
                else
                {
                    ne.setUrl((String) jSONArray.getJSONObject(i).get("url"));
                }

                if (jSONArray.getJSONObject(i).get("urlToImage").equals(null)) 
                {
                    ne.setUrlToImage("null");
                } 
                else 
                {
                    ne.setUrlToImage((String) jSONArray.getJSONObject(i).get("urlToImage"));
                }
                
                if (jSONArray.getJSONObject(i).get("publishedAt").equals(null))
                {
                    ne.setPublishedAt("UNKNOWN");
                } 
                else
                {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    Date date = dateFormat.parse((String) jSONArray.getJSONObject(i).get("publishedAt"));//You will get date object relative to server/client timezone wherever it is parsed
                    DateFormat formatter = new SimpleDateFormat("dd MMM, YYYY HH:mm:ss"); //If you need time just put specific format for time like 'HH:mm:ss'
                    String dateStr = formatter.format(date);
//                    ne.setPublishedAt((String) jSONArray.getJSONObject(i).get("publishedAt"));
                    ne.setPublishedAt(dateStr);
                }
                
                if (jSONArray.getJSONObject(i).get("content").equals(null))
                {
                    ne.setContent("UNKNOWN");
                } 
                else
                {
                    ne.setContent((String) jSONArray.getJSONObject(i).get("content"));
                }
                
                lstNews.add(ne);
                //System.out.println(ne);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }
    
    
    public void getAllNewsByCategory(String cat)
    {
        System.out.println("news "+cat);
        String result = null;
        String query_url;
        JSONObject myResponse = null;
        query_url = BaseUri + "?country=in&"+"category="+cat+"&" + apiKey;
        lstNews=new ArrayList<NewsEntity>();
        try {
            URL url = new URL(query_url);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(conn.getInputStream());
            result = IOUtils.toString(in, "UTF-8");
            System.out.println(result);
            myResponse = new JSONObject(result);
            JSONArray jSONArray = myResponse.getJSONArray("articles");
            for (int i = 0; i < jSONArray.length(); i++) {
                //System.out.println(jSONArray.getJSONObject(i).get("author"));
                NewsEntity ne = new NewsEntity();
                //System.out.println(i);
                if (jSONArray.getJSONObject(i).get("author").equals(null)) 
                {
                    //System.out.println("in if");
                    ne.setAuthor("UNKNOWN");
                } 
                else 
                {
                    //System.out.println("in else");
                    ne.setAuthor((String) jSONArray.getJSONObject(i).get("author"));
                }

                if (jSONArray.getJSONObject(i).get("title").equals(null)) 
                {
                    ne.setTitle("UNKNOWN");
                } 
                else 
                {
                    ne.setTitle((String) jSONArray.getJSONObject(i).get("title"));
                }

                if (jSONArray.getJSONObject(i).get("description").equals(null)) 
                {
                    ne.setDescription("null");
                } 
                else 
                {
                    ne.setDescription((String) jSONArray.getJSONObject(i).get("description"));
                }

                if (jSONArray.getJSONObject(i).get("url").equals(null)) 
                {
                    ne.setUrl("null");
                }
                else
                {
                    ne.setUrl((String) jSONArray.getJSONObject(i).get("url"));
                }

                if (jSONArray.getJSONObject(i).get("urlToImage").equals(null)) 
                {
                    ne.setUrlToImage("null");
                } 
                else 
                {
                    ne.setUrlToImage((String) jSONArray.getJSONObject(i).get("urlToImage"));
                }
                
                if (jSONArray.getJSONObject(i).get("publishedAt").equals(null))
                {
                    ne.setPublishedAt("UNKNOWN");
                } 
                else
                {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
                    Date date = dateFormat.parse((String) jSONArray.getJSONObject(i).get("publishedAt"));//You will get date object relative to server/client timezone wherever it is parsed
                    DateFormat formatter = new SimpleDateFormat("dd MMM, YYYY HH:mm:ss"); //If you need time just put specific format for time like 'HH:mm:ss'
                    String dateStr = formatter.format(date);
//                    ne.setPublishedAt((String) jSONArray.getJSONObject(i).get("publishedAt"));
                    ne.setPublishedAt(dateStr);
                }
                
                if (jSONArray.getJSONObject(i).get("content").equals(null))
                {
                    ne.setContent("UNKNOWN");
                } 
                else
                {
                    ne.setContent((String) jSONArray.getJSONObject(i).get("content"));
                }
                
                lstNews.add(ne);
                System.out.println(ne);
                for (NewsEntity l : lstNews) {
                    System.out.println(l.getAuthor());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }

}
