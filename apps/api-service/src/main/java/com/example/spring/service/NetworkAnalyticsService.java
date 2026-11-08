package com.example.spring.service;

import com.example.spring.entity.postgres.AggIpConnections;
import com.example.spring.projection.IpBandwidthProjection;
import com.example.spring.projection.IpTrafficSummaryProjection;
import com.example.spring.projection.ProtocolUsageProjection;
import com.example.spring.repository.postgres.AggIpConnectionsRepository;
import com.example.spring.repository.postgres.AggIpTrafficRepository;
import com.example.spring.repository.postgres.AggProtocolUsageRepository;
import java.time.OffsetDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NetworkAnalyticsService {

  private final AggIpTrafficRepository trafficRepository;
  private final AggIpConnectionsRepository connectionRepository;
  private final AggProtocolUsageRepository protocolRepository;

  public IpTrafficSummaryProjection getIpTrafficSummary(
      String ip, OffsetDateTime start, OffsetDateTime end) {
    return trafficRepository.getTrafficSummaryForIp(ip, start, end);
  }

  public Page<AggIpConnections> getIpConnections(
      String ip, OffsetDateTime start, OffsetDateTime end, Pageable pageable) {
    return connectionRepository.getConnectionsForIp(ip, start, end, pageable);
  }

  public List<IpBandwidthProjection> getTopBandwidthConsumers(
      OffsetDateTime start, OffsetDateTime end, int limit) {
    return trafficRepository.getTopIpsByBandwidth(start, end, PageRequest.of(0, limit));
  }

  public List<ProtocolUsageProjection> getMostUsedProtocols(
      OffsetDateTime start, OffsetDateTime end, int limit) {
    return protocolRepository.getTopUsedProtocols(start, end, PageRequest.of(0, limit));
  }
}
