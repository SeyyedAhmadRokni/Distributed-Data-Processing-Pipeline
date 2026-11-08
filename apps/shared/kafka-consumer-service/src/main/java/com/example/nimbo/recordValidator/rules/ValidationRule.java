package com.example.nimbo.recordValidator.rules;

import org.apache.avro.generic.GenericRecord;

public interface ValidationRule {

  boolean isValid(GenericRecord record);
}
