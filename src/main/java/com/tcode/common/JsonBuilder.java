package com.tcode.common;

import com.tcode.persistence.model.CodeMirrorTheme;
import com.tcode.persistence.model.SiteTheme;
import com.tcode.persistence.model.SyntaxHighlighterTheme;
import org.springframework.stereotype.Component;

import java.util.Iterator;
import java.util.Set;

/**
 * Created by Sergey on 11/15/2015.
 */
@Component
public class JsonBuilder {

    public String buildCodeThemesJson() {
        StringBuffer buffer = new StringBuffer("[");

        CodeMirrorTheme [] types = CodeMirrorTheme.values();
        for (int i = 0; i < types.length; i++) {
            CodeMirrorTheme type = types[i];
            buffer.append("{\"text\":\"").append(type.getName()).append("\",\"value\":\"").append(type).append("\"}");
            if (i != types.length - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public String buildSiteThemesJson() {
        StringBuffer buffer = new StringBuffer("[");

        SiteTheme[] types = SiteTheme.values();
        for (int i = 0; i < types.length; i++) {
            SiteTheme type = types[i];
            buffer.append("{\"text\":\"").append(type.getName()).append("\",\"value\":\"").append(type).append("\"}");
            if (i != types.length - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public String buildSyntaxHighlighterJson() {
        StringBuffer buffer = new StringBuffer("[");

        SyntaxHighlighterTheme[] types = SyntaxHighlighterTheme.values();
        for (int i = 0; i < types.length; i++) {
            SyntaxHighlighterTheme type = types[i];
            buffer.append("{\"text\":\"").append(type.getName()).append("\",\"value\":\"").append(type).append("\"}");
            if (i != types.length - 1) {
                buffer.append(",");
            }
        }
        buffer.append("]");
        return buffer.toString();
    }

    public String buildEnabledValuesJson() {
        StringBuffer buffer = new StringBuffer("[");
        buffer.append("{\"text\":\"").append("publish").append("\",\"value\":\"").append("true").append("\"}");
        buffer.append(",");
        buffer.append("{\"text\":\"").append("unpublish").append("\",\"value\":\"").append("false").append("\"}");
        buffer.append("]");
        return buffer.toString();
    }

    public String toArray(Set<String> set) {
        Iterator<String> iterator = set.iterator();
        StringBuilder result = new StringBuilder("[");
        while (iterator.hasNext()) {
            String str = iterator.next();
            result.append("&quot;").append(str).append("&quot;");
            if (iterator.hasNext()) {
                result.append(",");
            }
        }
        result.append("]");
        return result.toString();
    }
}