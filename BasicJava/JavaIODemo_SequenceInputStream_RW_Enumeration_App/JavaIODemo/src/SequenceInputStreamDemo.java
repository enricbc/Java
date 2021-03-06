import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.SequenceInputStream;
import java.util.Enumeration;
import java.util.Vector;

/*
 * public SequenceInputStream(Enumeration<? extends
 *                                     InputStream> e)
 * 
 * Parameters: 
 * ----------- 
 * 
 * e - an enumeration of input streams.
 */

public class SequenceInputStreamDemo
{

	public static void main(String[] args) throws IOException
	{
		FileInputStream fileInputStream1 = null;
		FileInputStream fileInputStream2 = null;
		FileInputStream fileInputStream3 = null;
		FileOutputStream fileOutputStream = null;
		SequenceInputStream sequenceInputStream = null;

		try
		{
			fileInputStream1 = new FileInputStream("myfile1.txt");
			fileInputStream2 = new FileInputStream("myfile2.txt");
			fileInputStream3 = new FileInputStream("myfile3.txt");

			fileOutputStream = new FileOutputStream("myoutputfile.txt");

			Vector<FileInputStream> vector = new Vector<FileInputStream>();
			vector.add(fileInputStream1);
			vector.add(fileInputStream2);
			vector.add(fileInputStream3);

			Enumeration<FileInputStream> enumeration = vector.elements();

			sequenceInputStream = new SequenceInputStream(enumeration);
			int i;
			while ((i = sequenceInputStream.read()) != -1)
			{
				fileOutputStream.write(i);
			}
			System.out
					.println("Successfully read from 3 files and written to one file.");
		}
		finally
		{
			if (fileInputStream1 != null)
			{
				fileInputStream1.close();
			}
			if (fileInputStream2 != null)
			{
				fileInputStream2.close();
			}
			if (fileInputStream3 != null)
			{
				fileInputStream3.close();
			}
			if (fileOutputStream != null)
			{
				fileOutputStream.close();
			}
			if (sequenceInputStream != null)
			{
				sequenceInputStream.close();
			}
		}
	}

}
