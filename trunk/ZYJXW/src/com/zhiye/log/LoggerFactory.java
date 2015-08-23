package com.zhiye.log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class LoggerFactory
{
  private static final String defaultConf = "log4j.properties";
  private static final String CLASSPATH = "classpath:";
  private static Map<String, Map<String, Logger>> _loggerList = new HashMap();

  public static void ConfigureProperties() {
    ConfigureProperties(null);
  }

  public static void ConfigureProperties(String conf) {
    InputStream is = null;
    if ((null == conf) || (conf.length() == 0)) {
      is = LoggerFactory.class.getClassLoader().getResourceAsStream(defaultConf);
    } else {
      conf = conf.toLowerCase();
      if (conf.startsWith(CLASSPATH)) {
        String file = conf.substring(CLASSPATH.length());
        is = LoggerFactory.class.getClassLoader().getResourceAsStream(file);
      } else {
        File file = new File(conf);
        if (file.exists())
          try {
            is = new FileInputStream(file);
          } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("Not found file:" + conf);
          }
        else {
          throw new IllegalArgumentException("Not loaded configuration file from:" + conf);
        }
      }
    }

    if (null == is) {
      throw new InstantiationError("Not configured log successfully.");
    }
    Properties p = new Properties();
    try {
      p.load(is);
      PropertyConfigurator.configure(p);
      is.close();
    } catch (Exception e) {
      throw new InstantiationError("Error occured while configuring log,caulsed by:" + e);
    }
  }

  public static Logger getPersistenceLog(String id)
  {
    if (!_loggerList.containsKey(LoggerType.PERSISTENCE)) {
      _loggerList.put(LoggerType.PERSISTENCE, new HashMap());
    }
    Map logger = (Map)_loggerList.get(LoggerType.PERSISTENCE);
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger(LoggerType.PERSISTENCE)));
    }
    return (Logger)logger.get(id);
  }

  public static Logger getPersistenceLog(Class<?> clz) {
    return getPersistenceLog(getClassName(clz));
  }

  public static Logger getPresentationLog(String id)
  {
    if (!_loggerList.containsKey(LoggerType.PRESENTATION)) {
      _loggerList.put(LoggerType.PRESENTATION, new HashMap());
    }
    Map logger = (Map)_loggerList.get(LoggerType.PRESENTATION);
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger(LoggerType.PRESENTATION)));
    }
    return (Logger)logger.get(id);
  }

  public static Logger getPresentationLog(Class<?> clz) {
    return getPresentationLog(getClassName(clz));
  }

  public static Logger getServiceLog(String id)
  {
    if (!_loggerList.containsKey(LoggerType.SERVICE)) {
      _loggerList.put(LoggerType.SERVICE, new HashMap());
    }
    Map logger = (Map)_loggerList.get(LoggerType.SERVICE);
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger(LoggerType.SERVICE)));
    }
    return (Logger)logger.get(id);
  }

  public static Logger getServiceLog(Class<?> clz) {
    return getServiceLog(getClassName(clz));
  }

  public static Logger getSystemLog(String id) {
    if (!_loggerList.containsKey(LoggerType.SYSTEM)) {
      _loggerList.put(LoggerType.SYSTEM, new HashMap());
    }
    Map logger = (Map)_loggerList.get(LoggerType.SYSTEM);
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger(LoggerType.SYSTEM)));
    }
    return (Logger)logger.get(id);
  }

  public static Logger getSystemLog(Class<?> clz) {
    return getSystemLog(getClassName(clz));
  }

  public static Logger getExtLog(String id, String loggerType)
  {
    if (!_loggerList.containsKey(loggerType)) {
      _loggerList.put(loggerType, new HashMap());
    }
    Map logger = (Map)_loggerList.get(loggerType);
    if (!logger.containsKey(id)) {
      logger.put(id, new DefaultLogger(id, LogManager.getLogger(loggerType)));
    }
    return (Logger)logger.get(id);
  }

  public static Logger getExtLog(Class<?> clz, String loggerType) {
    return getExtLog(getClassName(clz), loggerType);
  }

  private static String getClassName(Class<?> clz) {
    return clz.getName();
  }
}
