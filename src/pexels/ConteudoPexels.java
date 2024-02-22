package pexels;

import java.util.List;

public record ConteudoPexels (String alt, String photographer, src src){

    public static record src(
            String original,
            String large2x,
            String large,
            String medium,
            String small,
            String portrait,
            String landscape,
            String tiny
    ) {}
}

