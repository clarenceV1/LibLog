package com.cai.lib.logger;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static com.cai.lib.logger.Utils.checkNotNull;

public class AndroidLogAdapter implements  LogAdapter {

  @NonNull private final  FormatStrategy formatStrategy;

  public AndroidLogAdapter() {
    this.formatStrategy =  PrettyFormatStrategy.newBuilder().build();
  }

  public AndroidLogAdapter(@NonNull  FormatStrategy formatStrategy) {
    this.formatStrategy = checkNotNull(formatStrategy);
  }

  @Override public boolean isLoggable(int priority, @Nullable String tag) {
    return true;
  }

  @Override public void log(int priority, @Nullable String tag, @NonNull String message) {
    formatStrategy.log(priority, tag, message);
  }

}
