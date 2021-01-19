package com.puzan.springhandson.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

import com.puzan.springhandson.model.Category;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SettingConverter implements AttributeConverter<Category, String> {
 
    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public Category convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Category.values())
          .filter(c -> c.getCode().equals(code))
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
}