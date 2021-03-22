package com.hnisi.component.es.dataobject;

import com.hnisi.component.es.constant.FieldAnalyzer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author Roger
 * @since 2021/3/22
 */
@Data
@Document(indexName = "product", // 索引名
        type = "product", // 类型。未来的版本即将废弃
        shards = 1, // 默认索引分区数
        replicas = 0, // 每个分区的备份数
        refreshInterval = "-1" // 刷新间隔
)
public class ESProductDO {

    /**
     * ID 主键
     */
    @Id
    private Integer id;

    /**
     * SPU 名字
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String name;
    /**
     * 卖点
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String sellPoint;
    /**
     * 描述
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String description;
    /**
     * 分类编号
     */
    private Integer cid;
    /**
     * 分类名
     */
    @Field(analyzer = FieldAnalyzer.IK_MAX_WORD, type = FieldType.Text)
    private String categoryName;
}
