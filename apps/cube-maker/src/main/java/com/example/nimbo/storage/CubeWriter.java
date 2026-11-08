package com.example.nimbo.storage;

import com.example.nimbo.cube.maker.BasicCubeMaker;
import java.sql.SQLException;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

public interface CubeWriter extends AutoCloseable {
  void writeCube(Dataset<Row> dataframe, BasicCubeMaker maker) throws SQLException;

  @Override
  void close() throws SQLException;
}
