import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 
 */

/**
 * @author Kemele M. Endris
 *
 */
public class FileSize {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] media = new int[]{2,5,10,20,30,40,50,100};
		for(int i=0; i< media.length; i++){
		 byte[] fileBytes;
	        try {
	            fileBytes = readFile(new File("data-stream/media."+media[i]+".cks")); // Load entire file into a byte array.
	            System.out.print(fileBytes.length+"    ,   ");
	        }
	        catch (Exception ex) {
	            System.err.println(ex.getMessage());
	            System.exit(1); 
	        }
		}

	}

	 protected static byte[] readFile(File file) throws IOException
	    {
	            FileInputStream fin = new FileInputStream(file);
	            try {
	                    ByteArrayOutputStream baos = new ByteArrayOutputStream(1024);
	                    byte[] data = new byte[1024];
	                    while (true) {
	                            int numBytes = fin.read(data);
	                            if (numBytes < 0) break;
	                            baos.write(data, 0, numBytes);
	                    }
	                    return baos.toByteArray();
	            }
	            finally {
	                    fin.close();
	            }
	    }

}
