package com.zhiye.log;

public abstract interface Logger
{
  public abstract String getLoggerType();

  public abstract boolean debug(String paramString1, String paramString2);

  public abstract boolean debug(String paramString1, String paramString2, String paramString3);

  public abstract boolean debug(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean debug(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);

  public abstract boolean info(String paramString1, String paramString2);

  public abstract boolean info(String paramString1, String paramString2, String paramString3);

  public abstract boolean info(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean info(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);

  public abstract boolean warn(String paramString1, String paramString2);

  public abstract boolean warn(String paramString1, String paramString2, String paramString3);

  public abstract boolean warn(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean warn(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);

  public abstract boolean error(String paramString1, String paramString2);

  public abstract boolean error(String paramString1, String paramString2, String paramString3);

  public abstract boolean error(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean error(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);

  public abstract boolean fatal(String paramString1, String paramString2);

  public abstract boolean fatal(String paramString1, String paramString2, String paramString3);

  public abstract boolean fatal(String paramString1, String paramString2, Throwable paramThrowable);

  public abstract boolean fatal(String paramString1, String paramString2, String paramString3, Throwable paramThrowable);
}

