package com.example.nimbo.kafka;

public enum WriteResult {
  SUCCESS_NO_COMMIT,
  SUCCESS,
  RETRY,
  STOP
}
