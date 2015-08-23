 package com.zhiye.log;
 
 import java.text.MessageFormat;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
 
 public class DefaultLogger
   implements Logger
 {
   private static MessageFormat _msgIdFormat = new MessageFormat("[{0}] [{1}] [{2}]:{3}");
 
   private static MessageFormat _msgFormat = new MessageFormat("[{0}] [{1}]:{2}");
   private String _loggerType;
   private org.apache.log4j.Logger _logImpl;
 
   public DefaultLogger(String loggerType)
   {
     this._loggerType = loggerType;
     this._logImpl = LogManager.getLogger(this._loggerType);
   }
 
   public DefaultLogger(org.apache.log4j.Logger logImpl)
   {
     this._logImpl = logImpl;
   }
 
   public DefaultLogger(String loggerType, org.apache.log4j.Logger logImpl)
   {
     this._loggerType = loggerType;
     this._logImpl = logImpl;
   }
 
   public String getLoggerType() {
     return this._loggerType;
   }
 
   public boolean debug(String method, String msg)
   {
     return debug(method, msg, (Throwable)null);
   }
 
   public boolean debug(String method, String userId, String msg)
   {
     return debug(method, userId, msg, null);
   }
 
   public boolean debug(String method, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.DEBUG)) {
       if (null != ex)
         this._logImpl.debug(format(this._loggerType, method, msg), ex);
       else {
         this._logImpl.debug(format(this._loggerType, method, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean debug(String method, String userId, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.DEBUG)) {
       if (null != ex)
         this._logImpl.debug(format(this._loggerType, method, userId, msg), ex);
       else {
         this._logImpl.debug(format(this._loggerType, method, userId, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean error(String method, String msg)
   {
     return error(method, msg, (Throwable)null);
   }
 
   public boolean error(String method, String userId, String msg)
   {
     return error(method, userId, msg, null);
   }
 
   public boolean error(String method, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.ERROR)) {
       if (null != ex)
         this._logImpl.error(format(this._loggerType, method, msg), ex);
       else {
         this._logImpl.error(format(this._loggerType, method, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean error(String method, String userId, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.ERROR)) {
       if (null != ex)
         this._logImpl.error(format(this._loggerType, method, userId, msg), ex);
       else {
         this._logImpl.error(format(this._loggerType, method, userId, msg));
       }
       return true;
     }
 
     return false;
   }
 
   public boolean fatal(String method, String msg)
   {
     return fatal(method, msg, (Throwable)null);
   }
 
   public boolean fatal(String method, String userId, String msg)
   {
     return fatal(method, userId, msg, null);
   }
 
   public boolean fatal(String method, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.FATAL)) {
       if (ex != null)
         this._logImpl.fatal(format(this._loggerType, method, msg), ex);
       else {
         this._logImpl.fatal(format(this._loggerType, method, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean fatal(String method, String userId, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.FATAL)) {
       if (ex != null)
         this._logImpl.fatal(format(this._loggerType, method, userId, msg), ex);
       else {
         this._logImpl.fatal(format(this._loggerType, method, userId, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean info(String method, String msg)
   {
     return info(method, msg, (Throwable)null);
   }
 
   public boolean info(String method, String userId, String msg)
   {
     return info(method, userId, msg, null);
   }
 
   public boolean info(String method, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.INFO)) {
       if (null != ex)
         this._logImpl.info(format(this._loggerType, method, msg), ex);
       else {
         this._logImpl.info(format(this._loggerType, method, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean info(String method, String userId, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.INFO)) {
       if (null != ex)
         this._logImpl.info(format(this._loggerType, method, userId, msg), ex);
       else {
         this._logImpl.info(format(this._loggerType, method, userId, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean warn(String method, String msg)
   {
     return warn(method, msg, (Throwable)null);
   }
 
   public boolean warn(String method, String userId, String msg)
   {
     return warn(method, userId, msg, null);
   }
 
   public boolean warn(String method, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.WARN)) {
       if (null != ex)
         this._logImpl.warn(format(this._loggerType, method, msg), ex);
       else {
         this._logImpl.warn(format(this._loggerType, method, msg));
       }
       return true;
     }
     return false;
   }
 
   public boolean warn(String method, String userId, String msg, Throwable ex) {
     if (this._logImpl.isEnabledFor(Level.WARN)) {
       if (null != ex)
         this._logImpl.warn(format(this._loggerType, method, userId, msg), ex);
       else {
         this._logImpl.warn(format(this._loggerType, method, userId, msg));
       }
       return true;
     }
     return false;
   }
 
   private String format(String loggerType, String method, String userId, String msg) {
     return _msgIdFormat.format(new Object[] { loggerType, method, userId, msg });
   }
 
   private String format(String loggerType, String method, String msg) {
     return _msgFormat.format(new Object[] { loggerType, method, msg });
   }
 }

