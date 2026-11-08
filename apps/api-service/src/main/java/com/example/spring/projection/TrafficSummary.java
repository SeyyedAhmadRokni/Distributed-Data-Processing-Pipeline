package com.example.spring.projection;

import lombok.Value;

@Value
public class TrafficSummary implements IpTrafficSummaryProjection {
  Long totalInBytes;
  Long totalOutBytes;
  Long totalBytes;
}
