package metodos;

public class GeradorEstrelasRatio {
    public static String printStar (String star){
        int starInteger = (int) Math.round(Double.parseDouble(star));

        return switch (starInteger) {
            case 1 -> "⭐";
            case 2 -> "⭐⭐";
            case 3 -> "⭐⭐⭐";
            case 4 -> "⭐⭐⭐⭐";
            case 5 -> "⭐⭐⭐⭐⭐";
            case 6 -> "⭐⭐⭐⭐⭐⭐";
            case 7 -> "⭐⭐⭐⭐⭐⭐⭐";
            case 8 -> "⭐⭐⭐⭐⭐⭐⭐⭐";
            case 9 -> "⭐⭐⭐⭐⭐⭐⭐⭐⭐";
            case 10 -> "⭐⭐⭐⭐⭐⭐⭐⭐⭐⭐";
            default -> "";
        };
    }

}
