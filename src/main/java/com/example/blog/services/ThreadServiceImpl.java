package com.example.blog.services;

import com.example.blog.bll.BlogThread;
import com.example.blog.elasticsearch.ThreadElasticsearchRepository;
import com.example.blog.repository.ThreadRepository;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ThreadServiceImpl implements ThreadService{
    @Autowired
    private ThreadRepository threadRepository;

    @Autowired
    private ThreadElasticsearchRepository threadElasticsearchRepository;

    @Value("${elasticsearch.index}")
    private String indexFull;

    @Autowired
    private RestHighLevelClient client;

    public void postThread (BlogThread thread) {
        threadRepository.save(thread);
        threadElasticsearchRepository.save(thread);
    }

        public List<String> fullTextSearch(String key) throws IOException {

            List<String> result = new ArrayList<>();
            SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder().size(10).
                    query(QueryBuilders.matchQuery("text", key));

            SearchRequest searchRequest = new SearchRequest(new String[]{indexFull}, searchSourceBuilder);
            SearchResponse searchResponse;
            searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);

            SearchHits hits = searchResponse.getHits();
            SearchHit[] searchHits = hits.getHits();
            for (SearchHit hit : searchHits) {
                result.add(hit.getId());
            }
            return result;
        }

    public List<BlogThread> getAllThreads() {
        return threadRepository.findAll();
    }

    public BlogThread getThreadById(Long id) {
        return threadRepository.findById(id).get();
    }
}
