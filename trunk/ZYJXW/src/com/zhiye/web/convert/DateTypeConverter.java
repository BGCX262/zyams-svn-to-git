package com.zhiye.web.convert;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import org.apache.struts2.util.StrutsTypeConverter;

/**
 * Date Type-Converter
 */
public class DateTypeConverter extends StrutsTypeConverter {
    
	public static final String YYMM_DATE_FORMAT = "yyyy-MM";
    public static final String DEFAULT_DATE_FORMAT = "yyyy-MM-dd";
    public static final String DDMMYYYY_DATE_FORMAT = "dd/MM/yyyy";
    public static final String DDMMYYYYHHMMSS_DATE_FORMAT = "dd/MM/yyyy HH:mm:ss";
    public static final String YYYYMMDDHHMMSS_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public final DateFormat[] ACCEPT_DATE_FORMATS = {
            new SimpleDateFormat(DDMMYYYYHHMMSS_DATE_FORMAT),
            new SimpleDateFormat(DDMMYYYY_DATE_FORMAT),
            new SimpleDateFormat(DEFAULT_DATE_FORMAT),
            new SimpleDateFormat(YYMM_DATE_FORMAT),
            new SimpleDateFormat(YYYYMMDDHHMMSS_DATE_FORMAT) };

    /**
     * Date type converter
     *
     */
    public DateTypeConverter() {
    }

    /**
     * Converts one or more String values to the specified class.
     * 
     * @param context
     *            the action context
     * @param values
     *            the String values to be converted, such as those submitted
     *            from an HTML form
     * @param toClass
     *            the class to convert to
     * @return the converted object
     */
    @SuppressWarnings("unchecked")
    public Object convertFromString(Map context, String[] values, Class toClass) {
//    	System.out.println("String转换为时间:"+values[0]);
        if (values[0] == null || values[0].trim().equals(""))
            return null;

        Date errorDate = new Date(-1);
        for (DateFormat format : ACCEPT_DATE_FORMATS) {
            try {
                return format.parse(values[0]);
            } catch (ParseException e) {
                continue;
            } catch (RuntimeException e) {
                continue;
            }
        }

        return errorDate;
    }
    
    /**
     * Converts the specified object to a String.
     * 
     * @param context
     *            the action context
     * @param o
     *            the object to be converted
     * @return the converted String
     */
    @SuppressWarnings("unchecked")
    public String convertToString(Map context, Object o) {
//    	System.out.println("日期转换为时间String");
        if (o instanceof Date) {
            SimpleDateFormat format = new SimpleDateFormat(DEFAULT_DATE_FORMAT);
            try {
                return format.format((Date) o);
            } catch (RuntimeException e) {
                return "";
            }
        }
        return "";
    }
}
