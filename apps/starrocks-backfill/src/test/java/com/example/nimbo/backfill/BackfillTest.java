package com.example.nimbo.backfill;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;
import org.junit.jupiter.api.Test;

class BackfillTest {
  private static final ZoneId LOCAL_TZ = ZoneId.of("UTC");

  @Test
  void createsOnePartitionForAWindowInsideOneDay() {
    Instant start = Instant.parse("2026-09-20T10:00:00Z");
    Instant end = Instant.parse("2026-09-20T11:00:00Z");

    assertEquals(List.of(LocalDate.of(2026, 9, 20)), Backfill.partitionDays(start, end, LOCAL_TZ));
  }

  @Test
  void includesBothDaysWhenTheWindowCrossesLocalMidnight() {
    Instant start = Instant.parse("2026-09-20T20:00:00Z");
    Instant end = Instant.parse("2026-09-20T21:00:00Z");

    assertEquals(
        List.of(LocalDate.of(2026, 9, 20), LocalDate.of(2026, 9, 21)),
        Backfill.partitionDays(start, end, LOCAL_TZ));
  }

  @Test
  void excludesTheNextDayWhenEndIsExactlyLocalMidnight() {
    Instant start = Instant.parse("2026-09-20T20:00:00Z");
    Instant end = Instant.parse("2026-09-20T20:30:00Z");

    assertEquals(List.of(LocalDate.of(2026, 9, 20)), Backfill.partitionDays(start, end, LOCAL_TZ));
  }

  @Test
  void startsOnTheNewDayWhenStartIsExactlyLocalMidnight() {
    Instant start = Instant.parse("2026-09-20T20:30:00Z");
    Instant end = Instant.parse("2026-09-20T21:00:00Z");

    assertEquals(List.of(LocalDate.of(2026, 9, 21)), Backfill.partitionDays(start, end, LOCAL_TZ));
  }

  @Test
  void includesTheLastMillisecondBeforeLocalMidnight() {
    Instant start = Instant.parse("2026-09-20T20:29:59.999Z");
    Instant end = Instant.parse("2026-09-20T20:30:00Z");

    assertEquals(List.of(LocalDate.of(2026, 9, 20)), Backfill.partitionDays(start, end, LOCAL_TZ));
  }

  @Test
  void includesEveryDayOfAMultiDayWindowInOrder() {
    Instant start = Instant.parse("2026-09-20T10:00:00Z");
    Instant end = Instant.parse("2026-09-22T11:00:00Z");

    assertEquals(
        List.of(LocalDate.of(2026, 9, 20), LocalDate.of(2026, 9, 21), LocalDate.of(2026, 9, 22)),
        Backfill.partitionDays(start, end, LOCAL_TZ));
  }
}
