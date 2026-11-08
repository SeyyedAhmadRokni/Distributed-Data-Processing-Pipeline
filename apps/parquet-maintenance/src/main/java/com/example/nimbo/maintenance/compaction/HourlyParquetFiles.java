package com.example.nimbo.maintenance.compaction;

import java.util.List;
import org.apache.hadoop.fs.Path;

record HourlyParquetFiles(Path path, List<ParquetFileSnapshot> files) {}
