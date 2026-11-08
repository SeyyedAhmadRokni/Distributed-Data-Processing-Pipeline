package com.example.spring.dto.starrocks;

import lombok.Value;

@Value
public class ConnectionInfo {
  String srcIp;
  String dstIp;
}
