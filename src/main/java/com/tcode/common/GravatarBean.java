package com.tcode.common;

import de.bripkens.gravatar.DefaultImage;
import de.bripkens.gravatar.Gravatar;
import de.bripkens.gravatar.Rating;
import org.springframework.stereotype.Component;

/**
 * Created by Sergey Roshchupkin on 11/15/2015.
 */
@Component
public class GravatarBean {

    public String buildGravatarUrl(String email) {
        return new Gravatar()
                .setSize(60)
                .setHttps(true)
                .setRating(Rating.PARENTAL_GUIDANCE_SUGGESTED)
                .setStandardDefaultImage(DefaultImage.IDENTICON)
                .getUrl(email);
    }
}
