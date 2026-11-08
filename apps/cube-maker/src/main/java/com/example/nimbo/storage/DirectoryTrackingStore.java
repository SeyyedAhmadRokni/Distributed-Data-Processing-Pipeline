package com.example.nimbo.storage;

import java.sql.SQLException;
import java.util.Set;

public interface DirectoryTrackingStore {
  Set<String> getProcessedDirectories() throws SQLException;

  void markDirectoryAsProcessed(String path) throws SQLException;
}
