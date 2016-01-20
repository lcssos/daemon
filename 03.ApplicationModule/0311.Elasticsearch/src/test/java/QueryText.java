//import org.elasticsearch.action.search.SearchRequestBuilder;
//import org.elasticsearch.action.search.SearchResponse;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.elasticsearch.node.Node;
//import org.elasticsearch.node.NodeBuilder;
//import org.elasticsearch.search.SearchHit;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * Created by lcssos on 16/1/8.
// */
//public class QueryText {
//
//    public static void main(String[] args) {
//        try (Node node = NodeBuilder.nodeBuilder().clusterName("net.01").client(true).node()) {
//            //创建elastic客户端
//            Client client = node.client();
//            //读取查询模板，然后设置参数查询
//            try (BufferedReader bodyReader = new BufferedReader(new InputStreamReader(new FileInputStream("D:\\common.template"), "utf8"))) {
//                String line = null;
//                StringBuilder strBuffer = new StringBuilder();
//                while ((line = bodyReader.readLine()) != null) {
//                    strBuffer.append(line);
//                    strBuffer.append("\n");
//                }
//
//                Map<String, Object> search_params = new HashMap<>();
//                search_params.put("from", 1);
//                search_params.put("size", 5);
//                search_params.put("key_words", "opencv sift");
//
//                QueryBuilder qb = QueryBuilders.templateQuery(strBuffer.toString(), search_params);
//                SearchResponse sr;
//                SearchRequestBuilder srb;
//                srb = client.prepareSearch("blog_v1").setTypes("blogpost").setQuery(qb);
//                sr = srb.get();
//
//                for (SearchHit hit : sr.getHits().getHits()) {
//                    System.out.println(hit.getSourceAsString());
//                }
//
//            } catch (UnsupportedEncodingException ex) {
//
//            } catch (FileNotFoundException ex) {
//
//            } catch (IOException ex) {
//
//            }
//
//        }
//    }
//}