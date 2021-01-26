package com.example.blog.elasticsearch;

import com.example.blog.bll.BlogThread;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThreadElasticsearchRepository extends ElasticsearchRepository<BlogThread, Long> {
    Page<BlogThread> findByText(String text, Pageable pageable);
}
