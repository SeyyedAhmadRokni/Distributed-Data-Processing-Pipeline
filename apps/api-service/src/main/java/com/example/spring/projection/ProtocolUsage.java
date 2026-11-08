package com.example.spring.projection;

import lombok.Value;

@Value
public class ProtocolUsage implements ProtocolUsageProjection {
  Integer protocol;
  Long totalBytes;
}
