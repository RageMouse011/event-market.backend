package kz.dar.tech.commentservice.repository;

import kz.dar.tech.commentservice.document.Comment;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository
        extends ElasticsearchRepository<Comment, String> {
}
