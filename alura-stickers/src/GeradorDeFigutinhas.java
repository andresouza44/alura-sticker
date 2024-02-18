import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

public class GeradorDeFigutinhas {

    public void cria(InputStream inputStream, String fileName) throws Exception {

/*        InputStream inputStream = new FileInputStream("images/filme2.jpg");
        InputStream inputStream = new URL("https://m.media-amazon.com/images/M/MV5BMzE5MDM1NDktY2I0OC00YWI5LTk2NzUtYjczNDczOWQxYjM0XkEyXkFqcGdeQXVyMTQxNzMzNDI@.jpg")
                .openStream();
*/

        BufferedImage originalImage = ImageIO.read(inputStream);

        int largura = originalImage.getWidth();
        int altura = originalImage.getHeight();
        int novaAltura = altura + 200;

        var newImage = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

        Graphics2D graphics = (Graphics2D) newImage.getGraphics();
        graphics.drawImage(originalImage, 0, 0, null);

        var font = new Font(Font.SANS_SERIF,Font.ITALIC, 32);

        var text = "Topzera !";
        var textLength = font.getSize()*(text.length());
        var textPosition = (largura/2 - textLength/4);

        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        graphics.drawString(text, textPosition,novaAltura-100);

        ImageIO.write(newImage, "png", new File("saida/" + fileName));

    };
/*
    public static void main(String[] args) throws Exception {
        GeradorDeFigutinhas figura = new GeradorDeFigutinhas();
        figura.cria();
    }*/

}