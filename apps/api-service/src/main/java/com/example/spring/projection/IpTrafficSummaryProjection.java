package com.example.spring.projection;

public interface IpTrafficSummaryProjection {
  Long getTotalInBytes();

  Long getTotalOutBytes();

  Long getTotalBytes();
}
