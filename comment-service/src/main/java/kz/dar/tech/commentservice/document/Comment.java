package kz.dar.tech.commentservice.document;

import kz.dar.tech.commentservice.util.Indices;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Setting;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = Indices.COMMENT_INDEX)
@Setting(settingPath = "static/es-settings.json")
public class Comment {
    @Id
    private String id;
    private String content;
}
