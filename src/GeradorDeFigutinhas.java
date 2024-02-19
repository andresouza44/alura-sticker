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

        var font = new Font("Comic Sans MS",Font.ITALIC, 64);

        var text = "Topzera !";
        var textLength = font.getSize()*(text.length());
        var textHorizontalposition = (largura/2 - textLength/4);

        graphics.setFont(font);
        graphics.setColor(Color.YELLOW);
        graphics.drawString(text, textHorizontalposition,novaAltura-100);

        // Colocar Contorno na Imagem
        Color borderColor = Color.BLACK;
        Stroke stroke = new BasicStroke(5);
        graphics.setColor(borderColor);
        graphics.setStroke(stroke);

        graphics.drawRect( 0, 0, largura, novaAltura );

        // Colocar contorno no Texto
        graphics.drawRect(textHorizontalposition-50,novaAltura-180,textLength-160,120);

        ImageIO.write(newImage, "png", new File("saida/" + fileName));

    };
/*
    public static void main(String[] args) throws Exception {
        InputStream inputStream = new FileInputStream("images/filme2.jpg");
        GeradorDeFigutinhas figura = new GeradorDeFigutinhas();
        figura.cria(inputStream,"teste.png");
        }
  */
    }

