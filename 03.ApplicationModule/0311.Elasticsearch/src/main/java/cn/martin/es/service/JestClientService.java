package cn.martin.es.service;

import cn.martin.es.entity.Doctor;
import com.google.common.collect.Maps;
import io.searchbox.client.JestClient;
import io.searchbox.client.JestClientFactory;
import io.searchbox.client.JestResult;
import io.searchbox.client.config.HttpClientConfig;
import io.searchbox.core.Get;
import io.searchbox.core.Index;
import io.searchbox.core.Search;
import io.searchbox.core.SearchResult;
import io.searchbox.indices.CreateIndex;
import io.searchbox.indices.mapping.PutMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lcssos on 16/1/8.
 */
@Component
public class JestClientService {

    @Value("#{configProperties['elasticsearch.url']}")
    private  String url;

    private JestClient client;

    @PostConstruct
    public void init(){
        HttpClientConfig httpClientConfig = new HttpClientConfig.Builder(url).multiThreaded(true).build();
        JestClientFactory factory = new JestClientFactory();
        client = factory.getObject();
    }


    public void createDatebase(String indexName,Integer shardsNumber,Integer replicasNumber){

//        Map<String,String> map = Settings.builder().loadFromSource(settings).build().getAsMap();
//        Settings.Builder settingsBuilder = Settings.settingsBuilder();
//        settingsBuilder.put("number_of_shards",5);
//        settingsBuilder.put("number_of_replicas",1);
//        Map<String,String> map = settingsBuilder.build().getAsMap();

        Map<String,String> map = Maps.newHashMap();
        map.put("number_of_shards",String.valueOf(shardsNumber));
        map.put("number_of_replicas",String.valueOf(replicasNumber));
        try {
            JestResult jestResult = client.execute(new CreateIndex.Builder(indexName).settings(map).build());
            jestResult.getJsonString();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void createTable(String indexName,String typeName){
        PutMapping putMapping = new PutMapping.Builder(
                indexName,
                typeName,
                "{ \"document\" : { \"properties\" : { \"message\" : {\"type\" : \"string\", \"store\" : \"yes\"} } } }"
        ).build();
        try {
            client.execute(putMapping);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void createDocument(String indexName,String typeName,Object source){
        Index index = new Index.Builder(source).index(indexName).type(typeName).build();
        try {
            client.execute(index);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public SearchResult query(String indexName,String typeName,String query){
        String strQuery = "{\n" +
                "    \"query\": {\n" +
                "        \"filtered\" : {\n" +
                "            \"query\" : {\n" +
                "                \"query_string\" : {\n" +
                "                    \"query\" : \""+query+"\"\n" +
                "                }\n" +
                "            }\n" +
                "        }\n" +
                "    }\n" +
                "}";


        Search search = new Search.Builder(strQuery)
                .addIndex(indexName)
                .addType(typeName)
                .build();

        try {
            SearchResult result = client.execute(search);
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    public <T> T get(String indexName,String typeName, String id,Class<T> clazz){
        Get get = new Get.Builder(indexName, id).type(typeName).build();

        JestResult result = null;
        try {
            result = client.execute(get);
            T t = result.getSourceAsObject(clazz);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


}
