package example.model;

import lombok.*;
import groovy.json.*
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@Document(indexName = "dog-demo", createIndex=true)
class Dog {

  @Field(type = FieldType.Long)
  Long id;

  @Field(type = FieldType.Text)
  String breed;

  @Field(type = FieldType.Text)
  String color;

  Dog(Long id,String breed,String color)
  {
    this.id = id;
    this.breed = breed;
    this.color = color;
  }

  def toJson() { return new JsonBuilder( this ).toPrettyString() }
}
