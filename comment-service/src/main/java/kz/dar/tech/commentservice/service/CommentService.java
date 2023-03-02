package kz.dar.tech.commentservice.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import kz.dar.tech.commentservice.document.Comment;
import kz.dar.tech.commentservice.repository.CommentRepository;
import kz.dar.tech.commentservice.util.Indices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

    private final CommentRepository commentRepository;
    private static final ObjectMapper MAPPER = new ObjectMapper();
    private final RestHighLevelClient client;

    public boolean createComment(
            Comment comment
    ) {
        try {
            final String commentAsString = MAPPER.writeValueAsString(comment);

            final IndexRequest request = new IndexRequest(Indices.COMMENT_INDEX);
            request.id(comment.getId());
            request.source(commentAsString, XContentType.JSON);

            final IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            return response != null && response.status().equals(RestStatus.OK);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return false;
        }
    }

    public Comment getCommentById(
            String id
    ) {
        try {
            final GetResponse documentFields = client.get(
                    new GetRequest(Indices.COMMENT_INDEX, id),
                    RequestOptions.DEFAULT
            );
            if (documentFields == null || documentFields.isSourceEmpty()) {
                return null;
            }

            return MAPPER.readValue(documentFields.getSourceAsString(), Comment.class);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public void deleteComment(
            String id
    ) {
        commentRepository.deleteById(
                id
        );
    }

}
