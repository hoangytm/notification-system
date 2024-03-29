package com.hoangyth.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(indexName = "product", shards = 1, replicas = 0, refreshInterval = "5s", createIndex = true)
public class Product {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String name;

    @Field(type = FieldType.Keyword)
    private Category category;

    @Field(type = FieldType.Long)
    private double price;

    public enum Category {
        CLOTHES,
        ELECTRONICS,
        GAMES;
    }
}