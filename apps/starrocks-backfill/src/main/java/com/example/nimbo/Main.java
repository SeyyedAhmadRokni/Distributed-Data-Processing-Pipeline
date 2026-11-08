package com.example.nimbo;

import com.example.nimbo.backfill.Backfill;
import com.example.nimbo.backfill.BackfillConfig;

public final class Main {
  public static void main(String[] args) throws Exception {
    new Backfill(new BackfillConfig()).run();
  }
}
