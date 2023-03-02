package kz.dar.tech.commentservice.service;

import kz.dar.tech.commentservice.util.Indices;
import kz.dar.tech.commentservice.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class IndexService {
    private final List<String> INDICES_TO_CREATE = List.of(Indices.COMMENT_INDEX);
    private final RestHighLevelClient client;

    @PostConstruct
    public void tryToCreateIndices() {

        final String settings = Util.loadAsString("static/es-settings.json");

        for (final String indexName : INDICES_TO_CREATE) {
            try {
                boolean indexExists = client.indices().exists(new GetIndexRequest(indexName), RequestOptions.DEFAULT);
                if (indexExists) {
                    continue;
                }

                final String mappings = Util.loadAsString("static/mappings/" + indexName + ".json");
                if (settings == null || mappings == null) {
                    log.error("Failed to create index with name '{}'", indexName);
                    continue;
                }
                final CreateIndexRequest createIndexRequest = new CreateIndexRequest(indexName);
                createIndexRequest.settings(settings, XContentType.JSON);
                createIndexRequest.mapping(mappings, XContentType.JSON);

                client.indices().create(createIndexRequest, RequestOptions.DEFAULT);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }
    }
}
