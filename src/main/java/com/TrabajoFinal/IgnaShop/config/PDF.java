package com.TrabajoFinal.IgnaShop.config;

import java.io.IOException;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.TrabajoFinal.IgnaShop.entity.ArticleEntity;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.Color;

public class PDF {
	private List<ArticleEntity> list;

	public PDF(List<ArticleEntity> articles) {
		this.list = articles;
	}

	private void write(PdfPTable tabla) {
		PdfPCell cell = new PdfPCell();
		cell.setPadding(5);
		cell.setBackgroundColor(Color.CYAN);

		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(Color.WHITE);

		cell.setPhrase(new Phrase("Articulo", font));
		cell.setBackgroundColor(Color.lightGray);
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		tabla.addCell(cell);

		cell.setPhrase(new Phrase("Descripcion", font));
		tabla.addCell(cell);
		cell.setPhrase(new Phrase("Precio", font));
		tabla.addCell(cell);
	}

	private void tableData(PdfPTable tabla) {
		int total = 0;
		for (ArticleEntity article : list) {
			tabla.addCell(article.getName());
			tabla.addCell(article.getDescription());
			tabla.addCell(String.valueOf(article.getPrice()));
			total += article.getPrice();
		}
		tabla.addCell("");
		tabla.addCell("");
		tabla.addCell("Total: " + String.valueOf(total) + " €");
	}

	public void export(HttpServletResponse response) throws DocumentException, IOException {
		Document document = new Document(PageSize.LETTER.rotate());
		PdfWriter.getInstance(document, response.getOutputStream());

		document.open();

		Font font = FontFactory.getFont(FontFactory.COURIER_BOLDOBLIQUE);
		font.setSize(25);
		font.setColor(Color.BLUE);

		
		Image jpg = Image.getInstance(
				"src\\main\\resources\\static\\img\\sdb-logo-big.png");
		document.add(jpg);
		
		Paragraph p = new Paragraph("Detalle de compra", font);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		PdfPTable tabla = new PdfPTable(3);
		tabla.setWidthPercentage(100f);
		tabla.setWidths(new float[] { 1.5f, 3.5f, 1.5f });
		tabla.setSpacingBefore(15);

		write(tabla);
		tableData(tabla);
		document.add(tabla);
		document.close();
	}
}
