package com.example.spring.service;

import com.example.spring.dto.starrocks.ConnectionInfo;
import com.example.spring.dto.starrocks.IpBandwidth;
import com.example.spring.dto.starrocks.ProtocolUsage;
import com.example.spring.dto.starrocks.TrafficSummary;
import com.example.spring.repository.starrocks.NetflowRawRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NetflowService {

  private final NetflowRawRepository netflowRepository;

  public TrafficSummary getIpTrafficSummary(String ip, Long startTimeMs, Long endTimeMs) {
    return netflowRepository.getTrafficSummaryForIp(ip, startTimeMs, endTimeMs);
  }

  public Page<ConnectionInfo> getIpConnections(
      String ip, Long startTimeMs, Long endTimeMs, Pageable pageable) {
    return netflowRepository.getConnectionsForIp(ip, startTimeMs, endTimeMs, pageable);
  }

  public Page<IpBandwidth> getTopBandwidthConsumers(Long startTimeMs, Long endTimeMs, int limit) {
    PageRequest pageRequest = PageRequest.of(0, limit);
    return netflowRepository.getTopIpsByBandwidth(startTimeMs, endTimeMs, pageRequest);
  }

  public Page<ProtocolUsage> getMostUsedProtocols(Long startTimeMs, Long endTimeMs, int limit) {
    PageRequest pageRequest = PageRequest.of(0, limit);
    return netflowRepository.getTopUsedProtocols(startTimeMs, endTimeMs, pageRequest);
  }
}
