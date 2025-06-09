import javax.imageio.ImageIO;
import javax.imageio.ImageWriteParam;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Iterator;

public class ResizeAndCompress {
    public static void main(String[] args) throws Exception {
        // Step 1: Load original image
        BufferedImage originalImage = ImageIO.read(new File("input.jpg"));

        // Step 2: Set target resolution (resize to specific width and height)
        int targetWidth = 400;   // change as needed
        int targetHeight = 300;

        // Step 3: Create resized image
        BufferedImage resizedImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = resizedImage.createGraphics();
        g.drawImage(originalImage, 0, 0, targetWidth, targetHeight, null);
        g.dispose();

        // Step 4: Prepare output file and compression
        File compressedFile = new File("resized_compressed.jpg");
        FileOutputStream fos = new FileOutputStream(compressedFile);
        ImageOutputStream ios = ImageIO.createImageOutputStream(fos);

        // Step 5: Get JPEG writer
        Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
        if (!writers.hasNext()) throw new IllegalStateException("No JPEG writer found");
        ImageWriter writer = writers.next();
        writer.setOutput(ios);

        // Step 6: Set compression quality
        ImageWriteParam param = writer.getDefaultWriteParam();
        param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
        param.setCompressionQuality(0.4f); // 40% quality

        // Step 7: Write resized & compressed image
        writer.write(null, new javax.imageio.IIOImage(resizedImage, null, null), param);

        // Cleanup
        ios.close();
        writer.dispose();

        System.out.println("Image resized to " + targetWidth + "x" + targetHeight + " and compressed.");
    }
}
