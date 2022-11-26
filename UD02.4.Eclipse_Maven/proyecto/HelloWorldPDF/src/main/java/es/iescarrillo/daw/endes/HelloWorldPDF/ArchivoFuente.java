package es.iescarrillo.daw.endes.HelloWorldPDF;

import java.io.File;
import java.io.IOException;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

/**
 * Hello world!
 *
 */
public class ArchivoFuente {

	public static final String DEST = "results/hola_mundo.pdf";

	public static void main(String args[]) throws IOException {
		File file = new File(DEST);
		file.getParentFile().mkdirs();
		new ArchivoFuente().createPdf(DEST);
	}

	public void createPdf(String dest) throws IOException {
		// Initialize PDF writer
		PdfWriter writer = new PdfWriter(dest);
		// Initialize PDF document
		PdfDocument pdf = new PdfDocument(writer);

		// Initialize document
		Document document = new Document(pdf);

		// Add paragraph to the document
		document.add(new Paragraph("¡Hola Mundo!"));

		// Close document
		document.close();
	}
}
