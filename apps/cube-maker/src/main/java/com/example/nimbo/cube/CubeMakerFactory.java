package com.example.nimbo.cube;

import com.example.nimbo.BatchDirectoryService;
import com.example.nimbo.cube.maker.BasicCubeMaker;
import com.example.nimbo.metrics.CubeMakerMetrics;
import com.example.nimbo.storage.CubeWriter;
import java.util.List;
import org.apache.spark.sql.SparkSession;

public class CubeMakerFactory {

  private CubeMakerFactory() {
    throw new IllegalStateException("Utility class");
  }

  public static CubeMakerService create(
      SparkSession spark,
      List<BasicCubeMaker> producers,
      CubeWriter writer,
      BatchDirectoryService directories,
      CubeMakerMetrics metrics) {
    return new CubeMakerService(spark, List.copyOf(producers), writer, directories, metrics);
  }
}
