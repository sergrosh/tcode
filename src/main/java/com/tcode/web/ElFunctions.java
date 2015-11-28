package com.tcode.web;

import com.tcode.persistence.model.CodeType;
import com.tcode.persistence.model.SpringUser;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Sergey on 11/25/2015.
 */
public class ElFunctions {

    private static Map<String, CodeType> xtypeCache = new HashMap<>();

    public static String getMirrorMode(String xtype) {
        return getCodeType(xtype).getCmFileName();
    }

    public static CodeType getCodeType(String xtype) {
        CodeType codeType = xtypeCache.get(xtype);
        if (codeType == null) {
            codeType = CodeType.getByXtype(xtype);
            xtypeCache.put(xtype, codeType);
        }
        return codeType;
    }

    public static String getShBrush(String xtype) {
        return getCodeType(xtype).getShBrush();
    }

    public static String getName(String xtype) {
        return getCodeType(xtype).getName();
    }

    public static String getCmFile(String xtype) {
        return getCodeType(xtype).getCmFileName();
    }

    public static CodeType[] getCodes() {
        return CodeType.values();
    }

    public static String join(Set<String> set, String separator) {
        if (set == null) return "";
        if (separator == null) separator = "";

        StringBuilder buf = new StringBuilder();
        Iterator<String> iterator = set.iterator();

        while (iterator.hasNext()) {
            buf.append(iterator.next());
            if (iterator.hasNext()) {
                buf.append(separator);
            }
        }

        return buf.toString();
    }

    public static boolean isUser(Object ob) {
        return ob instanceof SpringUser;
    }
}

