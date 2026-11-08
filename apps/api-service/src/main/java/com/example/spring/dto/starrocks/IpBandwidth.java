package com.example.spring.dto.starrocks;

import lombok.Value;

@Value
public class IpBandwidth {
  String ip;
  Long totalBandwidth;
}
