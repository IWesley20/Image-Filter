import java.io.File;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
/**
 * The Grayscale filter removes colors from an image.
 * 
 * @author Isaiah Wesley 
 * @version May 6, 2016
 */
public class Grayscale extends Filter
{
     /**
     * Constructor for objects of class Grayscale
     * @param name The name of the filter.
     */
    public Grayscale(String name)
    {
        super(name);
    }
    
    /**
     * Apply this filter to an image.
     * 
     * @param  image   The image to be changed by this filter. 
     */
    public void apply (OFImage image)
    {
        int height = image.getHeight();
        int width = image.getWidth();
               
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                int p = image.getRGB(x, y);
                
                int a = (p>>24)&0xff;
                int r = (p>>16)&0xff;
                int g = (p>>8)&0xff;
                int b = p&0xff;
                
                int avg = (r+g+b)/3;
                
                p = (a<<24) | (avg<<16) | (avg<<8) | avg;
                
                image.setRGB(x, y, p);
            }
        }
    }
}
      
    
